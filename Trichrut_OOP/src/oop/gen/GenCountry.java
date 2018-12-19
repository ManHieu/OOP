package oop.gen;

import java.io.File;

import oop.model.NguonGoc;
import oop.file.GetSource;
import oop.model.Country;
import oop.model.ThucThe;

public class GenCountry extends GenEntity{
	
	public GenCountry() {
		// TODO Auto-generated constructor stub
		super();
		File fName = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\countryLabel.txt");
		this.listName = GetSource.read(fName);
	}
	
	public ThucThe generate() {
		// TODO Auto-generated method stub
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);	
			String descrip = name + " là một đất nước rất hiếu khách";

			Country country = new Country();
			country.setNguon(nguonGoc);
			country.setTenThucThe(name);
			country.setMoTa(descrip);
			
		return country;
	}
}
