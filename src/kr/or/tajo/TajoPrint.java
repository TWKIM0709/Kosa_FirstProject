package kr.or.tajo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

//��ĳ�ʴ� Utils.scanner
public class TajoPrint {

	// �޴���
	public static void logoPrint() {
		//�� ��
//		System.out.println("�����������������������������������������");
//		System.out.println("�����������������������������������������");
//		System.out.println("�����������������������������������������");
//		System.out.println("�����������������������������������������");
//		System.out.println("�����������������������������������������");
//		System.out.println("�����������������������������������������");
//		System.out.println("�����������������������������������������");

		System.out.println("�����������������������������������������");
		System.out.println("�����������������������������������������");
		System.out.println("�����������������������������������������");
		System.out.println("�����������������������������������������");
		System.out.println("�����������������������������������������");
		System.out.println("�����������������������������������������");
		System.out.println("�����������������������������������������");
	}
	// ���۸޴� : ������
	public static int startMenu() {
		logoPrint();
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. �α��� | 2. ȸ������ | 3. ����");

		String startMenu = Utils.scanner.nextLine();
		if(startMenu.matches(Utils.ONLYNUMBER)) {
			switch (startMenu) {
			case "1":
				System.out.println("�α����� �����մϴ�.");// 1. ȸ������
				break;
			case "2":
				System.out.println("ȸ�������� �����մϴ�.");// 2. �α���
				break;
			case "3":
				System.out.println("�����մϴ�.");// 3. ����
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
			}
		}else {
			System.out.println("���� �� ���ڸ� �Է��Ͻʽÿ�");
			startMenu = "999";
		}
		return Integer.parseInt(startMenu);
	}//startMenu end

	// ���� �޴� : ������
	public static int userMenu() {
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. �뿩�ϱ� | 2. �ݳ��ϱ� | 3. ȸ������ ����");
	    System.out.println("4. ȸ��Ż�� | 5. Ƽ�ϱ��� | 6.�α׾ƿ� | 7. ����");

		String userMenu = Utils.scanner.nextLine();
		if(userMenu.matches(Utils.ONLYNUMBER)) {
			switch (userMenu) {
			case "1":
				System.out.println("�뿩�� �����մϴ�.");// 1. �뿩�ϱ�
				break;
			case "2":
				System.out.println("�ݳ��� �����մϴ�.");// 2. �ݳ��ϱ�
				break;
			case "3":
				System.out.println("ȸ�������� �����մϴ�.");
				break;
			case "4":
				System.out.println("ȸ��Ż�� �����մϴ�.");
				break;
			case "5":
				System.out.println("Ƽ�ϱ��Ÿ� �����մϴ�.");
			case "6":
				System.out.println("�α׾ƿ��Ǿ����ϴ�."); // 3. ����
				break;
			case "7":
				System.out.println("�����մϴ�."); // 3. ����
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
			}
		}else {
			userMenu = "999";
		}
		return Integer.parseInt(userMenu);
	}//userMenu end

	// admin �⺻ �޴� : ������
	public static int adminMenu() {
		// 1. �ý��� ��ȸ
		// 2. ������
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. �ý��� ��ȸ | 2. ������ | 3. �α׾ƿ�");

		String adminMenu = Utils.scanner.nextLine();
		if(adminMenu.matches(Utils.ONLYNUMBER)) {
			switch (adminMenu) {
			case "1":
				System.out.println("�ý��� ��ȸ�� �����մϴ�.");// 1. �ý��� ��ȸ
				break;
			case "2":
				System.out.println("�������� �����մϴ�.");// 2. ������
				break;
			case "3":
				System.out.println("�α׾ƿ��Ǿ����ϴ�.");
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
			}
		}else {
			adminMenu = "999";
		}
		return Integer.parseInt(adminMenu);
	}//adminMenu end

