package oop.gen;

import java.util.ArrayList;

import oop.model.NguonGoc;
import oop.model.Organization;
import oop.model.ThucThe;

public class GenOrganization extends GenEntity{
	
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		ArrayList<ThucThe> listOrgan = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "ORGANIZATION" + i;

			Organization organ = new Organization();
			organ.setID(ID);
			organ.setNguon(nguonGoc);
			organ.setTenThucThe(name);
			i ++;		
		}
		
		return listOrgan;
	}
}
