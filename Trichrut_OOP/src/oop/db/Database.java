package oop.db;

import java.util.ArrayList;

import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import oop.gen.DataGeneration;
import oop.model.Relationship;
import oop.model.ThucThe;

public class Database {
	EntityCreation create;
	
	private LinkedHashModel modelEn, modelRela;
	
	private int numOfEn;
	private int numOfRelate;
	
	private DataGeneration dataGen;
	
	public Database(int numOfEn, int numOfRelate) {
		// TODO Auto-generated constructor stub
		modelEn = new LinkedHashModel(numOfEn);
		modelRela = new LinkedHashModel(numOfRelate);
        create = new EntityCreation();
        dataGen = new DataGeneration();
        this.numOfEn = numOfEn;
        this.numOfRelate = numOfRelate;
        createIRIs();
        getConn().clear();
        getConn().add(modelEn);
        getConn().add(modelRela);
	}
	
	public RepositoryConnection getConn() {
		return create.getRepoConn();
	}
	
	private void createIRIs() {
		// TODO Auto-generated method stub
		create = new EntityCreation();
		ArrayList<ThucThe> listEn = new ArrayList<>();
		listEn = dataGen.genData(numOfEn);
		
		ArrayList<Relationship> listRelate = new ArrayList<>();
		listRelate = dataGen.genRelate(numOfRelate);
		
		for(ThucThe en : listEn) {
			LinkedHashModel enIRI = create.createModelEntity(en);
			modelEn.addAll(enIRI);
		}
		
		int count = 1;
		for(Relationship relate : listRelate) {
			modelRela.add(create.addRelation(relate));
			count ++; 
			if(count == 100000) {
				getConn().add(modelRela);
				modelRela.clear();
				count = 0;
			}
		}
	}
	
	public void clearRepo() {
		RepositoryConnection conn = this.getConn();
		conn.clear();
	}
	
}
