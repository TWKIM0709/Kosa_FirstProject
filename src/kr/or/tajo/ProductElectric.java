package kr.or.tajo;

public class ProductElectric extends Product implements ChargeAble{
	private boolean charged;
	
	public ProductElectric(String no, String kind, int price) {
		super(no, kind, price);
		this.charged = true;
	}

	@Override
	public void charged() {
		this.charged = !charged;
		System.out.println("���� ���� �Ϸ�");
	}

	public boolean isCharged() {
		return charged;
	}
}
