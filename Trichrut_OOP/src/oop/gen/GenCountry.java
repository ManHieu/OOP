package oop.gen;

import java.util.ArrayList;

import oop.model.NguonGoc;
import oop.model.Country;
import oop.model.ThucThe;

public class GenCountry extends GenEntity{
	
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		ArrayList<ThucThe> listCountry = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "COUNTRY" + i;

			Country country = new Country();
			country.setID(ID);
			country.setNguon(nguonGoc);
			country.setTenThucThe(name);
			i ++;		
		}
		
		return listCountry;
	}
}
