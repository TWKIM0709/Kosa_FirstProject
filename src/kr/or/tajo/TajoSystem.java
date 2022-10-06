package kr.or.tajo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TajoSystem {
	//������ ���, ó��Ŭ���� ��
	//��ĳ�ʴ� Utils Ŭ������ static���� �ִ�.
	private Map<String, User> userList; //�������
	private Map<String, Product> productList; //�����
	private List<Log> logList; //�뿩�������
	private FileIO file; //���� ����� ����
	private String userId; //�α��ε� ���� ID
	private TajoSystemInfo systemInfo;
	private ProductProcess process;
	private UserManagement management;
	//������
	public TajoSystem() {
		this.userList = new HashMap<String, User>();
		this.productList = new HashMap<String, Product>();
		this.logList = new ArrayList<Log>();
		this.userId = "";
		this.file = new FileIO();
	}
	
	//run �Լ�:����ȣ
	public void run() {
		File filelute = new File(Utils.BASICPATH);
		if (filelute.mkdir()) {//������ ���� ��� ���� ����
			try {
				filelute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.userListSave(null);
			file.productListSave(null);
			file.logListSave(null);
			file.systemInfoListSave(null);
		}else {//���ϵ� ���� �ҷ�����
			userList = file.userListLoad();
			productList = file.productListLoad();
			logList = file.logListLoad();
			systemInfo = file.systemInfoListLoad();
		}
		
		
		//���۸޴�:����ȣ
		int key = 0;
		boolean auto = true;
		management = new UserManagement(userList);
		this.process = new ProductProcess(productList);
		
		while (auto) {
			key = TajoPrint.startMenu();
			switch (key) {
			case 1://1. �α���
				userId = management.userSingIn();
				break;
			case 2://2. ȸ������
				if(management.userSignUp()) {
					file.userListSave(userList);
				}
				break;
			case 3://3. ����
				System.exit(0);
				break;
			}
			if(!userId.isEmpty()) {
				break;
			}
		}
		
		if(userList.get(userId).isGrade()) {
			//�������� ���
			int menu = 0;
			while ((menu = TajoPrint.adminMenu()) != 0) {
				switch (menu) {
				case 1://1. �ý��� ��ȸ
					int index = TajoPrint.searchMenu();
					switch (index) {
					case 1:
						TajoPrint.userListPrint(userList);
						break;
					case 2:
						TajoPrint.productListPrint(productList,0);
						break;
					default:
						System.out.println("�ùٸ� �Է��� �ƴմϴ�.");
						break;
					}
					break;
				case 2://2. ������
					process.setProcess(productList);
					productList = process.productProcess();
					file.productListSave(productList);
					System.out.println("����Ϸ�");
					break;
				}
			}
		} else {
			//������ ���
			int menu = 0;
			while ((menu = TajoPrint.userMenu()) != 0) {
				switch (menu) {
				case 1://1. �뿩�ϱ�
					TajoPrint.productListPrint(productList,1);
					break;
				case 2://2. �ݳ��ϱ�
					TajoPrint.productListPrint(userList.get(userId));
					String inputNum = Utils.scanner.nextLine();
					ProductProcess process = new ProductProcess(productList);
					process.returnProduct(userList.get(userId), productList.get(inputNum));
					break;
				case 3://3. ����
					System.exit(0);
					break;
				}
			}
		}
	}//run end:����ȣ
	
}
