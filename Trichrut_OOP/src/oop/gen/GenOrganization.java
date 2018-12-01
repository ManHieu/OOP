package oop.gen;

import java.io.File;
import java.util.ArrayList;

import oop.file.GetSource;
import oop.model.NguonGoc;
import oop.model.Organization;
import oop.model.ThucThe;

public class GenOrganization extends GenEntity{
	
	private ArrayList<String> listHeadquarters;
	
	public GenOrganization() {
		// TODO Auto-generated constructor stub
		super();
		File fOrgan = new File("/Trichrut_OOP/src/oop/file/organizationLabel.txt");
		this.listName = GetSource.read(fOrgan);
		
		File fHeadquarter = new File("/Trichrut_OOP/src/oop/file/organizationHeadquarter.txt");
		this.listHeadquarters = GetSource.read(fHeadquarter);
		
	}
	
	public ArrayList<ThucThe> generate(int amount) {
		// TODO Auto-generated method stub
		ArrayList<ThucThe> listOrgan = new ArrayList<>();
		int i = 0;
		while (i <= amount) {
			String name = getRandom(listName);
			NguonGoc  nguonGoc = getRandom(listNguon);
			String ID = "ORGANIZATION" + i;
			int estaYear = RANDOM.nextInt(118) + 1900;
			String headquarter = getRandom(listHeadquarters);
			String descrip = name +" được thành lập vào năm " + estaYear + ", và có trụ sở tại " + headquarter;

			Organization organ = new Organization();
			organ.setID(ID);
			organ.setNguon(nguonGoc);
			organ.setTenThucThe(name);
			organ.setMoTa(descrip);
			organ.setNamTL(estaYear);
			organ.setTruSo(headquarter);
			i ++;		
		}
		
		return listOrgan;
	}
}
