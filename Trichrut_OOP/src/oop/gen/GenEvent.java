package oop.gen;

import java.io.File;
import java.util.ArrayList;
import oop.model.NguonGoc;
import oop.file.GetSource;
import oop.model.Event;
import oop.model.ThucThe;

public class GenEvent extends GenEntity{
	private ArrayList<String> listDescrip;
	
	public GenEvent() {
		// TODO Auto-generated constructor stub
		super();
		
		File fDescrip = new File("/Trichrut_OOP/src/oop/file/eventDescription.txt");
		this.listDescrip = GetSource.read(fDescrip);
		
		File fName = new File("/Trichrut_OOP/src/oop/file/eventLabel.txt");
		this.listName = GetSource.read(fName);
	}

	@Override
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		ArrayList<ThucThe> listEvent = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "EVENT" + i;
			String descrip = getRandom(listDescrip);

			Event ev = new Event();
			ev.setID(ID);
			ev.setNguon(nguonGoc);
			ev.setTenThucThe(name);
			ev.setMoTa(descrip);
			i ++;		
		}
		
		return listEvent;
	}

}
