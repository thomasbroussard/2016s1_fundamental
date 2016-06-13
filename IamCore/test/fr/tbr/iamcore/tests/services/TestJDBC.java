/**
 * 
 */
package fr.tbr.iamcore.tests.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tbrou
 *
 */
public class TestJDBC {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Identities;create=true"
				, "tom", "tom");

		//prepare the query
		PreparedStatement prepareStatement = connection.prepareStatement("select * from IDENTITIES");
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()){
			String displayName = rs.getString("IDENTITY_DISPLAYNAME");
			System.out.println(displayName);
		}
		
		connection.close();
	
	}

}
