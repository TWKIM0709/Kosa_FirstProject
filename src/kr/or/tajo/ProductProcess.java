package kr.or.tajo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProductProcess {
	Map products; //�����
	
	public ProductProcess(Map products) {
		this.products = products;
	}
	
	//��� ��� ���
	public void addProduct() {
		//��� ���� �Է� �ް�
		
		//��Ͽ� �߰��ϱ�
		
		/*
			Set set = smap.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) 
				it.next();
			�� ������ Ű�� ã�Ƴ��� + 1;
		 */
	}
	
	//��� ���� ���
	public void deleteProduct(String productNo) {
		
	}
	
	//��ݰ�� ���
	public long calcul(Product product) {
		//�Է¹��� ��ǰ�� ����, �뿩 ���۽ð�, ���� �ð��� ����ؼ� ��� ����
		return 0;
	}
	
	//��� �뿩
	public void rentProduct(User user, Product product) {
		//��ǰ �뿩 ���� ���� �� ��
		//���� �뿩��Ͽ� �߰�, ��ǰ ���� ����(�뿩����, ����)
	}
	//��� �ݳ�	
	public void returnProduct(User user, Product product) {
		//calcul(��ݰ����)�Լ� �̿��ؼ� ��� ��� ó�� ��
		//���� �뿩��Ͽ��� ����, ��ǰ ���� ����(�뿩����, ����)
	}
}
