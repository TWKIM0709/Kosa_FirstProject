package kr.or.tajo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	private String no; //��� ��ȣ
	private String kind; //��� ����
	private int price; // �д� ����
	private boolean able; // �뿩 ���� ���� ( true : �뿩���� / false : �뿩�Ұ� )
	private Date startRent; // �뿩 ���� �ð�
	
	//������
	public Product(String no, String kind, int price) {
		super();
		this.no = no;
		this.kind = kind;
		this.price = price;
		this.able = true;
		this.startRent = null;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", kind=" + kind + ", price=" + price + ", able=" + able + ", startRent="
				+ startRent + "]";
	}
	
	// getter setter
}
