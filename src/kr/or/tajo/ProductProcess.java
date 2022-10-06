package kr.or.tajo;

import java.util.Iterator;
import java.util.Map;

//김태우
public class ProductProcess {
	public Map<String,Product> products; //기기목록
	public TajoPrint tajoPrint;
	// 생성자
	public ProductProcess(Map<String, Product> products) {
		this.products = products;
		this.tajoPrint = new TajoPrint();
	}
	public void setProcess(Map<String, Product> products) {
		this.products = products;
	}
	
	//기기 번호 계산 함수 : 김태우
	public String getProductNumber() {
		String returnValue = null;
		
		//목록이 비어있으면 (기기가 없으면) 기기번호를 0으로 지정
		if(products.size() == 0) {
			returnValue = "0";
		} else {
		//기기 번호 구하기(마지막 번호 + 1)
			int productNumber = 0; //번호 임시 저장용 변수
			Iterator it = products.keySet().iterator(); //Product 해시맵에서 키값만 뽑아내기
			while(it.hasNext()) {
				productNumber = Integer.parseInt((String)it.next()); //마지막 키값 구하는 중...
			}
			returnValue = (productNumber + 1) + "";
		}
		return returnValue;
	}// getProductNumber end
	
	//기기 등록 기능 : 김태우
	public void addProduct(String kind, int price, String type) {
		String productNumber = getProductNumber();
		Product p = null;
		switch(type) {
		case "0":
			p = new ProductNormal(productNumber, kind, price);
			break;
		case "1":
			p = new ProductElectric(productNumber, kind, price);
			break;
		case "2":
			p = new ProductOil(productNumber, kind, price);
		}
		
		products.put(productNumber,p);
		System.out.printf("%s번 %s가 분당가격 %d원으로 생성되었습니다.\n", productNumber,kind,price);
	} // addProduct end
	
	//기기 삭제 기능 : 김태우
	public void deleteProduct(String productNo) {
		String input = "";
		//등록되지 않은 기기라면
		if(!products.containsKey(productNo)) {
			System.out.println("존재하지 않는 기기번호입니다.");
		}
		//등록된 기기라면
		//대여중인지 확인
		if(!products.get(productNo).isAble()) {
			System.out.println("대여중인 기기는 삭제가 불가능합니다.");
			return;
		} else {
			System.out.println(products.get(productNo));
			while(true) {
				System.out.print("삭제하시겠습니까? (Y/N) >");
				input = Utils.scanner.nextLine().toLowerCase();
				if(!input.equals("y") && !input.equals("n")) {
					//y나 n이 아닌 다른 값 입력
					System.out.println("올바른 값을 입력해주세요.");
					continue;
				}
				break;
			}
			if(input.equals("y")) {
				products.remove(productNo);
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("삭제 취소되었습니다.");
			}
		}
	} //deleteProduct end
	
	//요금계산 기능 : 김태우
	public long calcul(Product product) {
		//입력받은 제품의 가격, 대여 시작시간, 현재 시간을 사용해서 요금 리턴
		//몇분 대여했는지 계산후 * 가격으로 return
		long diffMin = (product.getStartTime().getTime() - Utils.cal.getTime().getTime()) / 60000;
		return diffMin*product.getPrice();
	}//calcul end
	
	//기기 대여 : 김태우
	public void rentProduct(User user, Product product) {
		//기기가 대여 불가능한 상태라면
		if(!product.isAble()) {
			System.out.println("대여 가능한 기기가 아닙니다.");
			return;
		}
		//충전 기능이 있는 기기면
		if(product instanceof ChargeAble) {
			//충전이 되어 있는지 확인
			if((product instanceof ProductElectric) ? !((ProductElectric)product).isCharged() : !((ProductOil)product).isCharged()) {
				//충전이 되어 있지 않으면
				System.out.println("충전이 필요한 기기입니다.");
				return;
			}
		}
		
		//대여 가능한 기기 + 충전되어있는 기기면 대여 시작
		//유저 대여목록에 추가, 제품 정보 변경(대여여부, 충전)
		user.addRent(product);
		product.setAble(false);
		product.setStartTime(Utils.cal.getTime()); //대여 시작 시간 기록
	}//rentProduct end
	