	// admin ��ȸ �޴� : ������
	public static int searchMenu() {
		// �ý��� ���� ��� ��
		System.out.println("***************************************");
		System.out.println("\t���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. ���������ȸ | 2. �������ȸ | 3. �뿩�α���ȸ | 4. �����˻�");

		String searchMenu = Utils.scanner.nextLine();
		if(searchMenu.matches(Utils.ONLYNUMBER)) {
			switch (searchMenu) {
			case "1":
				System.out.println("���������ȸ�� �����մϴ�.");// 1. ���������ȸ
				break;
			case "2":
				System.out.println("�������ȸ�� �����մϴ�.");// 2. �������ȸ
				break;
			case "3":
				System.out.println("�뿩�α���ȸ�� �����մϴ�."); // 3. �뿩�α���ȸ
				break;
			case "4":
				System.out.println("�����˻��� �����մϴ�.");
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
			}
		}else {
			searchMenu = "999";
		}
		return Integer.parseInt(searchMenu);
	}//searchMenu end

	// admin ������ �޴� : ������
	public static int ManagementProductMenu() {
		System.out.println();
		System.out.println("***************************************");
		System.out.println("\t���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. ����� | 2. ������ | 3. ������� | 4. ��������");

		String ManagementProductMenu = Utils.scanner.nextLine();
		if(ManagementProductMenu.matches(Utils.ONLYNUMBER)) {
			switch (ManagementProductMenu) {
			case "1":
				System.out.println("������� �����մϴ�.");// 1. �����
				break;
			case "2":
				System.out.println("�������� �����մϴ�.");// 2. ������
				break;
			case "3":
				System.out.println("��⸦ �����մϴ�.");// 3. �������
				break;
			case "4":
				System.out.println("�������� �����մϴ�.");// 3. �������
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
			}
		}else {
			ManagementProductMenu = "999";
		}
		return Integer.parseInt(ManagementProductMenu);
	}//ManagementProductMenu end
	
	// ��� ��� : ������
	public static void productListPrint(Map<String, Product> productList, int index) {
		// index 0 : ��ü ���
		// index 1 : �뿩�������
		// index 2 : �����ʿ������
		// Collection clist = map.values(); //value �� �ߺ������� �־ ������ �ִ� ������ ����
		// System.out.println(clist.toString());
		System.out.println();
		Collection productValueList = productList.values();
		switch (index) {
		case 0:
			for (Object o : productValueList) {
				System.out.println(((Product) o).toString());
			}
			break;
		case 1:
			for (Object o : productValueList) {
				// Product�� isAble() true �϶��� ���
				if (((Product) o).isAble()) {
					System.out.println(((Product) o).toString());
				}
			}
			break;
		case 2:
			for (Object o : productValueList) {
				if ((Product) o instanceof ChargeAble) {
					boolean str = (o instanceof ProductOil) ? ((ProductOil)o).isCharged() : ((ProductElectric)o).isCharged();
					System.out.println(((Product) o).toString() + "\t[��������=" + ((str) ? "�����Ϸ�" : "�����ʿ�") + "]");
				}
			}

		}
	}//productListPrint end

	//User�� �뿩���� �������� : ������
	public static void productListPrint(User user) {
		System.out.println();
		// �Ķ���ͷ� ���� ������ �뿩���� ��� ���
		Map<String, Product> hs = user.getRentList();
		Collection productValueList = hs.values();
		for (Object o : productValueList) {
			System.out.println(((Product) o).toString());
		}
	}//productListPrint end

	// ���� ��� : ������
	public static void userListPrint(Map<String, User> userList) {
		System.out.println();
		Collection userValueList = userList.values();
		for (Object o : userValueList) {
			System.out.println(((User) o).toString());
		}
	}//userListPrint end
	
	//�α� ����Ʈ ��� : ������
	public static void logListPrint(List<Log> logList) {
		System.out.println();
		for(Log log : logList) {
			System.out.println(log);
		}
	}//logListPrint end
	
	// �����˻� : ������
	public static void userPrint(Map<String, User> userList, String userId) {
		System.out.println();
		if(userList.containsKey(userId)){
			System.out.println(userList.get(userId));
		} else {
			System.out.println("��ϵ� ���̵� �����ϴ�.");
		}
	}//UserPring end
}
