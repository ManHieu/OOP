package org.example;

import java.io.File;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.nativerdf.NativeStore;

public class Test5 {
	public static void main(String[] args) {
		ConnectDatabase.connectDB();
		ValueFactory f = ConnectDatabase.conn.getValueFactory();

		// create some resources and literals to make statements out of
		IRI alice = f.createIRI("http://example.org/people/alice");
//		IRI cloneAlice = f.createIRI("http://example.org/people/alice");
		IRI bob = f.createIRI("http://example.org/people/bob");
		IRI ID = f.createIRI("http://example.org/ontology/ID");
		IRI age = f.createIRI("http://example.org/ontology/age");
		IRI person = f.createIRI("http://example.org/ontology/Person");
		Literal bobsName = f.createLiteral("Bob");
		Literal alicesID = f.createLiteral("Alice1");
		Literal aliceAge  = f.createLiteral(9);
		System.out.println(age);

		String query = "select ?s ?o "
				+ "where {"
				+"?s <http://example.org/ontology/ID> \"Alice1\"^^<http://www.w3.org/2001/XMLSchema#String>" + " ."
				+"?s <http://example.org/ontology/age> ?o"
				+ "}";
		String query1 = "select ?o "
				+ "where {"
				+" ?s ?p ?o."
				+"}";

		

		if(ConnectDatabase.conn != null) System.out.println("thành công");
		ConnectDatabase.conn.clear();
		// alice is a person
		ConnectDatabase.conn.add(alice, RDF.TYPE, person);
		// alice's name is "Alice"
		ConnectDatabase.conn.add(alice, ID, alicesID);
		ConnectDatabase.conn.add(alice, age, aliceAge);
		// bob is a person
		ConnectDatabase.conn.add(bob, RDF.TYPE, person);
		// bob's name is "Bob"
		ConnectDatabase.conn.add(bob, ID, bobsName);
		TupleQuery tupleQuery = ConnectDatabase.conn.prepareTupleQuery(QueryLanguage.SPARQL, query);

		try {

			TupleQueryResult result = tupleQuery.evaluate();
			while (result.hasNext()) {

				BindingSet bindingSet = result.next();

				Value v1 = bindingSet.getValue("o");
				Value v2 = bindingSet.getValue("s");
				System.out.println(v1);
				System.out.println(v2);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
