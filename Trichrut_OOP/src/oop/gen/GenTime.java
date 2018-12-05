package oop.gen;

import java.util.ArrayList;
import java.util.Random;

import oop.model.NguonGoc;
import oop.model.ThucThe;
import oop.model.Time;

public class GenTime extends GenEntity{
	private Random rd = new Random();
	
	public ArrayList<ThucThe> generate(int amount){
		ArrayList<ThucThe> listTime = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			int day = rd.nextInt(28);
			int mounth = rd.nextInt(12);
			int year = rd.nextInt(90) + 1928;
			
			String str = day + " - " + mounth + " - " + year;
			String ID = "TIME" + i;
			String descrip = "Thời gian này rất quan trọng";
			NguonGoc nguonGoc = getRandom(listNguon);
			
			
			Time time = new Time();
			time.setTenThucThe(str);
			time.setID(ID);
			time.setMoTa(descrip);
			time.setNguon(nguonGoc);
			
			listTime.add(time);
			i ++;
		}
		return listTime;
	}
}
