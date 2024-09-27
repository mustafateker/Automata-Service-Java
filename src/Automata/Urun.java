package Automata;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Urun {
	private int no;
	private String ad;
	private double fiyat;
	private int stok;
	
	public Urun(String ad, double fiyat, int stok) {
		this.ad = ad;
		this.fiyat = fiyat;
		this.stok = stok;
		
		
	}
	
	public String getAd() {
		return ad;
	}
	public double getFiyat() {
		return fiyat;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
}
