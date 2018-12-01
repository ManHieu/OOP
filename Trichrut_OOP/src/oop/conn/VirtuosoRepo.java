package oop.conn;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import virtuoso.rdf4j.driver.VirtuosoRepository;

public class VirtuosoRepo {
	private final String USER_NAME = "dba";
	private final String PASSWORD = "dba";
	private final String URL = "jdbc:virtuoso://localhost:1111/";
	private Repository myRepo;
	private RepositoryConnection conn = null;
	
	public RepositoryConnection getConnection() {
		if(conn == null) {
			this.myRepo = new VirtuosoRepository(URL, USER_NAME, PASSWORD);
			this.conn = this.myRepo.getConnection();
		}
		return conn;
	}
}
