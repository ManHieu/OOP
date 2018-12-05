package oop.db;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import virtuoso.rdf4j.driver.VirtuosoRepository;

public class VirtuosoRepoConn {
	private final String USER_NAME = "dba";
	private final String PASSWORD = "dba";
	private final String URL = "jdbc:virtuoso://localhost:1111/";
	Repository myRepo;
	RepositoryConnection conn = null;
	
	public RepositoryConnection getConnection() {
		if(conn == null) {
			this.myRepo = new VirtuosoRepository(URL, USER_NAME, PASSWORD);
			this.conn = this.myRepo.getConnection();
		}
		return conn;
	}
}
