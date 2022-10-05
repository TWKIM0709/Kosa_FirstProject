package kr.or.tajo;

public class ProductOil extends Product implements ChargeAble{
	private boolean charged;
	
	public ProductOil(String no, String kind, int price) {
		super(no, kind, price);
		this.charged = true;
	}

	@Override
	public void charged() {
		this.charged = !charged;
		System.out.println("기름 충전 완료");
	}

	public boolean isCharged() {
		return charged;
	}
}
