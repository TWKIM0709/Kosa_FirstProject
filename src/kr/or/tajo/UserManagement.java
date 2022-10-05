package kr.or.tajo;

import java.util.HashMap;
import java.util.Map;

public class UserManagement {
	Map<String, User> userList = new HashMap<String, User>();
	
	public UserManagement(Map userList){
		this.userList = userList;
	}
	
	//회원가입 함수
	public static boolean userSignUp() {
		//파라미터 받아서 조건확인(중복, admin 등)확인하고 return
		return false;
	}
	
	//로그인 함수
	public static boolean userSingIn() {
		//파라미터 받아서 비교하고 결과 return
		return false;
	}
}