package kr.or.tajo;

import java.io.Serializable;
import java.util.Calendar;
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
		Utils.cal = Calendar.getInstance();
		returnTime = Utils.cal.getTime();
		this.amount = amount;
	}
	
	public void paymentPrint() {
		// [1234��] [������] [12:01-12:30] [12000��]
		System.out.printf("[%s��] [%s] [%s] ~ [%s] [%s��]\n",productNo,productKind,Utils.dateformat.format(startTime),Utils.dateformat.format(returnTime),amount);
	}

	@Override
	public String toString() {
		long diffMin = (startTime.getTime() - returnTime.getTime()) / 60000;
		//����[test123] ����ȣ[2] �������[������] 
		return "����[" + userId + "] ����ȣ[" + productNo + "] �������[" + productKind + "] �뿩�ð�["
		+ Utils.dateformat.format(startTime) + " ~ " + Utils.dateformat.format(returnTime) + " " + diffMin +"��] �����ݾ�[" + amount + "��]";
	}
}