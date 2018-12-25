package oop.query;

import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;

import oop.db.RDFSchema;

public class Query extends RDFSchema {
	private ArrayList<String> query;
	public Query() {
		// TODO Auto-generated constructor stub
		super();
		query = new ArrayList<>();
		this.setQuery();
	}
	public ArrayList<String> getQuery() {
		return query;
	}

	public void setQuery() {

		String query1 ="select ?o "
				+ "where {"
				+"<http://example.com/virtuoso#1/Person/PERSON1> <" + this.getDescrip() + "> ?o"
				+ "}";
		this.query.add(query1);

		IRI relateIRI = vf.createIRI(this.getRelation().toString(),"tổ_chức");
		String query2 = "SELECT ?event WHERE{" 
				+"?s <" + relateIRI + "> ?event" +
				"}";
		this.query.add(query2);

		String query3 = "SELECT ?location WHERE{"
				+ " ?s <" + vf.createIRI(this.getRelation().toString(), "tổ_chức_tại") + "> ?location}";
		this.query.add(query3);

		String query4 = "SELECT ?s WHERE{"
				+ "?s <" + vf.createIRI(this.getRelation().toString(), "thành_lập") + "> <" 
				+ vf.createIRI(this.getOrganization().toString(), "ORGANIZATION1") + ">}";
		this.query.add(query4);

		String query5 = "SELECT ?o WHERE{"
				+ " <" + vf.createIRI(this.getOrganization().toString(), "ORGANIZATION1") + "> <"+ this.getHeadquater() + "> ?o}";
		this.query.add(query5);

		String query6 = "SELECT ?s WHERE{"
				+ "?s <" + this.getHeadquater() + "> " + vf.createLiteral("Houston,_UnitedStates") + "}";
		this.query.add(query6);

		String query7 = "SELECT ?p WHERE{"
				+ " <" + vf.createIRI(this.getOrganization().toString(), "ORGANIZATION1") + "> ?p " 
				+ vf.createLiteral("Houston,_UnitedStates") + "}";
		this.query.add(query7);

		String query8 = "SELECT ?s WHERE{"
				+ "?s <" + this.getAge() + "> 21}" ;
		this.query.add(query8);

		String query9 = "SELECT ?relate  WHERE{"
				+ "<http://example.com/virtuoso#1/Person/PERSON1> ?relate <http://example.com/virtuoso#1/Person/PERSON2>}";
		this.query.add(query9);

		String query10 = "SELECT ?s WHERE{"
				+ " ?s <" + this.getName() + "> " + vf.createLiteral("Nguyễn_Văn_Có") + "}" ;

		this.query.add(query10);

		String query11 = "SELECT ?Location WHERE {"
				+ "?location <" + vf.createIRI(this.getRelation().toString(),"tổ_chức") + "> ?event ."
				+ "?event <" + vf.createIRI(this.getRelation().toString(),"diễn_ra_vào") +  "> ?time ."
				+ "?time <" + this.getName() + "> " + vf.createLiteral("1 - 9 - 2018") + "}";
		this.query.add(query11);

		String query12 = "SELECT ?country WHERE{"
				+ "?person <" + vf.createIRI(this.getRelation().toString(),"được_trao_thưởng_bởi") + "> ?country ."
				+ "?person <" + vf.createIRI(this.getRelation().toString(),"lãnh_đạo") + "> ?p ."
				+ "?p <" + this.getName() + "> " + vf.createLiteral("Apple") +"}";
		this.query.add(query12);
		
		String query13 = "SELECT ?event WHERE{"
				+ "?person <" + vf.createIRI(this.getRelation().toString(),"tham_gia") + "> ?event ."
				+ "?person <" + vf.createIRI(this.getRelation().toString(),"thành_lập_nên") + "> ?p ."
				+ "?p <" + this.getName() + "> " + vf.createLiteral("Samsung_Group") +"}";
		this.query.add(query13);
	}

	public static void main(String[] args) {
		Query q = new Query();
		q.setQuery();
		System.out.println(q.getQuery());
	}
}
