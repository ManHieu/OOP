package oop.db;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;

import oop.model.Person;

public class EntityCreation extends RDFSchema{
	public EntityCreation() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public IRI createIRIPerson(Person ps) {
		IRI personIRI = vf.createIRI(this.getPerson().toString(),ps.getID());
		
		Literal name = vf.createLiteral(ps.getTenThucThe());
		Literal age = vf.createLiteral(ps.getTuoi());
		Literal job = vf.createLiteral(ps.getNgheNghiep());
		Literal descrip = vf.createLiteral(ps.getMoTa());
		Literal link = vf.createLiteral(ps.getNguon().toString());
		
		repoConn.add(personIRI, this.name, name);
		repoConn.add(personIRI, this.age, age);
		repoConn.add(personIRI, this.job, job);
		repoConn.add(personIRI, this.descrip, descrip);
		repoConn.add(personIRI, this.link, link);
		
		return personIRI;
	}
}























