package kr.or.tajo;

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
	
	//생성자
	public TajoSystem() {
		this.userList = new HashMap<String, User>();
		this.productList = new HashMap<String, Product>();
		this.logList = new ArrayList<Log>();
		file = new FileIO();
	}
	
	//run 함수
	public void run() {
		//파일들 불러오기
		
		//시작메뉴
		//UserManagement 로그인, 회원가입 기능 사용
		
			//유저일 경우
			//ProductProcess 사용해서 대여, 반납 처리
			
			//관리자일 경우
			//관리자 메뉴로 사용할 기능 입력 받고
			//ProductProcess, Product, TajoPrint 로 입출력 + 처리
	}
	
}
