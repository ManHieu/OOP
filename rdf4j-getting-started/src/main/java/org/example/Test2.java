package org.example;

import java.io.File;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Statement;
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

public class Test2 {
	public static void main(String[] args) {


		File dataDir = new File("C:\\Users\\ManHieu\\Desktop\\myRepo");
		Repository myRepository = new SailRepository(new NativeStore(dataDir));
		myRepository.initialize();
		ValueFactory f = myRepository.getValueFactory();

		// create some resources and literals to make statements out of
		IRI alice = f.createIRI("http://example.org/people/alice");
//		IRI cloneAlice = f.createIRI("http://example.org/people/alice");
		IRI bob = f.createIRI("http://example.org/people/bob");
		IRI ID = f.createIRI("http://example.org/ontology/ID");
		IRI age = f.createIRI("http://example.org/ontology/age");
		IRI person = f.createIRI("http://example.org/ontology/Person");
		Literal bobsName = f.createLiteral("Bob");
		Literal alicesID = f.createLiteral("Alice1");
		Literal aliceAge = f.createLiteral(9);
		System.out.println(age);

		String query = "select ?o "
				+ "where {"
				+"?s <http://example.org/ontology/ID> " + alicesID + " ."
				+"?s <http://example.org/ontology/age> ?o"
				+ "}";

		RepositoryConnection conn = myRepository.getConnection();

		if(conn != null) System.out.println("thành công");
		conn.clear();
		// alice is a person
		conn.add(alice, RDF.TYPE, person);
		// alice's name is "Alice"
		conn.add(alice, ID, alicesID);
		conn.add(alice, age, aliceAge);
		// bob is a person
		conn.add(bob, RDF.TYPE, person);
		// bob's name is "Bob"
		conn.add(bob, ID, bobsName);
		TupleQuery tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, query);

		try {

			TupleQueryResult result = tupleQuery.evaluate();
			while (result.hasNext()) {

				BindingSet bindingSet = result.next();

				Value v1 = bindingSet.getValue("o");
				System.out.println(v1);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
