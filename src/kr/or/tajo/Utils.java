package kr.or.tajo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Utils {
	//정규식, 날짜표현, 파일 경로, Scanner 등 static으로
	public static final String BASICPATH = "C:\\Tajo\\";
	public static final String USERPATH = BASICPATH + "user.txt";
	public static final String PRODUCTPATH = BASICPATH + "product.txt";
	public static final String LOGPATH = BASICPATH + "log.txt";
	public static final String SYSTEMINFORPATH = BASICPATH + "systeminfo.txt";
	public static Calendar cal;
	public static Scanner scanner = new Scanner(System.in);
	public static SimpleDateFormat dateformat = new SimpleDateFormat("yy.MM.dd-HH:mm");
	public static final String REGIXID = "^[a-z]+[a-z0-9]{5,19}$";//아이디 제한:윤태호
	public static final String REGIXPASSWARD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$";//비밀번호 제한:윤태호
	public static final String ONLYNUMBER = "^[\\d]{1,5}$";
	
}
