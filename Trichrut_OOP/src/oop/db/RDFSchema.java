package oop.db;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class RDFSchema {
	
	RepositoryConnection repoConn;
	ValueFactory vf;
	
	final String NAMESPACE = "http://example.com/virtuoso#1/";
	
	protected IRI ID, descrip, name, link, date, age, job, time, headquater, estaYear, province;
	protected IRI nguonGoc, event, person, relation, organization, location, country;
	
	public RDFSchema() {
		// TODO Auto-generated constructor stub
		VirtuosoRepoConn virtuosoRepoConn = new VirtuosoRepoConn();
		this.repoConn = virtuosoRepoConn.getConnection();
		this.vf = repoConn.getValueFactory();
		
		ID = vf.createIRI(NAMESPACE, "ID");
		descrip = vf.createIRI(NAMESPACE, "Description");
		name = vf.createIRI(NAMESPACE, "Name");
		link = vf.createIRI(NAMESPACE, "Link");
		date = vf.createIRI(NAMESPACE, "Date");
		age = vf.createIRI(NAMESPACE, "Age");
		job = vf.createIRI(NAMESPACE, "Job");
		time = vf.createIRI(NAMESPACE, "time");
		headquater = vf.createIRI(NAMESPACE, "Headquater");
		estaYear = vf.createIRI(NAMESPACE, "EstaYear");
		province = vf.createIRI(NAMESPACE, "Province");
		
		nguonGoc = vf.createIRI(NAMESPACE, "NgonGoc");
		event = vf.createIRI(NAMESPACE, "Event");
		person = vf.createIRI(NAMESPACE, "Person");
		relation = vf.createIRI(NAMESPACE, "Relationship");
		organization = vf.createIRI(NAMESPACE, "Organization");
		location = vf.createIRI(NAMESPACE, "Location");
		country = vf.createIRI(NAMESPACE, "Country");
		
	}

	public RepositoryConnection getRepoConn() {
		return repoConn;
	}

	public ValueFactory getVf() {
		return vf;
	}

	public String getNAMESPACE() {
		return NAMESPACE;
	}

	public IRI getID() {
		return ID;
	}

	public IRI getDescrip() {
		return descrip;
	}

	public IRI getName() {
		return name;
	}

	public IRI getLink() {
		return link;
	}

	public IRI getDate() {
		return date;
	}

	public IRI getAge() {
		return age;
	}

	public IRI getJob() {
		return job;
	}

	public IRI getTime() {
		return time;
	}

	public IRI getHeadquater() {
		return headquater;
	}

	public IRI getEstaYear() {
		return estaYear;
	}

	public IRI getProvince() {
		return province;
	}

	public IRI getNguonGoc() {
		return nguonGoc;
	}

	public IRI getEvent() {
		return event;
	}

	public IRI getPerson() {
		return person;
	}

	public IRI getRelation() {
		return relation;
	}

	public IRI getOrganization() {
		return organization;
	}

	public IRI getLocation() {
		return location;
	}

	public IRI getCountry() {
		return country;
	}
	
//	public static void main(String[] args) {
//		RDFSchema schema = new RDFSchema();
//		System.out.println(schema.getCountry());
//	}
}




















