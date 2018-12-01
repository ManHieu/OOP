package oop.gen;

import java.util.ArrayList;
import java.util.Random;

import oop.model.Time;

public class GenTime {
	private Random rd = new Random();
	
	public ArrayList<Time> generate(int amount){
		ArrayList<Time> listTime = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			int day = rd.nextInt(28);
			int mounth = rd.nextInt(12);
			int year = rd.nextInt(90) + 1928;
			
			String str = day + "-" + mounth + "-" + year;
			
			Time time = new Time();
			time.setTime(str);
			
			listTime.add(time);
			i ++;
		}
		return listTime;
	}
}
