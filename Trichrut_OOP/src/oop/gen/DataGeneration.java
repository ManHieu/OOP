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
	private GenPerson gp;
	private GenCountry gc;
	private GenEvent ge;
	private GenOrganization go;
	private GenLocal gl;
	private GenTime gt;
	private GenRelation gr;
	
	public DataGeneration() {
		// TODO Auto-generated constructor stub
		gp = new GenPerson();
		gc = new GenCountry();
		ge = new GenEvent();
		go = new  GenOrganization();
		gl = new GenLocal();
		gt = new GenTime();
		gr = new GenRelation();
	}
	
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
		
		for(int i = 0; i < numberOfPerson; i ++) {
			String ID = "PERSON" + i;
			Person ps = (Person) gp.generate();
			ps.setID(ID);
			listEntities.add(ps);
		}
		
		for(int i = 0; i < numberOfCountry; i ++) {
			String ID = "COUNTRY" + i;
			Country country = (Country) gc.generate();
			country.setID(ID);
			listEntities.add(country);
		}
		
		for(int i = 0; i < numberOfEvent; i ++) {
			String ID = "EVENT" + i;
			Event ev = (Event) ge.generate();
			ev.setID(ID);
			listEntities.add(ev);
		}
		
		for(int i = 0; i < numberOfOrganization; i ++) {
			String ID = "ORGANIZATION" + i;
			Organization organ = (Organization) go.generate();
			organ.setID(ID);
			listEntities.add(organ);
		}
		
		for(int i = 0; i < numberOfLocation; i ++) {
			String ID = "LOCAL" + i;
			Location local = (Location) gl.generate();
			local.setID(ID);
			listEntities.add(local);
		}
		
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
		
		int count = 0;
		while(count <= amount) {
			ThucThe en1 = getRandom(listEntities);
			ThucThe en2 = getRandom(listEntities);
			Relationship relate = gr.genRelate(en1, en2);
			if(relate != null) {
				listRelate.add(relate);
				
				count ++;
			}
		}
		
		return listRelate;
	}
	
//	public static void main(String[] args) {
//		long t1 = System.currentTimeMillis();
//		DataGeneration dg = new DataGeneration();
//		System.out.println(dg.genData(1000000));
//		System.out.println(dg.genRelate(2000000));
//		System.out.println(System.currentTimeMillis() - t1);
////		System.out.println(java.lang.Runtime.getRuntime().maxMemory());
//	}
}








