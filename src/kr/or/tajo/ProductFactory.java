package kr.or.tajo;

public class ProductFactory {
	public static Product getProduct(String productType,String number,String kind, int price) {
		if(productType == null) return null;
		String typeValue = productType.toLowerCase();
		Product p = null;
		switch(typeValue) {
		case "normal":
			p = new ProductNormal(number, kind, price);
			break;
		case "electric": 
			p = new ProductElectric(number, kind, price);
			break;
		case "oil": 
			p = new ProductOil(number, kind, price);
			break;
		}
		return p;
	}
}