	//기기 반납 : 김태우
	public Log returnProduct(User user, Product product) {
		//유저가 대여한 대여목록에 product 가 있으면 반납 시작
		//대여중인 기기가 아니면
		if(!user.getRentList().containsKey(product.getNo())) {
			System.out.println("대여중인 기기가 아닙니다.");
			return null;
		}
		//반납 시작
		long amount = calcul(product); //요금
		long input = 0; //입력용 변수
		Log log = new Log(user, product, amount); //출력용 log
		boolean ck = true;
		
		//화면 출력
		log.paymentPrint();
		
		//결제 시작
		System.out.print("결제 금액을 입력해주세요 >");
		input = Long.parseLong(Utils.scanner.nextLine());
		
		if(input > amount) {
			System.out.println(amount + "원 결제되었습니다. 거스름돈 " + (amount - input) + "원 입니다.");
		} else if(input  == amount) {
			System.out.println(amount + "원 결제되었습니다.");
		} else {
			System.out.println("잔액이 부족합니다.");
			ck = false;
		}
		
		if(ck) {
			//결제 성공일 경우
			//유저 대여목록에서 제외, 제품 정보 변경(대여여부, 충전)
			user.deleteRent(product.getNo()); //대여 목록에서 제외
			product.setAble(true); //대여가능 상태 true
			product.setStartTime(null); //대여 시작 시간 초기화
			//충전기능이 있는 기기면 충전상태 변경
			if(product instanceof ChargeAble) {
				if(product instanceof ProductElectric) {
					((ProductElectric)product).charged();
				} else {
					((ProductOil)product).charged();
				}
			}
		} else {
			//결제 실패일 경우
			log = null;
		}
		return log;
	}//returnProduct end

	//기기관리 함수 :김태우
	public Map<String,Product> productProcess() {
		String productNumber = "";
		String productName = "";
		Integer productPirce = 0;
		//1. 기기등록
		//2. 기기삭제
		//3. 기기출력
	loop:while(true) {
//			System.out.println("***************************************");
//			System.out.println("원하시는 메뉴를 선택하세요");
//			System.out.println("***************************************");
//			System.out.println("1. 기기등록 | 2. 기기삭제 | 3. 기기충전 | 4. 기기관리종료");
			int index = tajoPrint.ManagementProductMenu();
			
			switch(index) {
			case 1: //기기등록
				System.out.println("기기의 타입을 입력하세요.(일반 0 | 전기 1 | 기름 2)");
				String typeInput = Utils.scanner.nextLine();
				if(!typeInput.equals("0") && !typeInput.equals("1") && !typeInput.equals("2")) {
					System.out.println(typeInput);
					System.out.println("올바른 입력값이 아닙니다.");
					continue;
				}
				System.out.println("기기의 종류를 입력하세요. ex) 자전거, 킥보드, 자동차 등");
				productName = Utils.scanner.nextLine();
				System.out.println("기기의 분당 가격을 입력하세요");
				productPirce = Integer.parseInt(Utils.scanner.nextLine());
				addProduct(productName, productPirce,typeInput);
				break;
			case 2: //기기삭제
				tajoPrint.productListPrint(products, 0); //전체 기기목록 출력
				System.out.println("삭제할 기기번호를 입력하세요.");
				productNumber = Utils.scanner.nextLine();
				deleteProduct(productNumber);
				break;
			case 3: // 기기충전
				tajoPrint.productListPrint(products, 2); //충전 기능이 있는 기기목록 출력
				
				while(true) {
					System.out.println("충전할 기기번호를 입력하세요(exit로 나가기)");
					productNumber = Utils.scanner.nextLine();
					
					//exit 입력시
					if(productNumber.equals("exit")) {
						System.out.println("충전하기 종료...");
						return products;
					}
					
					// 충전 가능한 기기가 아니라면
					if(!(products.get(productNumber) instanceof ChargeAble)) {
						System.out.println("충전 가능한 기기가 아닙니다.");
						continue;
					}
					
					break;
				}
				
				//충전 가능한 기기라면
				if(products.get(productNumber) instanceof ProductElectric) {
					((ProductElectric)products.get(productNumber)).charged();
				} else {
					((ProductOil)products.get(productNumber)).charged();
				}
				
				System.out.println("충전 완료되었습니다.");
				break;
			case 4:
				System.out.println("기기관리 종료...");
				break loop;
			default :
				System.out.println("올바른 값을 입력해주세요");
			}
		}
			return products;
	}

}
