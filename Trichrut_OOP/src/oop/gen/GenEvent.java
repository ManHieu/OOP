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

		File fDescrip = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\eventDescription.txt");
		this.listDescrip = GetSource.read(fDescrip);

		File fName = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\eventLabel.txt");
		this.listName = GetSource.read(fName);
	}

	@Override
	public ThucThe generate() {
		// TODO Auto-generated method stub
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);		
			String descrip = getRandom(listDescrip);

			Event ev = new Event();
			ev.setNguon(nguonGoc);
			ev.setTenThucThe(name);
			ev.setMoTa(descrip);

		return ev;
	}
}
