package oop.gen;

import java.util.ArrayList;
import java.util.Random;

import oop.model.Relationship;
import oop.model.ThucThe;

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
		int nunberOfCountry = 20;
		int nunberOfEvent = a;
		int nunberOfLocation = a;
		int nunberOfOrganization = a;
		int nunberOfTime = a/3;
		int nunberOfPerson = amount - 175 - 3*a - a/3;
		
		GenPerson gp = new GenPerson();
		listEntities.addAll(gp.generate(nunberOfPerson));
		
		GenCountry gc = new GenCountry();
		listEntities.addAll(gc.generate(nunberOfCountry));
		
		GenEvent ge = new GenEvent();
		listEntities.addAll(ge.generate(nunberOfEvent));
		
		GenOrganization go = new  GenOrganization();
		listEntities.addAll(go.generate(nunberOfOrganization));
		
		GenLocal gl = new GenLocal();
		listEntities.addAll(gl.generate(nunberOfLocation));
		
		GenTime gt = new GenTime();
		listEntities.addAll(gt.generate(nunberOfTime));
		
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
//		ArrayList<ThucThe> list = dg.genData(5000);
//		ArrayList<Relationship> listRe = dg.genRelate(7000);
//		
//		System.out.println(list);
//		System.out.println("sang cái khác");
//		System.out.println(listRe);
//		
//	}
	
}








