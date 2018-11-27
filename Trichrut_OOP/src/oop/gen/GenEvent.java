package oop.gen;

import java.util.ArrayList;
import oop.model.NguonGoc;
import oop.model.Event;
import oop.model.ThucThe;

public class GenEvent extends GenEntity{

	@Override
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		ArrayList<ThucThe> listEvent = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "EVENT" + i;

			Event ev = new Event();
			ev.setID(ID);
			ev.setNguon(nguonGoc);
			ev.setTenThucThe(name);
			i ++;		
		}
		
		return listEvent;
	}

}
