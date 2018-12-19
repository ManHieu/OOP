package oop.gen;

import java.io.File;

import oop.file.GetSource;
import oop.model.Location;
import oop.model.NguonGoc;
import oop.model.ThucThe;

public class GenLocal extends GenEntity{
	
	public GenLocal() {
		// TODO Auto-generated constructor stub
		super();
		File fLocal = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\locationLabel.txt");
		this.listName = GetSource.read(fLocal);
	}

	@Override
	public ThucThe generate() {
		// TODO Auto-generated method stub
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			
			String conutry = name;
			String descrip = name + " là một địa điểm vô cùng nổi tiếng ở " + conutry;
			
			Location local = new Location();
			local.setNguon(nguonGoc);
			local.setTenThucThe(name);
			local.setQuocGia(conutry);
			local.setMoTa(descrip);
		
		return local;
	}
}
