package oop.model;


public class NguonGoc {
	
	private String link;
	private String ngayTrichRut;
	
	public NguonGoc(String link, String ngay) {
		// TODO Auto-generated constructor stub
		this.link = link;
		this.ngayTrichRut = ngay;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getNgayTrichRut() {
		return ngayTrichRut;
	}
	public void setNgayTrichRut(String ngayTrichRut) {
		this.ngayTrichRut = ngayTrichRut;
	}
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return link + " - " + ngayTrichRut;
	}
}
