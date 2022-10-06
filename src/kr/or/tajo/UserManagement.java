package kr.or.tajo;

import java.util.Map;

public class UserManagement {
	Map<String, User> userList;

	public UserManagement(Map userList) {
		this.userList = userList;
	}

	// ȸ������ �Լ�:������
	public boolean userSignUp() {
		// �Ķ���� �޾Ƽ� ����Ȯ��(�ߺ�)Ȯ���ϰ� return
		String idregix = Utils.REGIXID;//���̵� ���Խ�
		String pwregix = Utils.REGIXPASSWARD;//��й�ȣ ���Խ�
		String id = "";
		String pw = "";
		String name = "";
		boolean result = true;

		while (result) {
			System.out.println("���̵� �Է����ּ��� : ");
			id = Utils.scanner.nextLine();

			if (!(userList.containsKey(id))) {//���̵� �ߺ� üũ
				if (!id.matches(idregix)) {//���̵� ���Խ� üũ
					System.out.println("�ùٸ� �������� �Է����ּ���.");
					continue;
				}

			} else {
				System.out.println("�̹̰��Ե� ���̵� �Դϴ�.");
				continue;
			}
			System.out.println("��й�ȣ�� �Է����ּ���.");
			pw = Utils.scanner.nextLine();

			if (!pw.matches(pwregix)) {//��й�ȣ ���Խ� üũ
				System.out.println("�ùٸ� �������� �Է����ּ���.");
				continue;
			}
			System.out.println("��й�ȣ ���Է�");
			String pw2 = Utils.scanner.nextLine();

			if (!pw2.equals(pw)) {//��й�ȣ ��Ȯ�� üũ
				System.out.println("��й�ȣ�� �� ���� ���� �ʽ��ϴ�.");
				continue;
			}
			System.out.println("�̸��� �Է����ּ��� :");
			name = Utils.scanner.nextLine();
			break;

		}
		
		if(result) {
			userList.put(id, new User(id, pw, name, false));
			System.out.println("ȸ�������� ���ϵ帳�ϴ�.");
			
		} else {
			System.out.println("ȸ�����Կ� �����߽��ϴ�.");
		}
		
		return result;
	}//userSignUp end

	// �α��� �Լ�:������
	public String userSingIn() {
		// �Ķ���� �޾Ƽ� ���ϰ� ��� return
		boolean result = true;
		int cnt = 0;
		String id="";
		while(result) {
			System.out.println("���̵� �Է����ּ��� : ");
			id = Utils.scanner.nextLine();
			if (!(userList.containsKey(id))) {
				System.out.println("���̵� ��ġ���� �ʽ��ϴ�.");
				cnt++;
				continue;
			}

			System.out.println("��й�ȣ�� �Է��� �ּ��� : ");
			String pw = Utils.scanner.nextLine();
			if (!(userList.get(id).getPassword().equals(pw))) {
				System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
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