package oop.gen;

import java.io.File;
import java.util.ArrayList;

import oop.model.NguonGoc;
import oop.file.GetSource;
import oop.model.Country;
import oop.model.ThucThe;

public class GenCountry extends GenEntity{
	
	public GenCountry() {
		// TODO Auto-generated constructor stub
		super();
		File fName = new File("/Trichrut_OOP/src/oop/file/countryLabel.txt");
		this.listName = GetSource.read(fName);
	}
	
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		ArrayList<ThucThe> listCountry = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "COUNTRY" + i;
			String descrip = name + " là một đất nước rất hiếu khách";

			Country country = new Country();
			country.setID(ID);
			country.setNguon(nguonGoc);
			country.setTenThucThe(name);
			country.setMoTa(descrip);
			i ++;		
		}
		
		return listCountry;
	}
}
