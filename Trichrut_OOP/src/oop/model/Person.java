package oop.model;

import java.util.Calendar;

public class Person extends ThucThe {
	private String ngheNghiep;
	private int namSinh;

	private final Calendar TODAY = Calendar.getInstance();
	private final int THIS_YEAR = TODAY.get(Calendar.YEAR);
	
	public int getTuoi() {
		
		return THIS_YEAR - namSinh;
	}

	public void setTuoi(int tuoi) {
		
		if(tuoi<= 200 && tuoi >= 0) this.namSinh = THIS_YEAR - tuoi;

	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}
}
