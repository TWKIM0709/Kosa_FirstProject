package kr.or.tajo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
//김태우
public class User implements Serializable {
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private boolean grade; // 등급(관리자인지 아닌지)
	private Map<String, Product> rentList; // 대여목록
	private int ticket;

	// 생성자함수
	public User(String id, String password, String name, boolean grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.grade = grade;
		this.ticket = 0;
		this.rentList = new HashMap<String, Product>();
	}

	// 대여목록 추가 함수 : 김태우
	public void addRent(Product product) {
		// 이미 대여한 기기일 경우( 쓸 일 없음 )
		if(rentList.containsKey(product.getNo())) {
			System.out.println("이미 대여한 " + product.getKind() + "입니다");
			return;
		}
		
		//목록에 추가
		rentList.put(product.getNo(), product);
		System.out.printf("%s번 기기를 대여목록에 추가했습니다\n",product.getNo());
	}//addRent end
	
	// 대여목록 삭제 함수 : 김태우
	public void deleteRent(String productNo) {
		// 대여하지 않은 기기를 반납하려고 할 경우
		if(!rentList.containsKey(productNo)) {
			System.out.println("대여중인 기기가 아닙니다.");
			return;
		}
		
		//대여 목록에서 삭제
		rentList.remove(productNo);
		System.out.printf("%s번 기기를 대여목록에서 삭제했습니다.\n",productNo);
	}// delRent end
	
	//티켓구매함수 : 김태우
	public void addTicket(int ticket) {
		this.ticket += ticket;
	}// addTicket end
	
	public void useTicket() {
		this.ticket--;
	}
	

	// getter setter toString()
	@Override
	public String toString() {
		return "아이디[" + id + "]\t이름[" + name + "]\t등급[" + ((grade) ? "관리자" : "일반회원") + "]\t대여기기수량["
				+ rentList.size() + "]\t티켓개수[" + ticket + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGrade() {
		return grade;
	}

	public void setGrade(boolean grade) {
		this.grade = grade;
	}

	public Map<String, Product> getRentList() {
		return rentList;
	}

	public void setRentList(Map<String, Product> rentList) {
		this.rentList = rentList;
	}

	public int getTicket() {
		return ticket;
	}
}
