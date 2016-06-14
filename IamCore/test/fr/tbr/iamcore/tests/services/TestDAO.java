/**
 * 
 */
package fr.tbr.iamcore.tests.services;

import java.util.List;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOSearchException;
import fr.tbr.iamcore.exception.DAOUpdateException;
import fr.tbr.iamcore.service.dao.DAODeleteException;
import fr.tbr.iamcore.service.dao.DAOResourceException;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;
import fr.tbr.iamcore.service.dao.IdentityJDBCDAO;

/**
 * @author tbrou
 *
 */
public class TestDAO {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws DAOSaveException 
	 * @throws DAOInitializationException 
	 * @throws DAOSearchException 
	 * @throws DAOUpdateException 
	 * @throws DAODeleteException 
	 * @throws DAOResourceException 
	 */
	public static void main(String[] args) throws DAOSaveException, DAOInitializationException, DAOSearchException, DAOUpdateException, DAODeleteException, DAOResourceException {
		IdentityDAOInterface dao = getDAO();
		System.out.println(dao.search(null));
		Identity identity = new Identity("Marie", "Bluntzer", null);
		System.out.println("before save");
		dao.save(identity);
		List<Identity> identities = dao.search(identity);
		System.out.println("after save");
		
		System.out.println(identities);
		identity = identities.get(0);
		identity.setDisplayName("Jeanne");
		dao.update(identity);
		
		System.out.println("after update");
		identities = dao.search(identity);
		System.out.println(identities);

		dao.delete(identity);
		
		System.out.println("after delete");
		identities = dao.search(identity);
		System.out.println(identities);
		dao.releaseResources();
		
		System.out.println("end of test");

	

		
	}
	

	
	private static IdentityDAOInterface getDAO() throws DAOInitializationException{
		return IdentityJDBCDAO.getInstance();
	}
}
