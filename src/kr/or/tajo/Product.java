package kr.or.tajo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	private String no; //기기 번호
	private String kind; //기기 종류
	private int price; // 분당 가격
	private boolean able; // 대여 가능 유무 ( true : 대여가능 / false : 대여불가 )
	private Date startRent; // 대여 시작 시간
	
	//생성자
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
