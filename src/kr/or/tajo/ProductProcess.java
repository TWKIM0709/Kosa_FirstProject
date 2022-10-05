package kr.or.tajo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProductProcess {
	Map products; //기기목록
	
	public ProductProcess(Map products) {
		this.products = products;
	}
	
	//기기 등록 기능
	public void addProduct() {
		//기기 정보 입력 받고
		
		//목록에 추가하기
		
		/*
			Set set = smap.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) 
				it.next();
			로 마지막 키값 찾아내서 + 1;
		 */
	}
	
	//기기 삭제 기능
	public void deleteProduct(String productNo) {
		
	}
	
	//요금계산 기능
	public long calcul(Product product) {
		//입력받은 제품의 가격, 대여 시작시간, 현재 시간을 사용해서 요금 리턴
		return 0;
	}
	
	//기기 대여
	public void rentProduct(User user, Product product) {
		//제품 대여 가능 여부 비교 후
		//유저 대여목록에 추가, 제품 정보 변경(대여여부, 충전)
	}
	//기기 반납	
	public void returnProduct(User user, Product product) {
		//calcul(요금계산기능)함수 이용해서 요금 계산 처리 후
		//유저 대여목록에서 제외, 제품 정보 변경(대여여부, 충전)
	}
}
