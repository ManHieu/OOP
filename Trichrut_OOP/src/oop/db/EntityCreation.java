package oop.db;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;

import oop.model.Location;
import oop.model.Organization;
import oop.model.Person;
import oop.model.ThucThe;
import oop.model.Time;
import oop.model.Country;
import oop.model.Event;

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
	public IRI createIRILocal(Location local) {
		IRI localIRI = vf.createIRI(this.getLocation().toString(),local.getID());
		
		Literal name = vf.createLiteral(local.getTenThucThe());
		Literal country = vf.createLiteral(local.getQuocGia());
		Literal descrip = vf.createLiteral(local.getMoTa());
		Literal link = vf.createLiteral(local.getNguon().toString());
		
		repoConn.add(localIRI, this.name, name);
		repoConn.add(localIRI, this.country, country);
		repoConn.add(localIRI, this.descrip, descrip);
		repoConn.add(localIRI, this.link, link);
		
		return localIRI;
	}
	public IRI createIRICountry(Country country) {
		IRI countryIRI = vf.createIRI(this.getCountry().toString(),country.getID());
		
		Literal name = vf.createLiteral(country.getTenThucThe());
		Literal descrip = vf.createLiteral(country.getMoTa());
		Literal link = vf.createLiteral(country.getNguon().toString());
		
		repoConn.add(countryIRI, this.name, name);
		repoConn.add(countryIRI, this.descrip, descrip);
		repoConn.add(countryIRI, this.link, link);
		
		return countryIRI;
	}
	public IRI createIRIEvent(Event ev) {
		IRI eventIRI = vf.createIRI(this.getEvent().toString(),ev.getID());
		
		Literal name = vf.createLiteral(ev.getTenThucThe());
		Literal descrip = vf.createLiteral(ev.getMoTa());
		Literal link = vf.createLiteral(ev.getNguon().toString());
		
		repoConn.add(eventIRI, this.name, name);
		repoConn.add(eventIRI, this.descrip, descrip);
		repoConn.add(eventIRI, this.link, link);
		
		return eventIRI;
	}
	public IRI createIRITime(Time time) {
		IRI timeIRI = vf.createIRI(this.getTime().toString(),time.getID());
		
		Literal name = vf.createLiteral(time.getTenThucThe());
		Literal descrip = vf.createLiteral(time.getMoTa());
		Literal link = vf.createLiteral(time.getNguon().toString());
		
		repoConn.add(timeIRI, this.name, name);
		repoConn.add(timeIRI, this.descrip, descrip);
		repoConn.add(timeIRI, this.link, link);
		
		return timeIRI;
	}
	public IRI createIRIOrganization(Organization organ) {
		IRI organIRI = vf.createIRI(this.getPerson().toString(),organ.getID());
		
		Literal name = vf.createLiteral(organ.getTenThucThe());
		Literal headerquater = vf.createLiteral(organ.getTruSo());
		Literal estaYear = vf.createLiteral(organ.getNamTL());
		Literal descrip = vf.createLiteral(organ.getMoTa());
		Literal link = vf.createLiteral(organ.getNguon().toString());
		
		repoConn.add(organIRI, this.name, name);
		repoConn.add(organIRI, this.headquater, headerquater);
		repoConn.add(organIRI, this.estaYear, estaYear);
		repoConn.add(organIRI, this.descrip, descrip);
		repoConn.add(organIRI, this.link, link);
		
		return organIRI;
	}
	
	public IRI createIRIEntity(ThucThe entity) {
		
		if(entity instanceof Person) return createIRIPerson((Person) entity);
		if(entity instanceof Location) return createIRILocal((Location) entity);
		if(entity instanceof Organization) return createIRIOrganization((Organization) entity);
		if(entity instanceof Event) return createIRIEvent((Event) entity);
		if(entity instanceof Country) return createIRICountry((Country) entity);
		if(entity instanceof Time) return createIRITime((Time) entity);
		
		return null;
	}
	
	
}























