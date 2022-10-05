package kr.or.tajo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
	private String id; // ���̵�
	private String password; // ��й�ȣ
	private String name; // �̸�
	private boolean grade; // ���(���������� �ƴ���)
	private Map<String, Product> rentList; // �뿩���

	// �������Լ�
	public User(String id, String password, String name, boolean grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.grade = grade;
		this.rentList = new HashMap<String, Product>();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", grade=" + grade + ", list="
				+ rentList + "]";
	}

	// getter setter

	// �뿩��� �߰� �Լ�

	// �뿩��� ���� �Լ�
}
