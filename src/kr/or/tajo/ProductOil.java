package kr.or.tajo;

public class ProductOil extends Product implements ChargeAble{
	private boolean charged;
	
	public ProductOil(String no, String kind, int price) {
		super(no, kind, price);
		this.charged = true;
	}

	@Override
	public void charged() {
		this.charged = true;
		System.out.println("�⸧ ���� �Ϸ�");
	}

	public void setCharged(boolean charged) {
		this.charged = charged;
	}

	public boolean isCharged() {
		return charged;
	}
}
