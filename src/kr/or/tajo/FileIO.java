package kr.or.tajo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//파일 경로는 Utils 클래스에 static 변수로 선언되어 있음
//파일 저장, 불러오기는 Ex09 프로젝트 참고해서 하기.
public class FileIO {
	//파일 관련 변수들
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private ObjectInputStream ois;
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;	
	private String filename;
	
	//생성자
	public FileIO() {
		//변수 초기화
		this.file = new File(Utils.BASICPATH);
		fis = null;
		bis = null;
		ois = null;
		fos = null;
		bos = null;
		oos = null;
		filename = "";//나중에 처리
	}//FileIO end
	
	//고객목록(HashMap) 저장, 불러오기
	public void userListSave(Map<String, User> userlist) {
		filename = Utils.USERPATH;//경로 설정하기
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(userlist);
			
			System.out.println("저장되었습니다.");
		} catch (Exception e) {
			System.out.println("저장 실패\n원인: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("저장오류발생\n원인: "+e2);
			}
		}
	}//userListSave end
	
	public Map userListLoad() {	
		Map<String, User> userList = null;
		filename = Utils.USERPATH;//경로 설정하기
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			userList = (HashMap)ois.readObject();
			
			System.out.println("불러오기 성공");
			
		}catch (Exception e) {
			System.out.println("불러오기 실패\n원인: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("로드오류발생\n원인: "+e2);
			}
		}
		return userList;
	}//userListLoad end
	
	//로그목록(HashMap) 저장, 불러오기
	public void logListSave(List<Log> loglist) {
		filename = Utils.LOGPATH;//경로 설정하기
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(loglist);
			
			System.out.println("저장되었습니다.");
		} catch (Exception e) {
			System.out.println("저장 실패\n원인: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("저장오류발생\n원인: "+e2);
			}
		}
	}//logListSave end
	
	public List<Log> logListLoad() {
		List<Log> logList = null;
		filename = Utils.LOGPATH;//경로 설정하기
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			logList = (ArrayList)ois.readObject();
			
			System.out.println("불러오기 성공");
			
		}catch (Exception e) {
			System.out.println("불러오기 실패\n원인: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("로드오류발생\n원인: "+e2);
			}
		}
		return logList;
	}//logListLoad end
	
	//기기목록(ArrayList) 저장, 불러오기
	public void productListSave(Map<String, Product> productlist) {
		filename = Utils.PRODUCTPATH;//경로 설정하기
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(productlist);
			
			System.out.println("저장되었습니다.");
		} catch (Exception e) {
			System.out.println("저장 실패\n원인: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("저장오류발생\n원인: "+e2);
			}
		}
	}//productListSave end
	
	public Map<String, Product> productListLoad() {
		Map<String, Product> productList = null;
		filename = Utils.PRODUCTPATH;//경로 설정하기
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			productList = (HashMap)ois.readObject();
			
			System.out.println("불러오기 성공");
			
		}catch (Exception e) {
			System.out.println("불러오기 실패\n원인: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("로드오류발생\n원인: "+e2);
			}
		}
		return productList;
	}//productListSave end
	
	//시스템정보 저장,불러오기 (총 매출, 총 대여횟수)
	public void systemInfoListSave(TajoSystemInfo systemInfolist) {
		filename = Utils.SYSTEMINFORPATH;//경로 설정하기
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(systemInfolist);
			
			System.out.println("저장되었습니다.");
		} catch (Exception e) {
			System.out.println("저장 실패\n원인: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("저장오류발생\n원인: "+e2);
			}
		}
	}//systemInfoListSave end
	
	public TajoSystemInfo systemInfoListLoad() {
		TajoSystemInfo systemInfoList = null;
		filename = Utils.SYSTEMINFORPATH;//경로 설정하기
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			systemInfoList = (TajoSystemInfo)ois.readObject();
			
			System.out.println("불러오기 성공");
			
		}catch (Exception e) {
			System.out.println("불러오기 실패\n원인: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("로드오류발생\n원인: "+e2);
			}
		}
		return systemInfoList;
	}//systemInfoListLoad end
}
