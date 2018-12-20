package oop.db;
/*
 * add hết vào một model xong gửi model lên repository sau.
 */

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import oop.model.Location;
import oop.model.Organization;
import oop.model.Person;
import oop.model.Relationship;
import oop.model.ThucThe;
import oop.model.Time;
import oop.model.Country;
import oop.model.Event;

public class EntityCreation extends RDFSchema{
	public EntityCreation() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public LinkedHashModel createModelPerson(Person ps) {
		LinkedHashModel model = new LinkedHashModel();
		
		IRI personIRI = vf.createIRI(this.getPerson().toString(),ps.getID());
		
		Literal name = vf.createLiteral(ps.getTenThucThe());
		Literal age = vf.createLiteral(ps.getTuoi());
		Literal job = vf.createLiteral(ps.getNgheNghiep());
		Literal descrip = vf.createLiteral(ps.getMoTa());
		Literal link = vf.createLiteral(ps.getNguon().toString());
		
		model.add(personIRI, this.name, name);
		model.add(personIRI, this.age, age);
		model.add(personIRI, this.job, job);
		model.add(personIRI, this.descrip, descrip);
		model.add(personIRI, this.link, link);
		
		return model;
	}
	public LinkedHashModel createModelLocal(Location local) {
		LinkedHashModel model = new LinkedHashModel();
		
		IRI localIRI = vf.createIRI(this.getLocation().toString(),local.getID());
		
		Literal name = vf.createLiteral(local.getTenThucThe());
		Literal country = vf.createLiteral(local.getQuocGia());
		Literal descrip = vf.createLiteral(local.getMoTa());
		Literal link = vf.createLiteral(local.getNguon().toString());
		
		model.add(localIRI, this.name, name);
		model.add(localIRI, this.country, country);
		model.add(localIRI, this.descrip, descrip);
		model.add(localIRI, this.link, link);
		
		return model;
	}
	public LinkedHashModel createModelCountry(Country country) {
		
		LinkedHashModel model = new LinkedHashModel();
		IRI countryIRI = vf.createIRI(this.getCountry().toString(),country.getID());
		
		Literal name = vf.createLiteral(country.getTenThucThe());
		Literal descrip = vf.createLiteral(country.getMoTa());
		Literal link = vf.createLiteral(country.getNguon().toString());
		
		model.add(countryIRI, this.name, name);
		model.add(countryIRI, this.descrip, descrip);
		model.add(countryIRI, this.link, link);
		
		return model;
	}
	public LinkedHashModel createModelEvent(Event ev) {
		LinkedHashModel model = new LinkedHashModel();
		IRI eventIRI = vf.createIRI(this.getEvent().toString(),ev.getID());
		
		Literal name = vf.createLiteral(ev.getTenThucThe());
		Literal descrip = vf.createLiteral(ev.getMoTa());
		Literal link = vf.createLiteral(ev.getNguon().toString());
		
		model.add(eventIRI, this.name, name);
		model.add(eventIRI, this.descrip, descrip);
		model.add(eventIRI, this.link, link);
		
		return model;
	}
	public LinkedHashModel createModelTime(Time time) {
		LinkedHashModel model = new LinkedHashModel();
		IRI timeIRI = vf.createIRI(this.getTime().toString(),time.getID());
		
		Literal name = vf.createLiteral(time.getTenThucThe());
		Literal descrip = vf.createLiteral(time.getMoTa());
		Literal link = vf.createLiteral(time.getNguon().toString());
		
		model.add(timeIRI, this.name, name);
		model.add(timeIRI, this.descrip, descrip);
		model.add(timeIRI, this.link, link);
		
		return model;
	}
	public LinkedHashModel createModelOrganization(Organization organ) {
		
		LinkedHashModel model = new LinkedHashModel();
		
		IRI organIRI = vf.createIRI(this.getOrganization().toString(),organ.getID());
		
		Literal name = vf.createLiteral(organ.getTenThucThe());
		Literal headerquater = vf.createLiteral(organ.getTruSo());
		Literal estaYear = vf.createLiteral(organ.getNamTL());
		Literal descrip = vf.createLiteral(organ.getMoTa());
		Literal link = vf.createLiteral(organ.getNguon().toString());
		
		model.add(organIRI, this.name, name);
		model.add(organIRI, this.headquater, headerquater);
		model.add(organIRI, this.estaYear, estaYear);
		model.add(organIRI, this.descrip, descrip);
		model.add(organIRI, this.link, link);
		
		return model;
	}
	
	public LinkedHashModel createModelEntity(ThucThe entity) {
		
		if(entity instanceof Person) return createModelPerson((Person) entity);
		if(entity instanceof Location) return createModelLocal((Location) entity);
		if(entity instanceof Organization) return createModelOrganization((Organization) entity);
		if(entity instanceof Event) return createModelEvent((Event) entity);
		if(entity instanceof Country) return createModelCountry((Country) entity);
		if(entity instanceof Time) return createModelTime((Time) entity);
		
		return null;
	}
	
	public IRI createIRI(ThucThe entity) {
		
		if(entity instanceof Person) return vf.createIRI(this.getPerson().toString(),entity.getID());
		if(entity instanceof Location) return vf.createIRI(this.getLocation().toString(),entity.getID());
		if(entity instanceof Organization) return vf.createIRI(this.getOrganization().toString(),entity.getID());
		if(entity instanceof Event) return vf.createIRI(this.getEvent().toString(),entity.getID());
		if(entity instanceof Country) return vf.createIRI(this.getCountry().toString(),entity.getID());
		if(entity instanceof Time) return vf.createIRI(this.getTime().toString(),entity.getID());
		
		return null;
	}
	
	public Statement addRelation(Relationship relate) {
		
		IRI en1IRI = this.createIRI(relate.getTt1());
		IRI en2IRI = this.createIRI(relate.getTt2());
		IRI relateIRI = vf.createIRI(this.getRelation().toString(),relate.getQuanHe());
		Statement stmRelate = vf.createStatement(en1IRI, relateIRI, en2IRI);
		
		return stmRelate;
	}
	
	public RepositoryConnection getRepoConn() {
		return this.repoConn;
	}
	public static void main(String[] args) {
		EntityCreation ec = new EntityCreation();
		Person ps = new Person();
		ps.setID("PERSON1");
		IRI personIRI = ec.createIRI(ps);
		System.out.println(personIRI);
		System.out.println(ec.descrip);
	}
}





















