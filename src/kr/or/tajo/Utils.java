package kr.or.tajo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Utils {
	//���Խ�, ��¥ǥ��, ���� ���, Scanner �� static����
	public static final String BASICPATH = "C:\\Tajo\\";
	public static final String USERPATH = BASICPATH + "user.txt";
	public static final String PRODUCTPATH = BASICPATH + "product.txt";
	public static final String LOGPATH = BASICPATH + "log.txt";
	public static final String SYSTEMINFORPATH = BASICPATH + "systeminfo.txt";
	public static Calendar cal = Calendar.getInstance();
	public static Scanner scanner = new Scanner(System.in);
	public static SimpleDateFormat dateformat = new SimpleDateFormat("yy.MM.dd-HH:mm");
	public static final String REGIXID = "^[a-z]+[a-z0-9]{5,19}$";//���̵� ����:����ȣ
	public static final String REGIXPASSWARD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$";//��й�ȣ ����:����ȣ
	
	
}
