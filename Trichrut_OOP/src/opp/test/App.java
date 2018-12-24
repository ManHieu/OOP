package opp.test;

import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import oop.db.Database;
import oop.query.Query;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database(50000, 60000);
		RepositoryConnection conn = db.getConn();
		Query q = new Query();
		int i = 1;
		for(String query : q.getQuery()) {
		
		long t1 = System.currentTimeMillis();
		TupleQuery tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, query);
		
		try {
			TupleQueryResult result = tupleQuery.evaluate();
			long t2 = System.currentTimeMillis();
			System.out.println("TV" + i);
			System.out.println(t2 - t1);
			i ++;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
	}

}
