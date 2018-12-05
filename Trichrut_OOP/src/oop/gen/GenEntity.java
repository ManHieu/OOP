package oop.gen;

import java.util.ArrayList;
import java.util.Random;

import oop.model.NguonGoc;
import oop.model.ThucThe;


public abstract class GenEntity {

	protected ArrayList<String> listName;
	protected ArrayList<NguonGoc> listNguon;
	protected final Random RANDOM = new Random();
	
	public GenEntity() {
		// TODO Auto-generated constructor stub
		listNguon = new ArrayList<>();
		listNguon.add(new NguonGoc("baomoi.com", "1/1/2018"));
		listNguon.add(new NguonGoc("news.zing.vn", "27/8/2018"));
		listNguon.add(new NguonGoc("www.msn.com", "5/8/2018"));
	}

	protected <T> T getRandom(ArrayList<T> list) {
		// TODO Auto-generated method stub
		int rdIndex = RANDOM.nextInt(list.size());
		T radom = list.get(rdIndex);
		return radom;
	}

	public abstract  ArrayList<ThucThe> generate(int amount);
	
//	public static void main(String[] args) {
//		GenEntity test = new GenEntity() {
//			
//			@Override
//			public ArrayList<ThucThe> generate(int amount) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		System.out.println(test.listNguon);
//	}
}














