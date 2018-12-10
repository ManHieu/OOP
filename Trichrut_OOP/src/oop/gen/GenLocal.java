package oop.gen;

import java.io.File;
import java.util.ArrayList;

import oop.file.GetSource;
import oop.model.Location;
import oop.model.NguonGoc;
import oop.model.ThucThe;

public class GenLocal extends GenEntity{
	
	public GenLocal() {
		// TODO Auto-generated constructor stub
		super();
		File fLocal = new File("./oop/file/locationLabel.txt");
		this.listName = GetSource.read(fLocal);
	}

	@Override
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		
		ArrayList<ThucThe> listLocal = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "LOCAL" + i;
			String conutry = name.substring(name.indexOf(", ") + 2);
			String descrip = name + " là một địa điểm vô cùng nổi tiếng ở " + conutry;
			
			Location local = new Location();
			local.setID(ID);
			local.setNguon(nguonGoc);
			local.setTenThucThe(name);
			local.setQuocGia(conutry);
			local.setMoTa(descrip);
			
			listLocal.add(local);
			i ++;		
		}
		
		return listLocal;
	}
	public static void main(String[] args) {
		GenLocal gl = new GenLocal();
		ArrayList<ThucThe> list = new ArrayList<>();
		list = gl.generate(60);
		System.out.println(list);
	}

}
