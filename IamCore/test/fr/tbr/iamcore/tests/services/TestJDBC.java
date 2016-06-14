/**
 * 
 */
package fr.tbr.iamcore.tests.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOSearchException;
import fr.tbr.iamcore.service.dao.IdentityJDBCDAO;

/**
 * @author tbrou
 *
 */
public class TestJDBC {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws DAOSaveException 
	 * @throws DAOInitializationException 
	 * @throws DAOSearchException 
	 */
	public static void main(String[] args) throws SQLException, DAOSaveException, DAOInitializationException, DAOSearchException {
		IdentityJDBCDAO dao = new IdentityJDBCDAO();
		System.out.println(dao.search(null));
		Identity identity = new Identity("Marie", "Bluntzer", null);
		dao.save(identity);
		System.out.println(dao.search(identity));
	}

	private static void testJDBCConnection() throws SQLException {
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
