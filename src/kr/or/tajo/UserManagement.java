package kr.or.tajo;

import java.util.Map;

public class UserManagement {
	Map<String, User> userList;

	public UserManagement(Map userList) {
		this.userList = userList;
	}

	// 회원가입 함수:조혜진
	public boolean userSignUp() {
		// 파라미터 받아서 조건확인(중복)확인하고 return
		String idregix = Utils.REGIXID;//아이디 정규식
		String pwregix = Utils.REGIXPASSWARD;//비밀번호 정규식
		String id = "";
		String pw = "";
		String name = "";
		boolean result = true;

		while (result) {
			System.out.println("아이디를 입력해주세요 : ");
			id = Utils.scanner.nextLine();

			if (!(userList.containsKey(id))) {//아이디 중복 체크
				if (!id.matches(idregix)) {//아이디 정규식 체크
					System.out.println("올바른 형식으로 입력해주세요.");
					continue;
				}

			} else {
				System.out.println("이미가입된 아이디 입니다.");
				continue;
			}
			System.out.println("비밀번호를 입력해주세요.");
			pw = Utils.scanner.nextLine();

			if (!pw.matches(pwregix)) {//비밀번호 정규식 체크
				System.out.println("올바른 형식으로 입력해주세요.");
				continue;
			}
			System.out.println("비밀번호 재입력");
			String pw2 = Utils.scanner.nextLine();

			if (!pw2.equals(pw)) {//비밀번호 재확인 체크
				System.out.println("비밀번호가 그 전과 같지 않습니다.");
				continue;
			}
			System.out.println("이름을 입력해주세요 :");
			name = Utils.scanner.nextLine();
			break;

		}
		
		if(result) {
			userList.put(id, new User(id, pw, name, false));
			System.out.println("회원가입을 축하드립니다.");
			
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
		return result;
	}//userSignUp end

	// 로그인 함수:조혜진
	public String userSingIn() {
		// 파라미터 받아서 비교하고 결과 return
		boolean result = true;
		int cnt = 0;
		String id="";
		while(result) {
			System.out.println("아이디를 입력해주세요 : ");
			id = Utils.scanner.nextLine();
			if (!(userList.containsKey(id))) {
				System.out.println("아이디가 일치하지 않습니다.");
				cnt++;
				continue;
			}

			System.out.println("비밀번호를 입력해 주세요 : ");
			String pw = Utils.scanner.nextLine();
			if (!(userList.get(id).getPassword().equals(pw))) {
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				cnt++;
				continue;
			}
			if (cnt == 3) {
				result = false;
				break;
			}
			break;
		}

		return id;
	}//userSingIn end
}