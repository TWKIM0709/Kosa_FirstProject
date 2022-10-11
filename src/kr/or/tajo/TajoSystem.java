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
	private TajoSystemInfo systemInfo; //�ý�������
	private ProductProcess process; // ������ó��
	private UserManagement management; // ��������ó��
	
	//������
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
	
	//run �Լ�:����ȣ
	public void run() {
		// ======================= �ʱ� ���� �ҷ����� =======================
		File filerute = new File(Utils.BASICPATH);
		if (filerute.mkdir()) {//������ ���� ��� ���� ���� �� ���� null������ ���� �� �ҷ�����
			try {
				filerute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.userListSave(userList = new HashMap<String, User>());
			file.productListSave(productList = new HashMap<String, Product>());
			file.logListSave(logList = new ArrayList<Log>());
			file.systemInfoListSave(systemInfo = new TajoSystemInfo(0, 0));
		}else {//������ ����� ���ϵ� ���� �ҷ�����
			userList = file.userListLoad();
			productList = file.productListLoad();
			logList = file.logListLoad();
			systemInfo = file.systemInfoListLoad();
		}
//		userList.put("admin123", new User("admin123", "1q2w3e$R", "admin3", true));
//		userList.remove("admin123");
//		userList.put("admin", new User("admin", "1234", "admin3", true));
		//���۸޴�:����ȣ
		mainrupe:while(true) {
			int key = 0; //�Է¿� ����
			boolean auto = true; // while�� ����
			this.process = new ProductProcess(); // ����, ��� ����Ʈ ����
			management = new UserManagement();
			
			//���α׷� ����
			while (auto) {
				key = TajoPrint.startMenu(); //�α��� �޴� ���, �Է�
				switch (key) {
				case 1://1. �α���
					userId = management.userSingIn(userList);
					break;
				case 2://2. ȸ������
					if(management.userSignUp(userList)) {
						file.userListSave(userList);
					}
					break;
				case 3://3. ����
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
				//�������� ���
				int menu = 0;
			loop:while ((menu = TajoPrint.adminMenu()) != 0) {
					switch (menu) {
					case 1://1. �ý��� ��ȸ
						System.out.println();
						System.out.println("�� ���� : " + systemInfo.getTotalSales() + "�� �� �뿩Ƚ�� :" + systemInfo.getTotalRent() + "��");
						int index = TajoPrint.searchMenu();
						switch (index) {
						case 1://1. ������� ��ȸ
							TajoPrint.userListPrint(userList);
							break;
						case 2://2. �������ȸ 
							TajoPrint.productListPrint(productList,0);
							break;
						case 3://3. �뿩�α���ȸ
							TajoPrint.logListPrint(logList);
							break;
						case 4: //4. ���� �˻�
							TajoPrint.userListPrint(userList);
							System.out.println("****************************");
							System.out.print  ("�˻��� ������ ���̵� �Է��ϼ���.\n>>");
							String str = Utils.scanner.nextLine();
							TajoPrint.userPrint(userList, str);
							break;
						default:
							System.out.println("�ùٸ� �Է��� �ƴմϴ�.");
							break;
						}
						break;
					case 2://2. ������
						process.productProcess(productList);
						file.productListSave(productList);
						System.out.println("����Ϸ�");
						break;
					case 3: //��������
						management.userUpdateAdmin(userList);
						file.userListSave(userList);
						break;
					case 4: //�α׾ƿ�
						userId="";
						break loop;
					case 5:
						System.exit(0);
					default:
						System.out.println("�ùٸ� �Է��� �ƴմϴ�.");
						break;
					}
				}
			} else {
				//������ ���
				int menu = 0;
				lope:while ((menu = TajoPrint.userMenu()) != 0) {
				switch (menu) {
					case 1://1. �뿩�ϱ�
						if(!process.checkProductList(productList)) {
							System.out.println("�뿩�� �� �ִ� ��Ⱑ �����ϴ�.");
							continue lope;
						}
						TajoPrint.productListPrint(productList,1);
						System.out.println("�뿩�ϱ� ���ϴ� ��ȣ�� �Է��ϼ���");
						String rentInput = Utils.scanner.nextLine();
						if(!rentInput.matches(Utils.ONLYNUMBER)) {//�Է°� �Ǻ�
							System.out.println("���ڸ� �Է��ϼž� �մϴ�.");
							break;
						}
						process.rentProduct(userList.get(userId),productList.get(rentInput));
						System.out.println(userList.get(userId).getRentList().size());
						systemInfo.setTotalRent(systemInfo.getTotalRent()+1);// �� �뿩Ƚ�� + 1
						saveAll();
						break;
					case 2://2. �ݳ��ϱ�
						if(userList.get(userId).getRentList().size() ==0) {
							System.out.println("�뿩�� ��Ⱑ �����ϴ�.");
							break;
						}
						TajoPrint.productListPrint(userList.get(userId));
						System.out.println("�ݳ��ϱ� ���ϴ� ��ȣ�� �Է��ϼ���");
						String inputNum = Utils.scanner.nextLine();
						Log log = process.returnProduct(userList.get(userId), productList.get(inputNum));
						
						if(log!=null) {
							logList.add(log);
						}
						
						systemInfo.setTotalSales(systemInfo.getTotalSales() + productList.get(inputNum).getPrice());//�� ���� �߰�
						//���� ����
						saveAll();
						break;
					case 3://3. ȸ����������
						management.userUpdate(userList, userId);
						file.userListSave(userList);
						break;
					case 4://4. ȸ��Ż��
						management.userDelete(userList, userId);
						file.userListSave(userList);
						break lope;
					case 5:
						if(!management.buyTicket(userList, userId)) {
							System.out.println("Ƽ���� ���ŵ��� �ʾҽ��ϴ�.");
						} else {
							System.out.println("Ƽ���� ���ŵǾ����ϴ�.");
						}
						file.userListSave(userList);
						break;
					case 6://5. �α׾ƿ�
						this.userId = "";
						break lope;
					case 7://6. ����
						System.exit(0);
						break mainrupe;
					}
				}
			}
		}
	}//run end:����ȣ
	
}


