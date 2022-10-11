package kr.or.tajo;

import java.util.Map;

public class UserManagement {

	// ȸ������ �Լ�:������
	public boolean userSignUp(Map<String, User> userList) {
		System.out.println();
		// �Ķ���� �޾Ƽ� ����Ȯ��(�ߺ�)Ȯ���ϰ� return
		String idregix = Utils.REGIXID;// ���̵� ���Խ�
		String pwregix = Utils.REGIXPASSWARD;// ��й�ȣ ���Խ�
		String id = "";
		String pw = "";
		String name = "";
		boolean result = true;

		while (result) {
			System.out.print("���̵� �Է����ּ���(���ҹ���+���ڷ� �̷���� 5~19�ڸ�����)\n>>");
			id = Utils.scanner.nextLine();

			if (!(userList.containsKey(id))) {// ���̵� �ߺ� üũ
				if (!id.matches(idregix)) {// ���̵� ���Խ� üũ
					System.out.println("�ùٸ� �������� �Է����ּ���.");
					continue;
				}

			} else {
				System.out.println("�̹̰��Ե� ���̵� �Դϴ�.");
				continue;
			}

			System.out.print("��й�ȣ�� �Է����ּ���.(�ҹ���,�빮��,����,Ư������(@$!%*?&)�� �ϳ� �̻� ���Ե� 8~16�ڸ� ����)\n>>");
			pw = Utils.scanner.nextLine();

			if (!pw.matches(pwregix)) {// ��й�ȣ ���Խ� üũ
				System.out.println("�ùٸ� �������� �Է����ּ���.");
				continue;
			}
			System.out.print("��й�ȣ ���Է�\n>>");
			String pw2 = Utils.scanner.nextLine();

			if (!pw2.equals(pw)) {// ��й�ȣ ��Ȯ�� üũ
				System.out.println("��й�ȣ�� �� ���� ���� �ʽ��ϴ�.");
				continue;
			}
			System.out.print("�̸��� �Է����ּ���.\n>>");
			name = Utils.scanner.nextLine();
			break;

		}

		if (result) {
			userList.put(id, new User(id, pw, name, false));
			System.out.println("ȸ�������� ���ϵ帳�ϴ�.");

		} else {
			System.out.println("ȸ�����Կ� �����߽��ϴ�.");
		}

		return result;
	}// userSignUp end

	// �α��� �Լ�:������
	public String userSingIn(Map<String, User> userList) {
		System.out.println();
		// �Ķ���� �޾Ƽ� ���ϰ� ��� return
		boolean result = true;
		int cnt = 0;
		String id = "";

		while (result) {
			System.out.printf("\n���� �Է¿���Ƚ��(%d/3)\n", cnt);
			if (cnt == 3) {
				System.out.println("���̵� �Ǵ� ��й�ȣ�� 3ȸ�̻� Ʋ�� �޴�ȭ������ ���ư��ϴ�.");
				result = false;
				id = "";
				break;
			}
			System.out.print("���̵� �Է����ּ��� : ");
			id = Utils.scanner.nextLine();
			if (!(userList.containsKey(id))) { // ���̵� �ִ��� Ȯ��
				System.out.println("���̵� ��ġ���� �ʽ��ϴ�.");
				cnt++;
				continue;
			}

			System.out.print("��й�ȣ�� �Է��� �ּ��� : ");
			String pw = Utils.scanner.nextLine();
			if (!(userList.get(id).getPassword().equals(pw))) {
				System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				cnt++;
				continue;
			}
			break;
		}

		return id;
	}// userSingIn end

	// ȸ������������Ʈ: ������
	// ȸ������������Ʈ: ������
	public void userUpdate(Map<String, User> userList, String userId) {
		System.out.println();
		String pwregix = Utils.REGIXPASSWARD;
		roop: while (true) {
			if (userList.containsKey(userId)) {
				
				System.out.println("������ ���Ͻô� ���� �������ּ��� ");
				System.out.println("1.��й�ȣ | 2.�̸� | 3.����");
				String menu = Utils.scanner.nextLine();
				if (menu.equals("1") || menu.equals("2")) {
					System.out.print("��й�ȣ�� �Է��ϼ���\n>>");
					String pw1 = Utils.scanner.nextLine();
					if (pw1.equals(userList.get(userId).getPassword())) {
						System.out.println("\n" + userList.get(userId).toString());
						if (menu.equals("1")) {
							System.out.print("������ ��й�ȣ�� �Է����ּ���\n>>");
							String pw = Utils.scanner.nextLine();

							if (!pw.matches(pwregix)) {// ��й�ȣ ���Խ� üũ
								System.out.println("�ùٸ� �������� �Է����ּ���.");
								continue;
							}
							System.out.print("��й�ȣ ���Է�\n>>");
							String pw2 = Utils.scanner.nextLine();

							if (!pw2.equals(pw)) {// ��й�ȣ ��Ȯ�� üũ
								System.out.println("��й�ȣ�� �� ���� ���� �ʽ��ϴ�.");
								continue;

							} else {
								userList.get(userId).setPassword(pw2);
								System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
								continue;
							}

						} else if (menu.equals("2")) {
							System.out.print("�����Ͻ� �̸��� �Է����ּ���.\n>>");
							String name = Utils.scanner.nextLine();
							userList.get(userId).setName(name);
							continue;

						}
					}
				} else if (menu.equals("3")) {

					System.out.println("����Ǿ����ϴ�.");
					break roop;

				} else {
					System.out.println("�ùٸ� ��ȣ�� �Է����ּ���.");
					break;

				}

			} else {
				System.out.println("�ùٸ� ��й�ȣ�� �Է����ּ���.");
				continue;
			}

		}

	}// userUpdate end

