package kr.or.tajo;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

//���¿�
public class ProductProcess {
	public Map<String, Product> products; // �����
	// ������

	public ProductProcess(Map<String, Product> products) {
		this.products = products;
	}

	public void setProcess(Map<String, Product> products) {
		this.products = products;
	}

	// ��� ��ȣ ��� �Լ� : ���¿�
	public String getProductNumber() {
		String returnValue = null;

		// ����� ��������� (��Ⱑ ������) ����ȣ�� 0���� ����
		if (products.size() == 0) {
			returnValue = "0";
		} else {
			// ��� ��ȣ ���ϱ�(������ ��ȣ + 1)
			int productNumber = 0; // ��ȣ �ӽ� ����� ����
			Iterator it = products.keySet().iterator(); // Product �ؽøʿ��� Ű���� �̾Ƴ���
			while (it.hasNext()) {
				productNumber = Integer.parseInt((String) it.next()); // ������ Ű�� ���ϴ� ��...
			}
			returnValue = (productNumber + 1) + "";
		}
		return returnValue;
	}// getProductNumber end

	// ��� ��� ��� : ���¿�
	public void addProduct(String kind, int price, String type) {
		String productNumber = getProductNumber();
		Product p = null;
		switch (type) {
		case "0":
			p = ProductFactory.getProduct("normal", productNumber, kind, price);
			break;
		case "1":
			p = ProductFactory.getProduct("electric", productNumber, kind, price);
			break;
		case "2":
			p = ProductFactory.getProduct("oil", productNumber, kind, price);
			break;
		}

		products.put(productNumber, p);
		System.out.printf("%s�� %s�� �д簡�� %d������ �����Ǿ����ϴ�.\n", productNumber, kind, price);
	} // addProduct end

	// ��� ���� ��� : ���¿�
	public void deleteProduct(String productNo) {
		String input = "";
		// ��ϵ��� ���� �����
		if (!products.containsKey(productNo)) {
			System.out.println("�������� �ʴ� ����ȣ�Դϴ�.");
			return;
		}
		// ��ϵ� �����
		// �뿩������ Ȯ��
		if (!products.get(productNo).isAble()) {
			System.out.println("�뿩���� ���� ������ �Ұ����մϴ�.");
			return;
		}
		System.out.println(products.get(productNo));
		while (true) {
			System.out.print("�����Ͻðڽ��ϱ�? (Y/N) >");
			input = Utils.scanner.nextLine().toLowerCase();
			if (!input.equals("y") && !input.equals("n")) {
				// y�� n�� �ƴ� �ٸ� �� �Է�
				System.out.println("�ùٸ� ���� �Է����ּ���.");
				continue;
			}
			break;
		}
		if (input.equals("y")) {
			products.remove(productNo);
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("���� ��ҵǾ����ϴ�.");
		}
	} // deleteProduct end

	// ��ݰ�� ��� : ���¿�
	public long calcul(Product product) {
		// �Է¹��� ��ǰ�� ����, �뿩 ���۽ð�, ���� �ð��� ����ؼ� ��� ����
		// ��� �뿩�ߴ��� ����� * �������� return
		Utils.cal = Calendar.getInstance();
		long diffMin = (Utils.cal.getTime().getTime() - product.getStartTime().getTime()) / 60000;
		return diffMin * product.getPrice();
	}// calcul end

	// �뿩�����ѱ�Ⱑ �ִ��� üũ : ���¿�
	public boolean checkProductList(Map<String, Product> productList) {
		boolean result = false;
		Collection productValueList = productList.values();
		for (Object o : productValueList) {
			// Product�� isAble() true �϶�
			if (((Product) o).isAble()) {
				result = true;
			}
		}
		return result;
	}

	// ��� �뿩 : ���¿�
	public void rentProduct(User user, Product product) {
		// ��Ⱑ �뿩 �Ұ����� ���¶��
		if (!product.isAble()) {
			System.out.println("�뿩 ������ ��Ⱑ �ƴմϴ�.");
			return;
		}
		// ���� ����� �ִ� ����
		if (product instanceof ChargeAble) {
			// ������ �Ǿ� �ִ��� Ȯ��
			if ((product instanceof ProductElectric) ? !((ProductElectric) product).isCharged()
					: !((ProductOil) product).isCharged()) {
				// ������ �Ǿ� ���� ������
				System.out.println("������ �ʿ��� ����Դϴ�.");
				return;
			}
		}

		// �뿩 ������ ��� + �����Ǿ��ִ� ���� �뿩 ����
		// ���� �뿩��Ͽ� �߰�, ��ǰ ���� ����(�뿩����, ����)
		user.addRent(product);

		product.setAble(false);
		Utils.cal = Calendar.getInstance();
		product.setStartTime(Utils.cal.getTime()); // �뿩 ���� �ð� ���
		System.out.println("�뿩����");
	}// rentProduct end

