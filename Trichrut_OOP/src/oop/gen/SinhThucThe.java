package oop.gen;

import java.util.ArrayList;
import java.util.Random;

import oop.model.NguonGoc;
import oop.model.ThucThe;


public abstract class SinhThucThe {

	protected ArrayList<String> listName;
	protected ArrayList<NguonGoc> listNguon;
	protected final Random RANDOM = new Random();

	protected <T> T getRadom(ArrayList<T> list) {
		// TODO Auto-generated method stub
		int rdIndex = RANDOM.nextInt(list.size());
		T radom = list.get(rdIndex);
		return radom;
	}

	public abstract  ArrayList<ThucThe> sinh(int amount);
}














