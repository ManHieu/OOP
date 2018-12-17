package oop.gen;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import oop.file.GetSource;
import oop.model.Country;
import oop.model.Event;
import oop.model.Location;
import oop.model.Organization;
import oop.model.Person;
import oop.model.Relationship;
import oop.model.ThucThe;
import oop.model.Time;

public class GenRelation {
	private final Random RANDOM = new Random();
	private ArrayList<String> relatePerson_Person, relatePerson_Ev, relatePerson_Local, relatePerson_Organ;
	
	public GenRelation() {
		// TODO Auto-generated constructor stub
		File fRelatePerson_Person = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\PvsP.txt");
		File fRelatePerson_Ev = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\PvsP.txt");
		File fRelatePerson_Local = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\PvsP.txt");
		File fRelatePerson_Organ = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\PvsP.txt");
		
		this.relatePerson_Person = GetSource.read(fRelatePerson_Person);
		this.relatePerson_Ev = GetSource.read(fRelatePerson_Ev);
		this.relatePerson_Local = GetSource.read(fRelatePerson_Local);
		this.relatePerson_Organ = GetSource.read(fRelatePerson_Organ);
		
	}
	
	private String getRandom(ArrayList<String> list) {
		// TODO Auto-generated method stub
		int rdIndex = RANDOM.nextInt(list.size());
		String radom = list.get(rdIndex);
		return radom;
	}
	
	public Relationship genRelate(ThucThe en1, ThucThe en2) {
		Relationship relate = new Relationship();
		relate.setTt1(en1);
		relate.setTt2(en2);
		if(en1 instanceof Person) {
			if(en2 instanceof Person) {
				String relation = this.getRandom(relatePerson_Person);
				relate.setQuanHe(relation);
				return relate;
			}
			if(en2 instanceof Location || en2 instanceof Country) {
				String relation = this.getRandom(relatePerson_Local);
				relate.setQuanHe(relation);
				return relate;
			}
			if(en2 instanceof Event) {
				String relation = this.getRandom(relatePerson_Ev);
				relate.setQuanHe(relation);
				return relate;
			}
			if(en2 instanceof Organization) {
				String relation = this.getRandom(relatePerson_Organ);
				relate.setQuanHe(relation);
				return relate;
			}
		}
		if(en1 instanceof Organization) {
			if(en2 instanceof Event) {
				String relation = "tổ chức";
				relate.setQuanHe(relation);
				return relate;
			}
			if(en2 instanceof Location || en2 instanceof Country) {
				ArrayList<String> list = new ArrayList<>();
				Collections.addAll(list, "mở chi nhánh tại", "đầu tư vào");
				relate.setQuanHe(getRandom(list));
				return relate;
			}
			if(en2 instanceof Organization) {
				ArrayList<String> list = new ArrayList<>();
				Collections.addAll(list, "hợp tác với", "mua lại", "đầu tư vào");
				relate.setQuanHe(getRandom(list));
				return relate;
			}
		}
		if((en1 instanceof Location || en1 instanceof Country) && (en2 instanceof Event)) {
			String relation = "tổ chức";
			relate.setQuanHe(relation);
			return relate;
		}
		if(en1 instanceof Event) {
			if(en2 instanceof Location || en2 instanceof Country) {
				String relation = "diễn ra tại";
				relate.setQuanHe(relation);
				return relate;
			}
			if(en2 instanceof Time) {
				String relation = "diễn ra vào";
				relate.setQuanHe(relation);
				return relate;
			}
			
		}
		return null;
	}
	
}
