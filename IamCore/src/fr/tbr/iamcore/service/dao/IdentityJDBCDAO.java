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
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOSearchException;

/**
 * This class is dealing with the Identity Persistence using a JDBC back-end
 * 
 * @author tbrou
 *
 */
public class IdentityJDBCDAO {

	private static final String IDENTITY_UID = "IDENTITY_UID";
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

			Connection connection = getConnection();
			// prepare the query
			PreparedStatement prepareStatement = connection
					.prepareStatement(QUERY_ALL_IDENTITIES);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String displayName = rs.getString(COLUMN_IDENTITY_DISPLAYNAME);
				String uid = rs.getString(IDENTITY_UID);
				String email = rs.getString("IDENTITY_EMAIL");
				Identity identity = new Identity(displayName, email, uid);
				identities.add(identity);
			}

		} catch (SQLException e) {
			DAOSearchException searchException = new DAOSearchException();
			searchException.initCause(e);
			throw searchException;
		}
		return identities;

	}

	public void save(Identity identity) throws DAOSaveException {
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement("insert into IDENTITIES (IDENTITY_DISPLAYNAME, IDENTITY_EMAIL) "
					+ "values( ?, ?)");
			
			pstmt.setString(1, identity.getDisplayName());
			pstmt.setString(2, identity.getEmail());
			pstmt.execute();
			
			
		} catch (SQLException sqle) {
			DAOSaveException dse = new DAOSaveException("problem...");
			dse.initCause(sqle);
			throw dse;
		}

	}

	private Connection getConnection() throws SQLException {
		if (this.connection.isClosed()){
			this.connection = DriverManager.getConnection(CONF_CONNECTION_STRING,
					CONF_USERNAME, CONF_PASSWORD);
		}
		return this.connection;
		
	}

	// insert into "TOM"."IDENTITIES" ("IDENTITY_DISPLAYNAME", "IDENTITY_EMAIL")
	// values('Quentin Decayeux', 'qdeca@natsystem.fr')
}
