package hieu.model;

import java.util.Random;

public class NguoiChoi {
	public String name;
	private int diem;
	
	public int getDiem() {
		
		return diem;
	}
	public void setDiem(int diem) {
		
		this.diem = diem;
	}
	
	public SucXac nhan() {
		
		Random rd = new Random();
		int mat = rd.nextInt(3) + 1;
		SucXac sxNhan = new SucXac(mat);
		
		return sxNhan;
	}
	
	public int gieoSx(SucXac sx) {
		int diem = 0;
		return diem;
	}
	
}
