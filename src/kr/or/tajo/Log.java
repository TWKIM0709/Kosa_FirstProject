package kr.or.tajo;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
	// 변수들
	private String userId; //유저 아이디
	private String productNo; //기기번호
	private String productKind; //기기종류
	private Date startTime; //대여시작시간
	private Date returnTime; //반납 시간
	private long amount; // 결제가격

	public Log(User user, Product product, long amount) {
		//user, product 사용해서 변수들 초기화
		this.userId = user.getId();
		this.productNo = product.getNo();
		this.productKind = product.getKind();
		this.startTime = product.getStartTime();
		returnTime = Utils.cal.getTime();
		this.amount = amount;
	}
	
	public void paymentPrint() {
		// [1234번] [자전거] [12:01-12:30] [12000원]
		System.out.printf("[%s원] [%s] [%s] ~ [%s] [%s원]\n",productNo,productKind,Utils.dateformat.format(startTime),Utils.dateformat.format(returnTime),amount);
	}

	@Override
	public String toString() {
		return "[유저]=" + userId + ", [기기번호]=" + productNo + ", [기기종류]=" + productKind + ", [대여시작시간]="
				+ startTime + ", [대여종료시간]=" + returnTime + ", [결제금액]=" + amount;
	}
}