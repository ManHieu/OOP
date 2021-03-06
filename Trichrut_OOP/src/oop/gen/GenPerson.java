package oop.gen;

import java.io.File;
import java.util.ArrayList;

import oop.file.GetSource;
import oop.model.NguonGoc;
import oop.model.Person;
import oop.model.ThucThe;

public class GenPerson extends GenEntity {

	private ArrayList<String> listJob;
	
	public GenPerson() {
		// TODO Auto-generated constructor stub
		super();
		
		File fJob = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\job.txt");
		this.listJob = GetSource.read(fJob);
		
		File fName = new File("E:\\Git\\OOP\\Trichrut_OOP\\src\\oop\\file\\personLabel.txt");
		this.listName = GetSource.read(fName);
		
	}

	public ThucThe generate() {
		
			String name = getRandom(listName);
			String job = getRandom(listJob);
			NguonGoc  nguonGoc = getRandom(listNguon);
			int tuoi = RANDOM.nextInt(150);
			String descrip = name + " là một " + job + " thành công ";
			
			Person ps = new Person();
			ps.setNgheNghiep(job);
			ps.setTenThucThe(name);
			ps.setNguon(nguonGoc);
			ps.setTuoi(tuoi);
			ps.setMoTa(descrip);

		return ps;
	}
}














