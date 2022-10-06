package kr.or.tajo;

public class ProductElectric extends Product implements ChargeAble{
	private boolean charged;
	
	public ProductElectric(String no, String kind, int price) {
		super(no, kind, price);
		this.charged = true;
	}

	@Override
	public void charged() {
		this.charged = true;
		System.out.println("���� ���� �Ϸ�");
	}

	public boolean isCharged() {
		return charged;
	}

	public void setCharged(boolean charged) {
		this.charged = charged;
	}
}
