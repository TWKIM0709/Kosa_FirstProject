package kr.or.tajo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TajoSystem {
	//������ ���, ó��Ŭ���� ��
	//��ĳ�ʴ� Utils Ŭ������ static���� �ִ�.
	private Map<String, User> userList; //�������
	private Map<String, Product> productList; //�����
	private List<Log> logList; //�뿩�������
	private FileIO file; //���� ����� ����
	private String userId; //�α��ε� ���� ID
	
	//������
	public TajoSystem() {
		this.userList = new HashMap<String, User>();
		this.productList = new HashMap<String, Product>();
		this.logList = new ArrayList<Log>();
		file = new FileIO();
	}
	
	//run �Լ�
	public void run() {
		//���ϵ� �ҷ�����
		
		//���۸޴�
		//UserManagement �α���, ȸ������ ��� ���
		
			//������ ���
			//ProductProcess ����ؼ� �뿩, �ݳ� ó��
			
			//�������� ���
			//������ �޴��� ����� ��� �Է� �ް�
			//ProductProcess, Product, TajoPrint �� ����� + ó��
	}
	
}
