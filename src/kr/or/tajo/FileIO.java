package kr.or.tajo;

import java.io.File;
import java.util.Map;

//���� ��δ� Utils Ŭ������ static ������ ����Ǿ� ����
//���� ����, �ҷ������ Ex09 ������Ʈ �����ؼ� �ϱ�.
public class FileIO {
	//���� ���� ������
	private File file;
	
	//������
	public FileIO() {
		//���� �ʱ�ȭ
		this.file = new File(Utils.BASICPATH);
	}
	
	//�����(HashMap) ����, �ҷ�����
	public void userListSave(Map userlist) {
		
	}
	public Map userListLoad() {
		
		return null;
	}
	//�α׸��(HashMap) ����, �ҷ�����
	public void logListSave(Map loglist) {
		
	}
	public Map logListLoad() {
		
		return null;
	}
	
	//�����(ArrayList) ����, �ҷ�����
	public void productListSave(Map productlist) {
		
	}
	public Map productListLoad() {
		
		return null;
	}
	
	//�ý������� ����,�ҷ����� (�� ����, �� �뿩Ƚ��)
	public void systemInfoListSave(Map systemInfolist) {
		
	}
	public Map systemInfoListLoad() {
		
		return null;
	}
}
