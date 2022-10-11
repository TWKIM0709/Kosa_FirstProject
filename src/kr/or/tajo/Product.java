package kr.or.tajo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	private String no; //기기 번호
	private String kind; //기기 종류
	private int price; // 분당 가격
	private boolean able; // 대여 가능 유무 ( true : 대여가능 / false : 대여불가 )
	private Date startTime; // 대여 시작 시간
	
	//생성자
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
		return "기기번호[" + no + "]\t종류[" + kind + "]\t 가격[" + price + "]\t대여가능여부[대여" + ((able)?"":"불") + "가능]" +
				((startTime != null) ? ("\t대여시작시간=[" + startTime + "]") : "");
	}
	// getter setter
	public String getNo() {
		return no;
	}

	public String getKind() {
		return kind;
	}

	public int getPrice() {
		return price;
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
