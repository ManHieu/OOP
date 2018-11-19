package oop.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetSource {
	
	public static ArrayList<String> read(File f) {
		ArrayList<String> listName = new ArrayList<>();
		try {
			
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			while(br.readLine() != null) {
				 String str = br.readLine();
				 listName.add(str);
			}
			
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listName;
	}
}
