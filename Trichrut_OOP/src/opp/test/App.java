package opp.test;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import oop.db.Database;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database(50000, 60000);
		RepositoryConnection conn = db.getConn();
		
		String query = "select ?o, ?s where {"
				+ "<http://example.com/virtuoso#1/Person/PERSON1> <http://example.com/virtuoso#1/Description/> ?o."
				+ "?s <http://example.com/virtuoso#1/Age/> 20}";
		
		long t1 = System.currentTimeMillis();
		TupleQuery tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, query);
		try {
			
			TupleQueryResult result = tupleQuery.evaluate();
			long t2 = System.currentTimeMillis();
			while (result.hasNext()) {

				BindingSet bindingSet = result.next();

				Value v1 = bindingSet.getValue("o");
				
				
				System.out.println(v1);
				System.out.println(t2 - t1);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
