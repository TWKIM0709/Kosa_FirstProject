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
		this.userId = "user.getId�� ����"; //user��ü�� userId �޾ƿ���
		//Product ��ü�� ��ǰ ��ȣ, ����, ���۽ð� �޾ƿ���
		this.amount = amount;
		returnTime = Utils.cal.getTime();
	}
}


// [���̵�] [����ȣ] [����] [���۽ð�] [����ð�] [����]