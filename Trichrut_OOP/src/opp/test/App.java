package opp.test;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.rdf4j.repository.RepositoryConnection;

import oop.db.Database;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database(5999, 6999);
		RepositoryConnection conn = db.getConn();
		
	}

}
