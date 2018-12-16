package oop.db;

import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import oop.gen.DataGeneration;
import oop.model.Relationship;
import oop.model.ThucThe;

public class Database {
	EntityCreation create;
	
	private ArrayList<IRI> entityIRIs;
	
	private int numOfEn;
	private int numOfRelate;
	
	public Database(int numOfEn, int numOfRelate) {
		// TODO Auto-generated constructor stub
		entityIRIs = new ArrayList<>(numOfEn);
        create = new EntityCreation();
        this.numOfEn = numOfEn;
        this.numOfRelate = numOfRelate;
        createIRIs();
	}
	
	public RepositoryConnection getConn() {
		return create.getRepoConn();
	}
	
	private void createIRIs() {
		// TODO Auto-generated method stub
		create = new EntityCreation();
		DataGeneration dataGen = new DataGeneration();
		
		ArrayList<ThucThe> listEn = new ArrayList<>(dataGen.genData(numOfEn));
		ArrayList<Relationship> listRelate = new ArrayList<>(dataGen.genRelate(numOfRelate));
		
		for(ThucThe en : listEn) {
			IRI enIRI = create.createIRIEntity(en);
			entityIRIs.add(enIRI);
		}
		
		for(Relationship relate : listRelate) {
			create.addRelation(relate);
		}
	}
}
