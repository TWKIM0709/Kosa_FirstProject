package kr.or.tajo;

import java.io.Serializable;

public class TajoSystemInfo implements Serializable{
	//ÃÑ ¸ÅÃâ, ÃÑ ´ë¿©È½¼ö
	private long totalSales;
	private int totalRent;
	
	public TajoSystemInfo(long totalSales, int totalRent) {
		super();
		this.totalSales = totalSales;
		this.totalRent = totalRent;
	}
}