	// ȸ��Ż�� : ������
	public void userDelete(Map<String, User> userList, String userId) {
		System.out.println();
		String input = null;
		System.out.print("��й�ȣ�� �Է����ּ���\n>>");
		String pw = Utils.scanner.nextLine();
		if (pw.equals(userList.get(userId).getPassword())) {// ��й�ȣȮ��
			if ((userList.containsKey(userId))) {
				System.out.println(userList.get(userId).toString());
				while (true) {
					System.out.print("������ �����Ͻðڽ��ϱ�? (Y/N)\n>>");
					input = Utils.scanner.nextLine().toLowerCase();

					if (!input.equals("y") && !input.equals("n")) {
						// y�� n�� �ƴ� �ٸ� �� �Է�
						System.out.println("�ùٸ� ���� �Է����ּ���.");
						continue;
					}
					break;
				}
				if (input.equals("y")) {
					userList.remove(userId);
					System.out.println("�����Ǿ����ϴ�.");
				} else {
					System.out.println("���� ��ҵǾ����ϴ�.");
				}
			} else {
				System.out.println("���� ���̵� �Դϴ�.");
			}
		} else {
			System.out.println("�ùٸ� ��й�ȣ�� �Է��ϼ���.");
		}
	}// userDelete end

	// �����ڿ� ��������
	public void userUpdateAdmin(Map<String, User> userList) {
		String pwregix = Utils.REGIXPASSWARD;
		boolean userck = true;
		TajoPrint.userListPrint(userList);
		// ���� ����
		System.out.print("������ ������ ���̵� �Է��ϼ���.\n>>");
		String userId = Utils.scanner.nextLine();

		if (!userList.containsKey(userId)) {
			System.out.println("��ϵ��� ���� �����Դϴ�.");
			userck = false;
		}

		System.out.println();
		while (userck) { // ������ ������
			System.out.println("\n" + userList.get(userId).toString());
			System.out.println("������ ���ϴ� ���� �������ּ��� ");
			System.out.println("1. ��޺��� | 2.����");
			String menu = Utils.scanner.nextLine().toLowerCase();

			switch (menu) {
			case "1": // ��޺���
				boolean grade = userList.get(userId).isGrade();
				System.out.print("����� �����Ͻðڽ��ϱ�? ���� ����� " + ((grade) ? "������" : "�Ϲ�ȸ��") + "�Դϴ� (y/n)\n>>");
				String str = Utils.scanner.nextLine().toLowerCase();

				switch (str) {
				case "y":
					System.out.println("����� �����߽��ϴ�.");
					userList.get(userId).setGrade(!grade);
					break;
				case "n":
					System.out.println("����� �������� �ʾҽ��ϴ�.");
					break;
				default:
					System.out.println("�߸��� ���� �Է��߽��ϴ�. ����� �������� �ʽ��ϴ�.");
				}
				break;
			case "2": // ����
				System.out.println("����Ǿ����ϴ�.");
				break;
			default:
				System.out.println("�ùٸ� ���� �Է����ּ���.");
				break;
			}
			break;
		}
	}// userUpdate end

	// ƼĹ ���� : ���¿�
	public boolean buyTicket(Map<String, User> userList, String userId) {
		boolean ck = true;
		int amount = 0;
		while (true) {
			// Ƽ�� �ż� �Է�
			System.out.print("������ Ƽ���� ������ �Է��ϼ���(���忡 10000��)\n>>");
			String str = Utils.scanner.nextLine();
			if (!str.matches(Utils.ONLYNUMBER)) {
				System.out.println("���ڸ� �Է��ϼ���");
				continue;
			}
			// ���� - �Էº�
			amount = Integer.parseInt(str) * 10000;
			System.out.printf("Ƽ�ϱݾ� %d �Դϴ�. �����ݾ��� �Է��ϼ���.\n>>", amount);
			str = Utils.scanner.nextLine();
			if (!str.matches(Utils.ONLYNUMBER)) {
				System.out.println("���ڸ� �Է��ϼ���");
				continue;
			}
			//
			// ���� - ����
			if (Integer.parseInt(str) > amount) {
				System.out.println(amount + "�� �����Ǿ����ϴ�. �Ž����� " + (amount - Integer.parseInt(str)) + "�� �Դϴ�.");
			} else if (Integer.parseInt(str) == amount) {
				System.out.println(amount + "�� �����Ǿ����ϴ�.");
			} else {
				System.out.println("�ܾ��� �����մϴ�.");
				ck = false;
				break;
			}
			// ���ſϷ�
			userList.get(userId).addTicket(Integer.parseInt(str) / 10000);
			ck = true;
			break;
		}
		return ck;
	}// buyTicket end
}