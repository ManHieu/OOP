package oop.gen;

import java.util.Random;

import oop.model.NguonGoc;
import oop.model.ThucThe;
import oop.model.Time;

public class GenTime extends GenEntity{
	private Random rd = new Random();
	
	public ThucThe generate(){
			int day = rd.nextInt(28);
			int mounth = rd.nextInt(12);
			int year = rd.nextInt(90) + 1928;
			
			String str = day + " - " + mounth + " - " + year;
			
			String descrip = "Thời gian này rất quan trọng";
			NguonGoc nguonGoc = getRandom(listNguon);
			
			
			Time time = new Time();
			time.setTenThucThe(str);
			time.setMoTa(descrip);
			time.setNguon(nguonGoc);
			

		return time;
	}
}
