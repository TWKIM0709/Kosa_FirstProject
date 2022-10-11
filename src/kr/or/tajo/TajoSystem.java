package kr.or.tajo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TajoSystem {
	//변수들 목록, 처리클래스 등
	//스캐너는 Utils 클래스에 static으로 있다.
	private Map<String, User> userList; //유저목록
	private Map<String, Product> productList; //기기목록
	private List<Log> logList; //대여내역목록
	private FileIO file; //파일 입출력 변수
	private String userId; //로그인된 유저 ID
	private TajoSystemInfo systemInfo; //시스템정보
	private ProductProcess process; // 기기관련처리
	private UserManagement management; // 유저관련처리
	
	//생성자
	public TajoSystem() {
		this.userList = new HashMap<String, User>();
		this.productList = new HashMap<String, Product>();
		this.logList = new ArrayList<Log>();
		this.userId = "";
		this.file = new FileIO();
	}
	
	private void saveAll() {
		file.logListSave(logList);
		file.productListSave(productList);
		file.systemInfoListSave(systemInfo);
		file.userListSave(userList);
	}
	
	//run 함수:윤태호
	public void run() {
		// ======================= 초기 파일 불러오기 =======================
		File filerute = new File(Utils.BASICPATH);
		if (filerute.mkdir()) {//폴더가 없는 경우 파일 생성 후 전부 null값으로 저장 후 불러오기
			try {
				filerute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.userListSave(userList = new HashMap<String, User>());
			file.productListSave(productList = new HashMap<String, Product>());
			file.logListSave(logList = new ArrayList<Log>());
			file.systemInfoListSave(systemInfo = new TajoSystemInfo(0, 0));
		}else {//기존의 저장된 파일들 전부 불러오기
			userList = file.userListLoad();
			productList = file.productListLoad();
			logList = file.logListLoad();
			systemInfo = file.systemInfoListLoad();
		}
//		userList.put("admin123", new User("admin123", "1q2w3e$R", "admin3", true));
//		userList.remove("admin123");
//		userList.put("admin", new User("admin", "1234", "admin3", true));
		//시작메뉴:윤태호
		mainrupe:while(true) {
			int key = 0; //입력용 변수
			boolean auto = true; // while문 변수
			this.process = new ProductProcess(); // 유저, 기기 리스트 갱신
			management = new UserManagement();
			
			//프로그램 시작
			while (auto) {
				key = TajoPrint.startMenu(); //로그인 메뉴 출력, 입력
				switch (key) {
				case 1://1. 로그인
					userId = management.userSingIn(userList);
					break;
				case 2://2. 회원가입
					if(management.userSignUp(userList)) {
						file.userListSave(userList);
					}
					break;
				case 3://3. 종료
					System.exit(0);
					break mainrupe;
				}
				if(!userId.isEmpty()) {
					break;
				} else {
					continue;
				}
			}
			
			if(userList.get(userId).isGrade()) {
				//관리자일 경우
				int menu = 0;
			loop:while ((menu = TajoPrint.adminMenu()) != 0) {
					switch (menu) {
					case 1://1. 시스템 조회
						System.out.println();
						System.out.println("총 매출 : " + systemInfo.getTotalSales() + "원 총 대여횟수 :" + systemInfo.getTotalRent() + "대");
						int index = TajoPrint.searchMenu();
						switch (index) {
						case 1://1. 유저목록 조회
							TajoPrint.userListPrint(userList);
							break;
						case 2://2. 기기목록조회 
							TajoPrint.productListPrint(productList,0);
							break;
						case 3://3. 대여로그조회
							TajoPrint.logListPrint(logList);
							break;
						case 4: //4. 유저 검색
							TajoPrint.userListPrint(userList);
							System.out.println("****************************");
							System.out.print  ("검색할 유저의 아이디를 입력하세요.\n>>");
							String str = Utils.scanner.nextLine();
							TajoPrint.userPrint(userList, str);
							break;
						default:
							System.out.println("올바른 입력이 아닙니다.");
							break;
						}
						break;
					case 2://2. 기기관리
						process.productProcess(productList);
						file.productListSave(productList);
						System.out.println("저장완료");
						break;
					case 3: //유저관리
						management.userUpdateAdmin(userList);
						file.userListSave(userList);
						break;
					case 4: //로그아웃
						userId="";
						break loop;
					case 5:
						System.exit(0);
					default:
						System.out.println("올바른 입력이 아닙니다.");
						break;
					}
				}
			} else {
				//유저일 경우
				int menu = 0;
				lope:while ((menu = TajoPrint.userMenu()) != 0) {
				switch (menu) {
					case 1://1. 대여하기
						if(!process.checkProductList(productList)) {
							System.out.println("대여할 수 있는 기기가 없습니다.");
							continue lope;
						}
						TajoPrint.productListPrint(productList,1);
						System.out.println("대여하길 원하는 번호를 입력하세요");
						String rentInput = Utils.scanner.nextLine();
						if(!rentInput.matches(Utils.ONLYNUMBER)) {//입력값 판별
							System.out.println("숫자를 입력하셔야 합니다.");
							break;
						}
						process.rentProduct(userList.get(userId),productList.get(rentInput));
						System.out.println(userList.get(userId).getRentList().size());
						systemInfo.setTotalRent(systemInfo.getTotalRent()+1);// 총 대여횟수 + 1
						saveAll();
						break;
					case 2://2. 반납하기
						if(userList.get(userId).getRentList().size() ==0) {
							System.out.println("대여한 기기가 없습니다.");
							break;
						}
						TajoPrint.productListPrint(userList.get(userId));
						System.out.println("반납하길 원하는 번호를 입력하세요");
						String inputNum = Utils.scanner.nextLine();
						Log log = process.returnProduct(userList.get(userId), productList.get(inputNum));
						
						if(log!=null) {
							logList.add(log);
						}
						
						systemInfo.setTotalSales(systemInfo.getTotalSales() + productList.get(inputNum).getPrice());//총 매출 추가
						//파일 저장
						saveAll();
						break;
					case 3://3. 회원정보수정
						management.userUpdate(userList, userId);
						file.userListSave(userList);
						break;
					case 4://4. 회원탈퇴
						management.userDelete(userList, userId);
						file.userListSave(userList);
						break lope;
					case 5:
						if(!management.buyTicket(userList, userId)) {
							System.out.println("티켓이 구매되지 않았습니다.");
						} else {
							System.out.println("티켓이 구매되었습니다.");
						}
						file.userListSave(userList);
						break;
					case 6://5. 로그아웃
						this.userId = "";
						break lope;
					case 7://6. 종료
						System.exit(0);
						break mainrupe;
					}
				}
			}
		}
	}//run end:윤태호
	
}


