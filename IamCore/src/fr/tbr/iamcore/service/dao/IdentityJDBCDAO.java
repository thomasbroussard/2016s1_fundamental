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
import fr.tbr.iamcore.exception.DAOExceptionsMessages;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSearchException;

/**
 * This class is dealing with the Identity Persistence using a JDBC back-end
 * 
 * @author tbrou
 *
 */
public class IdentityJDBCDAO {

	private static final String QUERY_ALL_IDENTITIES = "select * from IDENTITIES";
	private static final String COLUMN_IDENTITY_DISPLAYNAME = "IDENTITY_DISPLAYNAME";
	private static final String CONF_USERNAME = "tom";
	private static final String CONF_PASSWORD = "tom";
	private static final String CONF_CONNECTION_STRING = "jdbc:derby://localhost:1527/Identities;create=true";
	private Connection connection;

	public IdentityJDBCDAO() throws DAOInitializationException {
		try {
			this.connection = getConnection();
		} catch (SQLException e) {
			DAOInitializationException die = new DAOInitializationException(
					DAOExceptionsMessages.UNABLETOCONNECT);
			die.initCause(e);
			throw die;
		}

	}

	public List<Identity> search(Identity criteria) throws DAOSearchException {
		List<Identity> identities = new ArrayList<>();
		try {

			if (connection.isClosed()) {
				this.connection = getConnection();
			}
			// prepare the query
			PreparedStatement prepareStatement = connection
					.prepareStatement(QUERY_ALL_IDENTITIES);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String displayName = rs.getString(COLUMN_IDENTITY_DISPLAYNAME);
				System.out.println(displayName);
			}

		} catch (SQLException e) {
			DAOSearchException searchException = new DAOSearchException();
			searchException.initCause(e);
			throw searchException;
		}
		return identities;

	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				CONF_CONNECTION_STRING,
				CONF_USERNAME, CONF_PASSWORD);
	}

}
