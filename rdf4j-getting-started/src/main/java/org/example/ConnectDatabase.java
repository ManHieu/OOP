// * To change this license header, choose License Headers in Project Properties.


// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package btl.oop.database;
//
//import org.eclipse.rdf4j.repository.Repository;
//import org.eclipse.rdf4j.repository.RepositoryConnection;
////import org.openrdf.repository.RepositoryConnection;
//import virtuoso.rdf4j.driver.VirtuosoRepository;
//
//public class ConnectDatabase {
//	
//	public RepositoryConnection connectDB() {
//		
//		Repository myRepository = new VirtuosoRepository("jdbc:virtuoso://localhost:1111","dba","dba");
//
//		myRepository.initialize();
//		
//		RepositoryConnection conn = myRepository.getConnection();
//		
//		return conn;
//		
//	}
//	
//	public void close() {
//		this.connectDB().close();
//	}
//        public static void main(String[] args) {
//            ConnectDatabase c = new ConnectDatabase();
//            c.connectDB();
//            if(c.connectDB() != null){
//                System.out.println("Kết nối thành công");
//            }
//            else {
//                System.out.println("Kết nối thất bại");
//            }
//    }
//
//}
//
//
//
package org.example;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import virtuoso.rdf4j.driver.VirtuosoRepository;
public class ConnectDatabase{
	private static String DB_URL = "jdbc:virtuoso://localhost:1111";
	private static String USER_NAME = "dba";
	private static String PASSWORD = "dba";
	public static RepositoryConnection conn;
	
	
	public static void connectDB(){
		try{
			Repository myRepository = new VirtuosoRepository(DB_URL, USER_NAME, PASSWORD);
			myRepository.initialize();
			conn = myRepository.getConnection();
			if(conn != null){
				System.out.println("Kết nối thành công!");
			}
		}
		catch(RepositoryException ex){
			System.out.println("Kết nối thất bại");
		}
		
	}
	public static void closeDB(){	
		try{
			conn.close();
			System.out.println("Đóng kết nối thành công!");
		}
		catch(RepositoryException ex){
			System.out.println("Đóng kết nối thất bại");
		}
	}
//	public static void main(String[] args){
//		
//		ConnectDatabase.connectDB();	
//		ConnectDatabase.closeDB();
//	}	
}
