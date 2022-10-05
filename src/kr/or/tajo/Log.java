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
		this.userId = "user.getId로 수정"; //user객체의 userId 받아오기
		//Product 객체의 제품 번호, 종류, 시작시간 받아오기
		this.amount = amount;
		returnTime = Utils.cal.getTime();
	}
}


// [아이디] [기기번호] [종류] [시작시간] [종료시간] [가격]