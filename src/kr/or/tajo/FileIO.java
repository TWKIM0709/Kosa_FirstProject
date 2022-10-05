package kr.or.tajo;

import java.io.File;
import java.util.Map;

//파일 경로는 Utils 클래스에 static 변수로 선언되어 있음
//파일 저장, 불러오기는 Ex09 프로젝트 참고해서 하기.
public class FileIO {
	//파일 관련 변수들
	private File file;
	
	//생성자
	public FileIO() {
		//변수 초기화
		this.file = new File(Utils.BASICPATH);
	}
	
	//고객목록(HashMap) 저장, 불러오기
	public void userListSave(Map userlist) {
		
	}
	public Map userListLoad() {
		
		return null;
	}
	//로그목록(HashMap) 저장, 불러오기
	public void logListSave(Map loglist) {
		
	}
	public Map logListLoad() {
		
		return null;
	}
	
	//기기목록(ArrayList) 저장, 불러오기
	public void productListSave(Map productlist) {
		
	}
	public Map productListLoad() {
		
		return null;
	}
	
	//시스템정보 저장,불러오기 (총 매출, 총 대여횟수)
	public void systemInfoListSave(Map systemInfolist) {
		
	}
	public Map systemInfoListLoad() {
		
		return null;
	}
}
