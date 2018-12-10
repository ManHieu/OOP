package oop.model;

public class ThucThe {
	protected NguonGoc nguon;
	protected String ID;
	protected String tenThucThe;
	protected String moTa;
	
	public NguonGoc getNguon() {
		return nguon;
	}
	public void setNguon(NguonGoc nguon) {
		this.nguon = nguon;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTenThucThe() {
		return tenThucThe;
	}
	public void setTenThucThe(String tenThucThe) {
		this.tenThucThe = tenThucThe;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof ThucThe) return ((ThucThe) obj).getID() == this.getID();
		else return false;
	}
	
	
}