	// ��� �ݳ� : ���¿�
	public Log returnProduct(User user, Product product) {
		// ������ �뿩�� �뿩��Ͽ� product �� ������ �ݳ� ����
		// �뿩���� ��Ⱑ �ƴϸ�
		if (!user.getRentList().containsKey(product.getNo())) {
			System.out.println("�뿩���� ��Ⱑ �ƴմϴ�.");
			return null;
		}
		System.out.println(product.getNo());
		// �ݳ� ����
		long amount = calcul(product); // ���
		long input = 0; // �Է¿� ����
		Log log = new Log(user, product, amount); // ��¿� log
		boolean ck = true; // ���� ���� ����
		boolean ticket = false;// Ƽ���� ������ true ������ false

		// ȭ�� ���
		log.paymentPrint();

		/////////////////////////////////////////////////////////////
		//Ƽ�ϻ�� : ������
		if (user.getTicket() >= 1) {
			System.out.println("1.Ƽ�ϻ�� | 2.������");
			String userTicket = Utils.scanner.nextLine();

			switch (userTicket) {
			case "1":
				System.out.println("Ƽ���� ����մϴ�.");
				user.useTicket();
				ticket = true;
				ck = true;
				break;
			case "2":
				System.out.println("Ƽ���� ��������ʽ��ϴ�.");
				break;
			default:
				System.out.println("�Է��� �߸��ϼ̽��ϴ�. Ƽ���� ��������ʽ��ϴ�.");
			}
		}
		/////////////////////////////////////////////////////////////

		// ���� ����
		if (!ticket) {
			System.out.print("���� �ݾ��� �Է����ּ��� >");
			input = Long.parseLong(Utils.scanner.nextLine());

			if (input > amount) {
				System.out.println(amount + "�� �����Ǿ����ϴ�. �Ž����� " + (amount - input) + "�� �Դϴ�.");
			} else if (input == amount) {
				System.out.println(amount + "�� �����Ǿ����ϴ�.");
			} else {
				System.out.println("�ܾ��� �����մϴ�.");
				ck = false;
			}
		}
		if (ck) {
			// ���� ������ ���
			// ���� �뿩��Ͽ��� ����, ��ǰ ���� ����(�뿩����, ����)
			user.deleteRent(product.getNo()); // �뿩 ��Ͽ��� ����
			product.setAble(true); // �뿩���� ���� true
			product.setStartTime(null); // �뿩 ���� �ð� �ʱ�ȭ
			// ��������� �ִ� ���� �������� ����
			if (product instanceof ChargeAble) {
				if (product instanceof ProductElectric) {
					((ProductElectric) product).setCharged(false);
				} else {
					((ProductOil) product).setCharged(false);
				}
			}
			System.out.println("�ݳ��Ϸ�");
		} else {
			// ���� ������ ���
			log = null;
		}
		return log;
	}// returnProduct end

	// ������ �Լ� :���¿�
	public Map<String, Product> productProcess() {
		String productNumber = "";
		String productName = "";
		Integer productPirce = 0;
		loop: while (true) {
			int index = TajoPrint.ManagementProductMenu();

			switch (index) {
			case 1: // �����
				System.out.println("����� Ÿ���� �Է��ϼ���.(�Ϲ� 0 | ���� 1 | �⸧ 2)");
				String typeInput = Utils.scanner.nextLine();
				if (!typeInput.equals("0") && !typeInput.equals("1") && !typeInput.equals("2")) {
					System.out.println(typeInput);
					System.out.println("�ùٸ� �Է°��� �ƴմϴ�.");
					continue;
				}
				System.out.println("����� ������ �Է��ϼ���. ex) ������, ű����, �ڵ��� ��");
				productName = Utils.scanner.nextLine();
				System.out.println("����� �д� ������ �Է��ϼ���");
				productPirce = Integer.parseInt(Utils.scanner.nextLine());
				addProduct(productName, productPirce, typeInput);
				break;
			case 2: // ������
				TajoPrint.productListPrint(products, 0); // ��ü ����� ���
				System.out.println("������ ����ȣ�� �Է��ϼ���.");
				productNumber = Utils.scanner.nextLine();
				deleteProduct(productNumber);
				break;
			case 3: // �������
				TajoPrint.productListPrint(products, 2); // ���� ����� �ִ� ����� ���

				while (true) {
					System.out.println("������ ����ȣ�� �Է��ϼ���(exit�� ������)");
					productNumber = Utils.scanner.nextLine();

					// exit �Է½�
					if (productNumber.equals("exit")) {
						System.out.println("�����ϱ� ����...");
						return products;
					}

					// ���� ������ ��Ⱑ �ƴ϶��
					if (!(products.get(productNumber) instanceof ChargeAble)) {
						System.out.println("���� ������ ��Ⱑ �ƴմϴ�.");
						continue;
					}

					break;
				}

				// ���� ������ �����
				if (products.get(productNumber) instanceof ProductElectric) {
					((ProductElectric) products.get(productNumber)).charged();
				} else {
					((ProductOil) products.get(productNumber)).charged();
				}

				System.out.println("���� �Ϸ�Ǿ����ϴ�.");
				break;
			case 4:
				System.out.println("������ ����...");
				break loop;
			default:
				System.out.println("�ùٸ� ���� �Է����ּ���");
			}
		}
		return products;
	}

}
