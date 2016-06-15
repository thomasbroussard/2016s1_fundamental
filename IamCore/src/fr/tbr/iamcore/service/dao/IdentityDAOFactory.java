/**
 * 
 */
package fr.tbr.iamcore.service.dao;

import fr.tbr.iamcore.exception.DAOInitializationException;

/**
 * @author tbrou
 *
 */
public class IdentityDAOFactory {
	
	
	public static IdentityDAOInterface getIdentityDAO() throws DAOInitializationException{
		return IdentityJDBCDAO.getInstance();
	}

}
