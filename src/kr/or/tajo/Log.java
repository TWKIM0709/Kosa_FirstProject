package kr.or.tajo;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
	// ������
	private String userId; //���� ���̵�
	private String productNo; //����ȣ
	private String productKind; //�������
	private Date startTime; //�뿩���۽ð�
	private Date returnTime; //�ݳ� �ð�
	private long amount; // ��������

	public Log(User user, Product product, long amount) {
		//user, product ����ؼ� ������ �ʱ�ȭ
		this.userId = user.getId();
		this.productNo = product.getNo();
		this.productKind = product.getKind();
		this.startTime = product.getStartTime();
		returnTime = Utils.cal.getTime();
		this.amount = amount;
	}
	
	public void paymentPrint() {
		// [1234��] [������] [12:01-12:30] [12000��]
		System.out.printf("[%s��] [%s] [%s] ~ [%s] [%s��]\n",productNo,productKind,Utils.dateformat.format(startTime),Utils.dateformat.format(returnTime),amount);
	}

	@Override
	public String toString() {
		return "[����]=" + userId + ", [����ȣ]=" + productNo + ", [�������]=" + productKind + ", [�뿩���۽ð�]="
				+ startTime + ", [�뿩����ð�]=" + returnTime + ", [�����ݾ�]=" + amount;
	}
}