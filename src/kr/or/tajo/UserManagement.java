package kr.or.tajo;

import java.util.HashMap;
import java.util.Map;

public class UserManagement {
	Map<String, User> userList = new HashMap<String, User>();
	
	public UserManagement(Map userList){
		this.userList = userList;
	}
	
	//ȸ������ �Լ�
	public static boolean userSignUp() {
		//�Ķ���� �޾Ƽ� ����Ȯ��(�ߺ�, admin ��)Ȯ���ϰ� return
		return false;
	}
	
	//�α��� �Լ�
	public static boolean userSingIn() {
		//�Ķ���� �޾Ƽ� ���ϰ� ��� return
		return false;
	}
}