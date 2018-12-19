package org.example;


import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Models;
import org.eclipse.rdf4j.model.util.RDFCollections;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.eclipse.rdf4j.sail.nativerdf.NativeStore;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValueFactory factory = SimpleValueFactory.getInstance();

		IRI bob = factory.createIRI("http://example.org/bob");
		IRI name = factory.createIRI("http://example.org/name");
		Literal bobsName = factory.createLiteral("Bob");
		// (IRI)bob name "bob"
		Statement nameStatement = factory.createStatement(
				bob, name, bobsName);
		// (IRI)bob có kiểu RDF là người
		Statement typeStatement = factory.createStatement(
				bob, RDF.TYPE, FOAF.PERSON);

		Model model = new LinkedHashModel();// một collection của các statement set<statement>
		model.add(typeStatement);
		model.add(bob, name, bobsName); // model.add(nameStatement);
		model.add(bob, FOAF.NAME, bobsName);
		//		System.out.println(model);
		// resource là blank node hoặc IRI 
		for(Resource person : model.filter(null, RDF.TYPE, FOAF.PERSON)/*trả về một model có kiểu là RDF và là người*/.subjects()/*trả về một set<resource> của các subject*/) {
			Optional<Literal> names = Models.objectLiteral(
					model.filter(person, name, null));


			//			System.out.println(names);
		}

		ModelBuilder builder = new ModelBuilder();
		builder.setNamespace("ex", "http://example.org/"). // khai báo ex là  viết tắt cho http://example.org/
		setNamespace(FOAF.NS);

		builder.namedGraph("ex:graph1").subject("ex:jonh").
		add(FOAF.NAME, "John").add(FOAF.AGE, 42);
		builder.defaultGraph().add("ex:graph1", RDF.TYPE, "ex:graph");
		Model m = builder.build();
		//		System.out.println(m);

		String ns = "http://example.org/";
		ValueFactory vf = SimpleValueFactory.getInstance();
		IRI favoriteLetters = vf.createIRI(ns,"favoriteLetters");
		IRI jonh = vf.createIRI(ns,"Jonh");
		List<Literal> letters = Arrays.asList(new 
				Literal[] { vf.createLiteral("A"), 
						vf.createLiteral("B"), 
						vf.createLiteral("C") });
		Resource head = vf.createBNode();
		Model aboutJonh = RDFCollections.asRDF(letters, head, new LinkedHashModel()); // danh sách các lá thư
		//		System.out.println(aboutJonh);
		aboutJonh.add(jonh, favoriteLetters, head);// danh sách các lá thư mà jonh thích là 

		File dataDir = new File("C:\\Users\\ManHieu\\Desktop\\myRepo");
		Repository myRepository = new SailRepository(new NativeStore(dataDir));
		myRepository.initialize();
		ValueFactory f = myRepository.getValueFactory();

		// create some resources and literals to make statements out of
		IRI alice = f.createIRI("http://example.org/people/alice");
		IRI cloneAlice = f.createIRI("http://example.org/people/alice");
		IRI bobs = f.createIRI("http://example.org/people/bob");
		IRI names = f.createIRI("http://example.org/ontology/name");
		IRI person = f.createIRI("http://example.org/ontology/Person");
		Literal bobsNames = f.createLiteral("Bob");
		Literal alicesName = f.createLiteral("Alice");

		try ( RepositoryConnection conn = myRepository.getConnection()) {
			
			if(conn != null) System.out.println("thành công");
			// alice is a person
			conn.add(alice, RDF.TYPE, person);
			// alice's name is "Alice"
			conn.add(alice, name, alicesName);
			// bob is a person
			conn.add(bob, RDF.TYPE, person);
			// bob's name is "Bob"
			conn.add(bob, name, bobsName);
			
			System.out.println(conn);
		}
		
	}

}


















