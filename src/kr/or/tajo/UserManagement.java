package kr.or.tajo;

import java.util.Map;

public class UserManagement {

	// 회원가입 함수:조혜진
	public boolean userSignUp(Map<String, User> userList) {
		System.out.println();
		// 파라미터 받아서 조건확인(중복)확인하고 return
		String idregix = Utils.REGIXID;// 아이디 정규식
		String pwregix = Utils.REGIXPASSWARD;// 비밀번호 정규식
		String id = "";
		String pw = "";
		String name = "";
		boolean result = true;

		while (result) {
			System.out.print("아이디를 입력해주세요(영소문자+숫자로 이루어진 5~19자리문자)\n>>");
			id = Utils.scanner.nextLine();

			if (!(userList.containsKey(id))) {// 아이디 중복 체크
				if (!id.matches(idregix)) {// 아이디 정규식 체크
					System.out.println("올바른 형식으로 입력해주세요.");
					continue;
				}

			} else {
				System.out.println("이미가입된 아이디 입니다.");
				continue;
			}

			System.out.print("비밀번호를 입력해주세요.(소문자,대문자,숫자,특수문자(@$!%*?&)가 하나 이상 포함된 8~16자리 문자)\n>>");
			pw = Utils.scanner.nextLine();

			if (!pw.matches(pwregix)) {// 비밀번호 정규식 체크
				System.out.println("올바른 형식으로 입력해주세요.");
				continue;
			}
			System.out.print("비밀번호 재입력\n>>");
			String pw2 = Utils.scanner.nextLine();

			if (!pw2.equals(pw)) {// 비밀번호 재확인 체크
				System.out.println("비밀번호가 그 전과 같지 않습니다.");
				continue;
			}
			System.out.print("이름을 입력해주세요.\n>>");
			name = Utils.scanner.nextLine();
			break;

		}

		if (result) {
			userList.put(id, new User(id, pw, name, false));
			System.out.println("회원가입을 축하드립니다.");

		} else {
			System.out.println("회원가입에 실패했습니다.");
		}

		return result;
	}// userSignUp end

	// 로그인 함수:조혜진
	public String userSingIn(Map<String, User> userList) {
		System.out.println();
		// 파라미터 받아서 비교하고 결과 return
		boolean result = true;
		int cnt = 0;
		String id = "";

		while (result) {
			System.out.printf("\n현재 입력오류횟수(%d/3)\n", cnt);
			if (cnt == 3) {
				System.out.println("아이디 또는 비밀번호를 3회이상 틀려 메뉴화면으로 돌아갑니다.");
				result = false;
				id = "";
				break;
			}
			System.out.print("아이디를 입력해주세요 : ");
			id = Utils.scanner.nextLine();
			if (!(userList.containsKey(id))) { // 아이디가 있는지 확인
				System.out.println("아이디가 일치하지 않습니다.");
				cnt++;
				continue;
			}

			System.out.print("비밀번호를 입력해 주세요 : ");
			String pw = Utils.scanner.nextLine();
			if (!(userList.get(id).getPassword().equals(pw))) {
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				cnt++;
				continue;
			}
			break;
		}

		return id;
	}// userSingIn end

	// 회원정보업데이트: 조혜진
	// 회원정보업데이트: 조혜진
	public void userUpdate(Map<String, User> userList, String userId) {
		System.out.println();
		String pwregix = Utils.REGIXPASSWARD;
		roop: while (true) {
			if (userList.containsKey(userId)) {
				
				System.out.println("수정을 원하시는 것을 선택해주세요 ");
				System.out.println("1.비밀번호 | 2.이름 | 3.종료");
				String menu = Utils.scanner.nextLine();
				if (menu.equals("1") || menu.equals("2")) {
					System.out.print("비밀번호를 입력하세요\n>>");
					String pw1 = Utils.scanner.nextLine();
					if (pw1.equals(userList.get(userId).getPassword())) {
						System.out.println("\n" + userList.get(userId).toString());
						if (menu.equals("1")) {
							System.out.print("변경할 비밀번호를 입력해주세요\n>>");
							String pw = Utils.scanner.nextLine();

							if (!pw.matches(pwregix)) {// 비밀번호 정규식 체크
								System.out.println("올바른 형식으로 입력해주세요.");
								continue;
							}
							System.out.print("비밀번호 재입력\n>>");
							String pw2 = Utils.scanner.nextLine();

							if (!pw2.equals(pw)) {// 비밀번호 재확인 체크
								System.out.println("비밀번호가 그 전과 같지 않습니다.");
								continue;

							} else {
								userList.get(userId).setPassword(pw2);
								System.out.println("변경이 완료 되었습니다.");
								continue;
							}

						} else if (menu.equals("2")) {
							System.out.print("변경하실 이름을 입력헤주세요.\n>>");
							String name = Utils.scanner.nextLine();
							userList.get(userId).setName(name);
							continue;

						}
					}
				} else if (menu.equals("3")) {

					System.out.println("종료되었습니다.");
					break roop;

				} else {
					System.out.println("올바른 번호를 입력해주세요.");
					break;

				}

			} else {
				System.out.println("올바른 비밀번호를 입력해주세요.");
				continue;
			}

		}

	}// userUpdate end

