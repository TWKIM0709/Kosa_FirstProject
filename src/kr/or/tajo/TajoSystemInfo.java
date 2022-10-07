package kr.or.tajo;

import java.io.Serializable;

public class TajoSystemInfo implements Serializable{
	//�� ����, �� �뿩Ƚ��
	private long totalSales;
	private int totalRent;
	
	public TajoSystemInfo(long totalSales, int totalRent) {
		super();
		this.totalSales = totalSales;
		this.totalRent = totalRent;
	}

	public long getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(long totalSales) {
		this.totalSales = totalSales;
	}

	public int getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(int totalRent) {
		this.totalRent = totalRent;
	}
}
