package kr.or.tajo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

//스캐너는 Utils.scanner
public class TajoPrint {

	// 메뉴들
	public static void logoPrint() {
		//□ ■
//		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//		System.out.println("■■■■□□□□□□□■■■■□□■■■■■■■□□□□□■■■□□□■■■■■");
//		System.out.println("■■■■■■■□■■■■■■□■■□■■■■■■■■□■■■■□■■■□■■■■");
//		System.out.println("■■■■■■■□■■■■■■□□□□■■■■■■■■□■■■■□■■■□■■■■");
//		System.out.println("■■■■■■■□■■■■■□■■■■□■■■□■■■□■■■■□■■■□■■■■");
//		System.out.println("■■■■■■■□■■■■■□■■■■□■■■■□□□□■■■■■□□□■■■■■");
//		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□■■■■■■■□□□□■■□□□□□□□■■■■■□□□■■■□□□□□");
		System.out.println("□□□□□□□■□□□□□□■□□■□□□□□□□□■□□□□■□□□■□□□□");
		System.out.println("□□□□□□□■□□□□□□■■■■□□□□□□□□■□□□□■□□□■□□□□");
		System.out.println("□□□□□□□■□□□□□■□□□□■□□□■□□□■□□□□■□□□■□□□□");
		System.out.println("□□□□□□□■□□□□□■□□□□■□□□□■■■□□□□□□■■■□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
	}
	// 시작메뉴 : 박지영
	public static int startMenu() {
		logoPrint();
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");

		String startMenu = Utils.scanner.nextLine();
		if(startMenu.matches(Utils.ONLYNUMBER)) {
			switch (startMenu) {
			case "1":
				System.out.println("로그인을 시작합니다.");// 1. 회원가입
				break;
			case "2":
				System.out.println("회원가입을 시작합니다.");// 2. 로그인
				break;
			case "3":
				System.out.println("종료합니다.");// 3. 종료
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
			}
		}else {
			System.out.println("재대로 된 숫자를 입력하십시오");
			startMenu = "999";
		}
		return Integer.parseInt(startMenu);
	}//startMenu end

	// 유저 메뉴 : 박지영
	public static int userMenu() {
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 대여하기 | 2. 반납하기 | 3. 회원정보 수정");
	    System.out.println("4. 회원탈퇴 | 5. 티켓구매 | 6.로그아웃 | 7. 종료");

		String userMenu = Utils.scanner.nextLine();
		if(userMenu.matches(Utils.ONLYNUMBER)) {
			switch (userMenu) {
			case "1":
				System.out.println("대여를 시작합니다.");// 1. 대여하기
				break;
			case "2":
				System.out.println("반납을 시작합니다.");// 2. 반납하기
				break;
			case "3":
				System.out.println("회원정보를 수정합니다.");
				break;
			case "4":
				System.out.println("회원탈퇴를 진행합니다.");
				break;
			case "5":
				System.out.println("티켓구매를 진행합니다.");
			case "6":
				System.out.println("로그아웃되었습니다."); // 3. 종료
				break;
			case "7":
				System.out.println("종료합니다."); // 3. 종료
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
			}
		}else {
			userMenu = "999";
		}
		return Integer.parseInt(userMenu);
	}//userMenu end

	// admin 기본 메뉴 : 박지영
	public static int adminMenu() {
		// 1. 시스템 조회
		// 2. 기기관리
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 시스템 조회 | 2. 기기관리 | 3.유저등급관리 | 4. 로그아웃");

		String adminMenu = Utils.scanner.nextLine();
		if(adminMenu.matches(Utils.ONLYNUMBER)) {
			switch (adminMenu) {
			case "1":
				System.out.println("시스템 조회를 시작합니다.");// 1. 시스템 조회
				break;
			case "2":
				System.out.println("기기관리를 시작합니다.");// 2. 기기관리
				break;
			case "3":
				System.out.println("유저등급관리를 시작합니다.");
				break;
			case "4":
				System.out.println("로그아웃되었습니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
			}
		}else {
			adminMenu = "999";
		}
		return Integer.parseInt(adminMenu);
	}//adminMenu end

	// admin 조회 메뉴 : 박지영
	public static int searchMenu() {
		// 시스템 정보 출력 후
		System.out.println("***************************************");
		System.out.println("\t원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 유저목록조회 | 2. 기기목록조회 | 3. 대여로그조회 | 4. 유저검색");

		String searchMenu = Utils.scanner.nextLine();
		if(searchMenu.matches(Utils.ONLYNUMBER)) {
			switch (searchMenu) {
			case "1":
				System.out.println("유저목록조회를 시작합니다.");// 1. 유저목록조회
				break;
			case "2":
				System.out.println("기기목록조회를 시작합니다.");// 2. 기기목록조회
				break;
			case "3":
				System.out.println("대여로그조회를 시작합니다."); // 3. 대여로그조회
				break;
			case "4":
				System.out.println("유저검색를 시작합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
			}
		}else {
			searchMenu = "999";
		}
		return Integer.parseInt(searchMenu);
	}//searchMenu end

	// admin 기기관리 메뉴 : 박지영
	public static int ManagementProductMenu() {
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t원하시는 메뉴를 선택하세요");
		System.out.println("***************************************");
		System.out.println("1. 기기등록 | 2. 기기삭제 | 3. 기기충전 | 4. 관리종료");

		String ManagementProductMenu = Utils.scanner.nextLine();
		if(ManagementProductMenu.matches(Utils.ONLYNUMBER)) {
			switch (ManagementProductMenu) {
			case "1":
				System.out.println("기기등록을 시작합니다.");// 1. 기기등록
				break;
			case "2":
				System.out.println("기기삭제를 시작합니다.");// 2. 기기삭제
				break;
			case "3":
				System.out.println("기기를 충전합니다.");// 3. 기기충전
				break;
			case "4":
				System.out.println("기기관리를 종료합니다.");// 3. 기기충전
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
			}
		}else {
			ManagementProductMenu = "999";
		}
		return Integer.parseInt(ManagementProductMenu);
	}//ManagementProductMenu end
	
	// 기기 목록 : 박지영
	public static void productListPrint(Map<String, Product> productList, int index) {
		System.out.println();
		Collection productValueList = productList.values();
		switch (index) {
		case 0:// index 0 : 전체 출력
			for (Object o : productValueList) {
				System.out.println(((Product) o).toString());
			}
			break;
		case 1:// index 1 : 대여가능출력
			for (Object o : productValueList) {
				// Product의 isAble() true 일때만 출력
				if (((Product) o).isAble()) {
					System.out.println(((Product) o).toString());
				}
			}
			break;
		case 2:// index 2 : 충전필요기기출력
			for (Object o : productValueList) {
				if ((Product) o instanceof ChargeAble) {
					boolean str = (o instanceof ProductOil) ? ((ProductOil)o).isCharged() : ((ProductElectric)o).isCharged();
					System.out.println(((Product) o).toString() + "\t[충전여부=" + ((str) ? "충전완료" : "충전필요") + "]");
				}
			}

		}
	}//productListPrint end

	//User가 대여중인 기기목록출력 : 박지영
	public static void productListPrint(User user) {
		System.out.println();
		// 파라미터로 받은 유저가 대여중인 기기 출력
		Map<String, Product> hs = user.getRentList();
		Collection productValueList = hs.values();
		for (Object o : productValueList) {
			System.out.println(((Product) o).toString());
		}
	}//productListPrint end

	// 유저 목록 : 박지영
	public static void userListPrint(Map<String, User> userList) {
		System.out.println();
		Collection userValueList = userList.values();
		for (Object o : userValueList) {
			System.out.println(((User) o).toString());
		}
	}//userListPrint end
	
	//로그 리스트 출력 : 박지영
	public static void logListPrint(List<Log> logList) {
		System.out.println();
		for(Log log : logList) {
			System.out.println(log);
		}
	}//logListPrint end
	
	// 유저검색 : 박지영
	public static void userPrint(Map<String, User> userList, String userId) {
		System.out.println();
		if(userList.containsKey(userId)){
			System.out.println(userList.get(userId));
		} else {
			System.out.println("등록된 아이디가 없습니다.");
		}
	}//UserPring end
}
