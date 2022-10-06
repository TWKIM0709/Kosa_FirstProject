package kr.or.tajo;

import java.util.Collection;
import java.util.Map;

//��ĳ�ʴ� Utils.scanner
public class TajoPrint {

	// �޴���
	// ���۸޴� : ������
	public static int startMenu() {

		System.out.println("***************************************");
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. �α��� | 2. ȸ������ | 3. ����");

		int startMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (startMenu) {
		case 1:
			System.out.println("�α����� �����մϴ�.");// 1. ȸ������
			break;
		case 2:
			System.out.println("ȸ�������� �����մϴ�.");// 2. �α���
			break;
		case 3:
			System.out.println("�����մϴ�.");// 3. ����
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
		}

		return startMenu;
	}

	// ���� �޴� : ������
	public static int userMenu() {
		System.out.println("***************************************");
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. �뿩�ϱ� | 2. �ݳ��ϱ� | 3. ����");

		int userMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (userMenu) {
		case 1:
			System.out.println("�뿩�� �����մϴ�.");// 1. �뿩�ϱ�
			break;
		case 2:
			System.out.println("�ݳ��� �����մϴ�.");// 2. �ݳ��ϱ�
			break;
		case 3:
			System.out.println("�����մϴ�."); // 3. ����
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
		}

		return userMenu;
	}

	// admin �⺻ �޴� : ������
	public static int adminMenu() {
		// 1. �ý��� ��ȸ
		// 2. ������
		System.out.println("***************************************");
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. �ý��� ��ȸ | 2. ������");

		int adminMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (adminMenu) {
		case 1:
			System.out.println("�ý��� ��ȸ�� �����մϴ�.");// 1. �ý��� ��ȸ
			break;
		case 2:
			System.out.println("�������� �����մϴ�.");// 2. ������
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
		}

		return adminMenu;
	}

	// admin ��ȸ �޴� : ������
	public static int searchMenu() {
		// �ý��� ���� ��� ��
		System.out.println("***************************************");
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. ���������ȸ | 2. �������ȸ | 3. �뿩�α���ȸ");

		int searchMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (searchMenu) {
		case 1:
			System.out.println("���������ȸ�� �����մϴ�.");// 1. ���������ȸ
			break;
		case 2:
			System.out.println("�������ȸ�� �����մϴ�.");// 2. �������ȸ
			break;
		case 3:
			System.out.println("�뿩�α���ȸ�� �����մϴ�."); // 3. �뿩�α���ȸ
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
		}

		return searchMenu;
	}

	// admin ������ �޴� : ������
	public static int ManagementProductMenu() {
		System.out.println("***************************************");
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("***************************************");
		System.out.println("1. ����� | 2. ������ | 3. ������� | 4. ��������");

		int ManagementProductMenu = Integer.parseInt(Utils.scanner.nextLine());

		switch (ManagementProductMenu) {
		case 1:
			System.out.println("������� �����մϴ�.");// 1. �����
			break;
		case 2:
			System.out.println("�������� �����մϴ�.");// 2. ������
			break;
		case 3:
			System.out.println("��⸦ �����մϴ�.");// 3. �������
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
		}

		return ManagementProductMenu;
	}
	
	// ��� ��� : ������
	public static void productListPrint(Map<String, Product> productList, int index) {
		// index 0 : ��ü ���
		// index 1 : �뿩�������
		// index 2 : �����ʿ������
		// Collection clist = map.values(); //value �� �ߺ������� �־ ������ �ִ� ������ ����
		// System.out.println(clist.toString());
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
					System.out.println(((Product) o).toString());
				}
			}

		}
	}

	//User�� �뿩���� �������� : ������
	public static void productListPrint(User user) {
		// �Ķ���ͷ� ���� ������ �뿩���� ��� ���
		Map<String, Product> hs = user.getRentList();
		Collection productValueList = hs.values();
		for (Object o : productValueList) {
			System.out.println(((Product) o).toString());
		}
	}

	// ���� ��� : ������
	public static void userListPrint(Map<String, User> userList) {
		Collection userValueList = userList.values();
		for (Object o : userValueList) {
			System.out.println(((User) o).toString());
		}
	}
}
