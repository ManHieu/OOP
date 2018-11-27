package oop.gen;

import java.util.ArrayList;

import oop.model.Location;
import oop.model.NguonGoc;
import oop.model.ThucThe;

public class GenLocal extends GenEntity{

	@Override
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		
		
		ArrayList<ThucThe> listOrgan = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "LOCAL" + i;
			String conutry = name.substring(name.indexOf(", ") + 2);
			
			Location local = new Location();
			local.setID(ID);
			local.setNguon(nguonGoc);
			local.setTenThucThe(name);
			local.setQuocGia(conutry);
			i ++;		
		}
		
		return listOrgan;
	}

}