	// 회원탈퇴 : 조혜진
	public void userDelete(Map<String, User> userList, String userId) {
		System.out.println();
		String input = null;
		System.out.print("비밀번호를 입력해주세요\n>>");
		String pw = Utils.scanner.nextLine();
		if (pw.equals(userList.get(userId).getPassword())) {// 비밀번호확인
			if ((userList.containsKey(userId))) {
				System.out.println(userList.get(userId).toString());
				while (true) {
					System.out.print("계정을 삭제하시겠습니까? (Y/N)\n>>");
					input = Utils.scanner.nextLine().toLowerCase();

					if (!input.equals("y") && !input.equals("n")) {
						// y나 n이 아닌 다른 값 입력
						System.out.println("올바른 값을 입력해주세요.");
						continue;
					}
					break;
				}
				if (input.equals("y")) {
					userList.remove(userId);
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("삭제 취소되었습니다.");
				}
			} else {
				System.out.println("없는 아이디 입니다.");
			}
		} else {
			System.out.println("올바른 비밀번호를 입력하세요.");
		}
	}// userDelete end

	// 관리자용 유저관리
	public void userUpdateAdmin(Map<String, User> userList) {
		String pwregix = Utils.REGIXPASSWARD;
		boolean userck = true;
		TajoPrint.userListPrint(userList);
		// 유저 선택
		System.out.print("수정할 유저의 아이디를 입력하세요.\n>>");
		String userId = Utils.scanner.nextLine();

		if (!userList.containsKey(userId)) {
			System.out.println("등록되지 않은 유저입니다.");
			userck = false;
		}

		System.out.println();
		while (userck) { // 유저가 있으면
			System.out.println("\n" + userList.get(userId).toString());
			System.out.println("수정을 원하는 것을 선택해주세요 ");
			System.out.println("1. 등급변경 | 2.종료");
			String menu = Utils.scanner.nextLine().toLowerCase();

			switch (menu) {
			case "1": // 등급변경
				boolean grade = userList.get(userId).isGrade();
				System.out.print("등급을 변경하시겠습니까? 현재 등급은 " + ((grade) ? "관리자" : "일반회원") + "입니다 (y/n)\n>>");
				String str = Utils.scanner.nextLine().toLowerCase();

				switch (str) {
				case "y":
					System.out.println("등급을 변경했습니다.");
					userList.get(userId).setGrade(!grade);
					break;
				case "n":
					System.out.println("등급을 변경하지 않았습니다.");
					break;
				default:
					System.out.println("잘못된 값을 입력했습니다. 등급을 변경하지 않습니다.");
				}
				break;
			case "2": // 종료
				System.out.println("종료되었습니다.");
				break;
			default:
				System.out.println("올바른 값을 입력해주세요.");
				break;
			}
			break;
		}
	}// userUpdate end

	// 티캣 구매 : 김태우
	public boolean buyTicket(Map<String, User> userList, String userId) {
		boolean ck = true;
		int amount = 0;
		while (true) {
			// 티켓 매수 입력
			System.out.print("구매할 티켓의 수량을 입력하세요(한장에 10000원)\n>>");
			String str = Utils.scanner.nextLine();
			if (!str.matches(Utils.ONLYNUMBER)) {
				System.out.println("숫자를 입력하세요");
				continue;
			}
			// 결제 - 입력부
			amount = Integer.parseInt(str) * 10000;
			System.out.printf("티켓금액 %d 입니다. 결제금액을 입력하세요.\n>>", amount);
			str = Utils.scanner.nextLine();
			if (!str.matches(Utils.ONLYNUMBER)) {
				System.out.println("숫자를 입력하세요");
				continue;
			}
			//
			// 결제 - 진행
			if (Integer.parseInt(str) > amount) {
				System.out.println(amount + "원 결제되었습니다. 거스름돈 " + (amount - Integer.parseInt(str)) + "원 입니다.");
			} else if (Integer.parseInt(str) == amount) {
				System.out.println(amount + "원 결제되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
				ck = false;
				break;
			}
			// 구매완료
			userList.get(userId).addTicket(Integer.parseInt(str) / 10000);
			ck = true;
			break;
		}
		return ck;
	}// buyTicket end
}