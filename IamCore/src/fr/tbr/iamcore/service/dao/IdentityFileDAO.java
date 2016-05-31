/**
 * 
 */
package fr.tbr.iamcore.service.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.service.matching.Match;
import fr.tbr.iamcore.service.matching.impl.ContainsMatch;
import fr.tbr.iamcore.service.matching.impl.EqualsMatch;

/**
 * A DAO is a class that is able to manage data for instances of an other class
 * it should contain 4 main operations:
 * <ul>
 * <li>Create (here {@link IdentityFileDAO#save(Identity)})</li>
 * <li>Read (here {@link IdentityFileDAO#search(Identity)}</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * @author tbrou
 *
 */
public class IdentityFileDAO {

	private String filePath;
	private PrintWriter writer;
	private Scanner scanner;
	
	private Match matchingStrategy = new ContainsMatch();

	public IdentityFileDAO(String filePath) throws DAOInitializationException {
		if (filePath == null){
			throw new DAOInitializationException("file path was null");
		}
		this.filePath = filePath;
			try{
			File file = new File(filePath);
			if (!file.exists()) {
				File parentFile = file.getParentFile();
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}
				file.createNewFile();
			}

			FileOutputStream fileOutputStream = new FileOutputStream(file, true);
			this.writer = new PrintWriter(fileOutputStream);
			this.scanner = new Scanner(file);
		} catch (IOException ioe) {
			DAOInitializationException daoie = new DAOInitializationException("unable to initialize accesses to the file");
			daoie.initCause(ioe);
			throw daoie;
		}
	}

	/**
	 * This method is able to save an identity into a file
	 * 
	 * @param identity
	 * @throws DAOSaveException 
	 */
	public void save(Identity identity) throws DAOSaveException {
		if (identity == null){
			throw new DAOSaveException("error while trying to save an identity, argument was null");
		}
		if (this.writer == null){
			throw new DAOSaveException("error, not able to write in the file");
		}
		this.writer.println("-----Identity-----");
		this.writer.println(identity.getDisplayName());
		this.writer.println(identity.getEmail());
		this.writer.println(identity.getUid());
		this.writer.println("------------------");
		this.writer.flush();
	}

	public Collection<Identity> search(Identity criteria) {
		List<Identity> identities = new ArrayList<Identity>();
		
		while(scanner.hasNext()){
			scanner.nextLine();
			String displayName = scanner.nextLine();
			String email = scanner.nextLine();
			String uid = scanner.nextLine();
			
			scanner.nextLine();
			
			Identity identity = new Identity(displayName, email, uid);
			if (this.matchingStrategy.match(criteria, identity)){
				identities.add(identity);
			}
	
		}
		
		
		
		return identities;
	
	}


	public void update(Identity identityToUpdate) {

	}

	public void delete(Identity identityToDelete) {

	}

}
