/**
 * 
 */
package fr.tbr.iamcore.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSearchException;

/**
 * This class is dealing with the Identity Persistence
 * using a JDBC back-end
 * @author tbrou
 *
 */
public class IdentityJDBCDAO {
	
	
	public List<Identity> search(Identity criteria) throws DAOSearchException{
		List<Identity> identities = new ArrayList<>(); 
		
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Identities;create=true"
					, "tom", "tom");
		} catch (SQLException e) {
			DAOSearchException searchException = new DAOSearchException();
			searchException.initCause(e);
			throw searchException;
		}

		//prepare the query
		PreparedStatement prepareStatement = connection.prepareStatement("select * from IDENTITIES");
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()){
			String displayName = rs.getString("IDENTITY_DISPLAYNAME");
			System.out.println(displayName);
		}
		
		connection.close();
		
		return identities;
		
		
	}
	

}
