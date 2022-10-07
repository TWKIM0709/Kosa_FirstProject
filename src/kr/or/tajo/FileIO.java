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

//���� ��δ� Utils Ŭ������ static ������ ����Ǿ� ����
//���� ����, �ҷ������ Ex09 ������Ʈ �����ؼ� �ϱ�.
public class FileIO {
	//���� ���� ������
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private ObjectInputStream ois;
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;	
	private String filename;
	
	//������
	public FileIO() {
		//���� �ʱ�ȭ
		this.file = new File(Utils.BASICPATH);
		fis = null;
		bis = null;
		ois = null;
		fos = null;
		bos = null;
		oos = null;
		filename = "";//���߿� ó��
	}//FileIO end
	
	//�����(HashMap) ����, �ҷ�����: ����ȣ
	public void userListSave(Map<String, User> userlist) {
		filename = Utils.USERPATH;//��� �����ϱ�
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(userlist);
			
			System.out.println("����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println("���� ����\n����: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("��������߻�\n����: "+e2);
			}
		}
	}//userListSave end
	
	public Map userListLoad() {	
		Map<String, User> userList = null;
		filename = Utils.USERPATH;//��� �����ϱ�
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			userList = (HashMap)ois.readObject();
			
			System.out.println("�ҷ����� ����");
			
		}catch (Exception e) {
			System.out.println("�ҷ����� ����\n����: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("�ε�����߻�\n����: "+e2);
			}
		}
		return userList;
	}//userListLoad end
	
	//�α׸��(HashMap) ����, �ҷ�����: ����ȣ
	public void logListSave(List<Log> loglist) {
		filename = Utils.LOGPATH;//��� �����ϱ�
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(loglist);
			
			System.out.println("����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println("���� ����\n����: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("��������߻�\n����: "+e2);
			}
		}
	}//logListSave end
	
	public List<Log> logListLoad() {
		List<Log> logList = null;
		filename = Utils.LOGPATH;//��� �����ϱ�
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			logList = (ArrayList)ois.readObject();
			
			System.out.println("�ҷ����� ����");
			
		}catch (Exception e) {
			System.out.println("�ҷ����� ����\n����: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("�ε�����߻�\n����: "+e2);
			}
		}
		return logList;
	}//logListLoad end
	
	//�����(ArrayList) ����, �ҷ�����: ����ȣ
	public void productListSave(Map<String, Product> productlist) {
		filename = Utils.PRODUCTPATH;//��� �����ϱ�
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(productlist);
			
			System.out.println("����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println("���� ����\n����: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("��������߻�\n����: "+e2);
			}
		}
	}//productListSave end
	
	public Map<String, Product> productListLoad() {
		Map<String, Product> productList = null;
		filename = Utils.PRODUCTPATH;//��� �����ϱ�
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			productList = (HashMap)ois.readObject();
			
			System.out.println("�ҷ����� ����");
			
		}catch (Exception e) {
			System.out.println("�ҷ����� ����\n����: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("�ε�����߻�\n����: "+e2);
			}
		}
		return productList;
	}//productListSave end
	
	//�ý������� ����,�ҷ����� (�� ����, �� �뿩Ƚ��): ����ȣ
	public void systemInfoListSave(TajoSystemInfo systemInfolist) {
		filename = Utils.SYSTEMINFORPATH;//��� �����ϱ�
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(systemInfolist);
			
			System.out.println("����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println("���� ����\n����: "+e);
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("��������߻�\n����: "+e2);
			}
		}
	}//systemInfoListSave end
	
	public TajoSystemInfo systemInfoListLoad() {
		TajoSystemInfo systemInfoList = null;
		filename = Utils.SYSTEMINFORPATH;//��� �����ϱ�
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			systemInfoList = (TajoSystemInfo)ois.readObject();
			
			System.out.println("�ҷ����� ����");
			
		}catch (Exception e) {
			System.out.println("�ҷ����� ����\n����: "+e);
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			}catch (Exception e2) {
				System.out.println("�ε�����߻�\n����: "+e2);
			}
		}
		return systemInfoList;
	}//systemInfoListLoad end
}
