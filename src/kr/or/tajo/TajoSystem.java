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
	private TajoSystemInfo systemInfo;
	private ProductProcess process;
	private UserManagement management;
	//생성자
	public TajoSystem() {
		this.userList = new HashMap<String, User>();
		this.productList = new HashMap<String, Product>();
		this.logList = new ArrayList<Log>();
		this.userId = "";
		this.file = new FileIO();
	}
	
	//run 함수:윤태호
	public void run() {
		File filelute = new File(Utils.BASICPATH);
		if (filelute.mkdir()) {//파일이 없는 경우 파일 생성
			try {
				filelute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.userListSave(null);
			file.productListSave(null);
			file.logListSave(null);
			file.systemInfoListSave(null);
		}else {//파일들 전부 불러오기
			userList = file.userListLoad();
			productList = file.productListLoad();
			logList = file.logListLoad();
			systemInfo = file.systemInfoListLoad();
		}
		
		
		//시작메뉴:윤태호
		int key = 0;
		boolean auto = true;
		management = new UserManagement(userList);
		this.process = new ProductProcess(productList);
		
		while (auto) {
			key = TajoPrint.startMenu();
			switch (key) {
			case 1://1. 로그인
				userId = management.userSingIn();
				break;
			case 2://2. 회원가입
				if(management.userSignUp()) {
					file.userListSave(userList);
				}
				break;
			case 3://3. 종료
				System.exit(0);
				break;
			}
			if(!userId.isEmpty()) {
				break;
			}
		}
		
		if(userList.get(userId).isGrade()) {
			//관리자일 경우
			int menu = 0;
			while ((menu = TajoPrint.adminMenu()) != 0) {
				switch (menu) {
				case 1://1. 시스템 조회
					int index = TajoPrint.searchMenu();
					switch (index) {
					case 1:
						TajoPrint.userListPrint(userList);
						break;
					case 2:
						TajoPrint.productListPrint(productList,0);
						break;
					default:
						System.out.println("올바른 입력이 아닙니다.");
						break;
					}
					break;
				case 2://2. 기기관리
					process.setProcess(productList);
					productList = process.productProcess();
					file.productListSave(productList);
					System.out.println("저장완료");
					break;
				}
			}
		} else {
			//유저일 경우
			int menu = 0;
			while ((menu = TajoPrint.userMenu()) != 0) {
				switch (menu) {
				case 1://1. 대여하기
					TajoPrint.productListPrint(productList,1);
					break;
				case 2://2. 반납하기
					TajoPrint.productListPrint(userList.get(userId));
					String inputNum = Utils.scanner.nextLine();
					ProductProcess process = new ProductProcess(productList);
					process.returnProduct(userList.get(userId), productList.get(inputNum));
					break;
				case 3://3. 종료
					System.exit(0);
					break;
				}
			}
		}
	}//run end:윤태호
	
}
