package oop.gen;

import java.util.ArrayList;
import oop.model.NguonGoc;
import oop.model.Person;
import oop.model.ThucThe;

public class SinhNguoi extends SinhThucThe {

	private ArrayList<String> listJob;

	public ArrayList<ThucThe> sinh(int amount) {
		ArrayList<ThucThe> listPerson = new  ArrayList<>() ;
		
		int i = 0;
		while (i <= amount) {
			String name = getRadom(listName);
			String job = getRadom(listJob);
			NguonGoc  nguonGoc = getRadom(listNguon);
			int tuoi = RANDOM.nextInt(150);
			String ID = "PERSON" + i;
			
			Person ps = new Person();
			ps.setNgheNghiep(job);
			ps.setTenThucThe(name);
			ps.setNguon(nguonGoc);
			ps.setTuoi(tuoi);
			ps.setID(ID);
			
			listPerson.add(ps);

			i ++;		
		}

		return listPerson;
	}
}














