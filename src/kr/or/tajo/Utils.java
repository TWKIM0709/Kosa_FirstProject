package kr.or.tajo;

import java.util.Calendar;
import java.util.Scanner;

public class Utils {
	//정규식, 날짜표현, 파일 경로, Scanner 등 static으로
	public static final String BASICPATH = "C:\\Tajo\\";
	public static final String USERPATH = BASICPATH + "user.txt";
	public static final String PRODUCTPATH = BASICPATH + "product.txt";
	public static final String LOGPATH = BASICPATH + "log.txt";
	public static final String SYSTEMINFORPATH = BASICPATH + "systeminfo.txt";
	public static Calendar cal = Calendar.getInstance();
	public static Scanner scanner = new Scanner(System.in);
	
	//밑에는 정규식, 날짜 포멧 등
}
