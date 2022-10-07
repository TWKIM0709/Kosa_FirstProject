package kr.or.tajo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	private String no; //��� ��ȣ
	private String kind; //��� ����
	private int price; // �д� ����
	private boolean able; // �뿩 ���� ���� ( true : �뿩���� / false : �뿩�Ұ� )
	private Date startTime; // �뿩 ���� �ð�
	
	//������
	public Product(String no, String kind, int price) {
		super();
		this.no = no;
		this.kind = kind;
		this.price = price;
		this.able = true;
		this.startTime = null;
	}
	
	@Override
	public String toString() {
		return "����ȣ[" + no + "]\t����[" + kind + "]\t ����[" + price + "]\t�뿩���ɿ���[�뿩" + ((able)?"":"��") + "����]" +
				((startTime != null) ? ("\t�뿩���۽ð�=[" + startTime + "]") : "");
	}
	// getter setter
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAble() {
		return able;
	}

	public void setAble(boolean able) {
		this.able = able;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	
}
