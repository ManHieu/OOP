package oop.gen;

import java.util.ArrayList;
import java.util.Random;

import oop.model.ThucThe;

public class DataGeneration {
	public ArrayList<ThucThe> genData(int amount){
		ArrayList<ThucThe> listEntities = new ArrayList<>(amount);
		
		Random rd = new Random();
		
		int a = amount / 6;
		int nunberOfCountry = rd.nextInt(a) + 1;
		int nunberOfEvent = rd.nextInt(a) + 1;
		int nunberOfLocation = rd.nextInt(a) + 1;
		int nunberOfOrganization = rd.nextInt(a) + 1;
		int nunberOfTime = rd.nextInt(a) + 1;
		int nunberOfPerson = amount - nunberOfCountry - nunberOfEvent - nunberOfLocation - nunberOfOrganization - nunberOfTime;
		
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
}
