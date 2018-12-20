package oop.gen;

import java.util.ArrayList;
import java.util.Random;

import oop.model.Country;
import oop.model.Event;
import oop.model.Location;
import oop.model.Organization;
import oop.model.Person;
import oop.model.Relationship;
import oop.model.ThucThe;
import oop.model.Time;

public class DataGeneration {
	private ArrayList<ThucThe> listEntities;
	private ArrayList<Relationship> listRelate;
	private final Random RANDOM = new Random();
	
	private  ThucThe getRandom(ArrayList<ThucThe> list) {
		// TODO Auto-generated method stub
		int rdIndex = RANDOM.nextInt(list.size());
		ThucThe radom = list.get(rdIndex);
		return radom;
	}
	
	public ArrayList<ThucThe> genData(int amount){
		this.listEntities = new ArrayList<>(amount);
		
		int a = amount / 6;
		int numberOfCountry = 20;
		int numberOfEvent = a;
		int numberOfLocation = a/2;
		int numberOfOrganization = a;
		int numberOfTime = a/9;
		int numberOfPerson = amount - 20 - 2*a - a/9 - a/2;
		
		GenPerson gp = new GenPerson();
		for(int i = 0; i < numberOfPerson; i ++) {
			String ID = "PERSON" + i;
			Person ps = (Person) gp.generate();
			ps.setID(ID);
			listEntities.add(ps);
		}
		
		GenCountry gc = new GenCountry();
		for(int i = 0; i < numberOfCountry; i ++) {
			String ID = "COUNTRY" + i;
			Country country = (Country) gc.generate();
			country.setID(ID);
			listEntities.add(country);
		}
		
		GenEvent ge = new GenEvent();
		for(int i = 0; i < numberOfEvent; i ++) {
			String ID = "EVENT" + i;
			Event ev = (Event) ge.generate();
			ev.setID(ID);
			listEntities.add(ev);
		}
		
		GenOrganization go = new  GenOrganization();
		for(int i = 0; i < numberOfOrganization; i ++) {
			String ID = "ORGANIZATION" + i;
			Organization organ = (Organization) go.generate();
			organ.setID(ID);
			listEntities.add(organ);
		}
		
		GenLocal gl = new GenLocal();
		for(int i = 0; i < numberOfLocation; i ++) {
			String ID = "LOCAL" + i;
			Location local = (Location) gl.generate();
			local.setID(ID);
			listEntities.add(local);
		}
		
		GenTime gt = new GenTime();
		for(int i = 0; i < numberOfTime; i ++) {
			String ID = "TIME" + i;
			Time time = (Time) gt.generate();
			time.setID(ID);
			listEntities.add(time);
		}
		
		return listEntities;
	}
	
	public ArrayList<Relationship> genRelate(int amount){
		
		if(listEntities == null) return null;
		
		this.listRelate = new ArrayList<>(amount);
		GenRelation gr = new GenRelation();
		
		int count = 0;
		while(count <= amount) {
			ThucThe en1 = getRandom(listEntities);
			ThucThe en2 = getRandom(listEntities);
			if(en1.equals(en2)) continue;
			Relationship relate = gr.genRelate(en1, en2);
			if(relate != null) {
				listRelate.add(relate);
				count ++;
			}
		}
		
		return listRelate;
	}
	
//	public static void main(String[] args) {
//		DataGeneration dg = new DataGeneration();
//		ArrayList<ThucThe> list = dg.genData(60000);
//		ArrayList<Relationship> listRe = dg.genRelate(80000);
//		
//		System.out.println(list);
//		System.out.println("sang cái khác");
//		System.out.println(listRe);
//		
//	}
	
}








