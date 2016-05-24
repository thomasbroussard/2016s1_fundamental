/**
 * 
 */
package fr.tbr.iamcore.service.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;

import fr.tbr.iamcore.datamodel.Identity;

/**
 * A DAO is a class that is able to manage data for instances of an other class
 * it should contain 4 main operations:
 * <ul>
 * 	<li>Create (here {@link IdentityFileDAO#save(Identity)})</li>
 * 	<li>Read (here {@link IdentityFileDAO#search(Identity)}</li>
 * 	<li>Update</li>
 * 	<li>Delete</li>
 * </ul>
 * @author tbrou
 *
 */
public class IdentityFileDAO {

	private String filePath;
	private PrintWriter writer;
	private Scanner scanner;
	
	
	public IdentityFileDAO(String filePath) throws IOException {
		this.filePath = filePath;
		
		File file = new File(filePath);
		if (!file.exists()){
			File parentFile = file.getParentFile();
			if (!parentFile.exists()){
				parentFile.mkdirs();
			}
			file.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file, true);
		this.writer = new PrintWriter(fileOutputStream);
		this.scanner = new Scanner(file);
	}
	
	
	/**
	 * This method is able to save an identity into a file
	 * @param identity
	 */
	public void save(Identity identity) {
		
	}
	
	
	public Collection<Identity> search(Identity criteria){
		return null;
	}
	
	
	public void update(Identity identityToUpdate){
		
	}
	
	public void delete(Identity identityToDelete){
		
	}
	
	

}
