package kr.or.tajo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private boolean grade; // 등급(관리자인지 아닌지)
	private Map<String, Product> rentList; // 대여목록

	// 생성자함수
	public User(String id, String password, String name, boolean grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.grade = grade;
		this.rentList = new HashMap<String, Product>();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", grade=" + grade + ", list="
				+ rentList + "]";
	}

	// getter setter

	// 대여목록 추가 함수

	// 대여목록 삭제 함수
}
