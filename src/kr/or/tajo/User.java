package kr.or.tajo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
//���¿�
public class User implements Serializable {
	private String id; // ���̵�
	private String password; // ��й�ȣ
	private String name; // �̸�
	private boolean grade; // ���(���������� �ƴ���)
	private Map<String, Product> rentList; // �뿩���
	private int ticket;

	// �������Լ�
	public User(String id, String password, String name, boolean grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.grade = grade;
		this.ticket = 0;
		this.rentList = new HashMap<String, Product>();
	}

	// �뿩��� �߰� �Լ� : ���¿�
	public void addRent(Product product) {
		// �̹� �뿩�� ����� ���( �� �� ���� )
		if(rentList.containsKey(product.getNo())) {
			System.out.println("�̹� �뿩�� " + product.getKind() + "�Դϴ�");
			return;
		}
		
		//��Ͽ� �߰�
		rentList.put(product.getNo(), product);
		System.out.printf("%s�� ��⸦ �뿩��Ͽ� �߰��߽��ϴ�\n",product.getNo());
	}//addRent end
	
	// �뿩��� ���� �Լ� : ���¿�
	public void deleteRent(String productNo) {
		// �뿩���� ���� ��⸦ �ݳ��Ϸ��� �� ���
		if(!rentList.containsKey(productNo)) {
			System.out.println("�뿩���� ��Ⱑ �ƴմϴ�.");
			return;
		}
		
		//�뿩 ��Ͽ��� ����
		rentList.remove(productNo);
		System.out.printf("%s�� ��⸦ �뿩��Ͽ��� �����߽��ϴ�.\n",productNo);
	}// delRent end
	
	//Ƽ�ϱ����Լ� : ���¿�
	public void addTicket(int ticket) {
		this.ticket += ticket;
	}// addTicket end
	
	public void useTicket() {
		this.ticket--;
	}
	

	// getter setter toString()
	@Override
	public String toString() {
		return "���̵�[" + id + "]\t�̸�[" + name + "]\t���[" + ((grade) ? "������" : "�Ϲ�ȸ��") + "]\t�뿩������["
				+ rentList.size() + "]\tƼ�ϰ���[" + ticket + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGrade() {
		return grade;
	}

	public void setGrade(boolean grade) {
		this.grade = grade;
	}

	public Map<String, Product> getRentList() {
		return rentList;
	}

	public void setRentList(Map<String, Product> rentList) {
		this.rentList = rentList;
	}

	public int getTicket() {
		return ticket;
	}
}
