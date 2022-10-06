package kr.or.tajo;

import java.util.Collection;
import java.util.Map;

//스캐너는 Utils.scanner
public class TajoPrint {

	// 메뉴들
	// 시작메뉴 : 박지영
	public static int startMenu() {

		System.out.println("***************************************");
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");

		int startMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (startMenu) {
		case 1:
			System.out.println("로그인을 시작합니다.");// 1. 회원가입
			break;
		case 2:
			System.out.println("회원가입을 시작합니다.");// 2. 로그인
			break;
		case 3:
			System.out.println("종료합니다.");// 3. 종료
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
		}

		return startMenu;
	}

	// 유저 메뉴 : 박지영
	public static int userMenu() {
		System.out.println("***************************************");
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 대여하기 | 2. 반납하기 | 3. 종료");

		int userMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (userMenu) {
		case 1:
			System.out.println("대여를 시작합니다.");// 1. 대여하기
			break;
		case 2:
			System.out.println("반납을 시작합니다.");// 2. 반납하기
			break;
		case 3:
			System.out.println("종료합니다."); // 3. 종료
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
		}

		return userMenu;
	}

	// admin 기본 메뉴 : 박지영
	public static int adminMenu() {
		// 1. 시스템 조회
		// 2. 기기관리
		System.out.println("***************************************");
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 시스템 조회 | 2. 기기관리");

		int adminMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (adminMenu) {
		case 1:
			System.out.println("시스템 조회를 시작합니다.");// 1. 시스템 조회
			break;
		case 2:
			System.out.println("기기관리를 시작합니다.");// 2. 기기관리
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
		}

		return adminMenu;
	}

	// admin 조회 메뉴 : 박지영
	public static int searchMenu() {
		// 시스템 정보 출력 후
		System.out.println("***************************************");
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 유저목록조회 | 2. 기기목록조회 | 3. 대여로그조회");

		int searchMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (searchMenu) {
		case 1:
			System.out.println("유저목록조회를 시작합니다.");// 1. 유저목록조회
			break;
		case 2:
			System.out.println("기기목록조회를 시작합니다.");// 2. 기기목록조회
			break;
		case 3:
			System.out.println("대여로그조회를 시작합니다."); // 3. 대여로그조회
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
		}

		return searchMenu;
	}

	// admin 기기관리 메뉴 : 박지영
	public static int ManagementProductMenu() {
		System.out.println("***************************************");
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 기기등록 | 2. 기기삭제 | 3. 기기충전 | 4. 관리종료");

		int ManagementProductMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (ManagementProductMenu) {
		case 1:
			System.out.println("기기등록을 시작합니다.");// 1. 기기등록
			break;
		case 2:
			System.out.println("기기삭제를 시작합니다.");// 2. 기기삭제
			break;
		case 3:
			System.out.println("기기를 충전합니다.");// 3. 기기충전
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
		}

		return ManagementProductMenu;
	}
	
	// 기기 목록 : 박지영
	public static void productListPrint(Map<String, Product> productList, int index) {
		// index 0 : 전체 출력
		// index 1 : 대여가능출력
		// index 2 : 충전필요기기출력
		// Collection clist = map.values(); //value 는 중복데이터 있어서 순서가 있는 데이터 집합
		// System.out.println(clist.toString());
		Collection productValueList = productList.values();
		switch (index) {
		case 0:
			for (Object o : productValueList) {
				System.out.println(((Product) o).toString());
			}
			break;
		case 1:
			for (Object o : productValueList) {
				// Product의 isAble() true 일때만 출력
				if (((Product) o).isAble()) {
					System.out.println(((Product) o).toString());
				}
			}
			break;
		case 2:
			for (Object o : productValueList) {
				if ((Product) o instanceof ChargeAble) {
					System.out.println(((Product) o).toString());
				}
			}

		}
	}

	//User가 대여중인 기기목록출력 : 박지영
	public static void productListPrint(User user) {
		// 파라미터로 받은 유저가 대여중인 기기 출력
		Map<String, Product> hs = user.getRentList();
		Collection productValueList = hs.values();
		for (Object o : productValueList) {
			System.out.println(((Product) o).toString());
		}
	}

	// 유저 목록 : 박지영
	public static void userListPrint(Map<String, User> userList) {
		Collection userValueList = userList.values();
		for (Object o : userValueList) {
			System.out.println(((User) o).toString());
		}
	}
}
