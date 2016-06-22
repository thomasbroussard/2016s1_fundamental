/**
 * 
 */
package fr.tbr.iamcore.launcher;

import java.io.IOException;
import java.util.Scanner;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.service.authentication.AuthenticationService;
import fr.tbr.iamcore.service.dao.IdentityFileDAO;

/**
 * @author tbrou
 *
 */
public class Application {
	
	private static final Logger logger =  LogManager.getLogger(Application.class);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		logger.info("program started");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the IAM System");

		System.out.println("Please enter your user name: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		
		logger.info("program received this input : user = {}, password ={} ", username, 
				(password == null ) ? "null" : "****");
		
		AuthenticationService authService = new AuthenticationService();
		if (!authService.authenticate(username, password)) {
			System.out.println("The provided credentials are wrong");
			scanner.close();
			return;
		}
		IdentityFileDAO dao;
		try {
			dao = new IdentityFileDAO("/tests/identities.txt");
		} catch (DAOInitializationException e) {
			System.out.println(e.getInitializationFault());
			System.out.println("unable to initialize, exiting");
			scanner.close();
			return;
		}
		System.out.println("Menu for the IAM application :");
		System.out.println("1 - Create an Identity");
		System.out.println("2 - Update an Identity");
		System.out.println("3 - Delete an Identity");
		System.out.println("4 - Exit");
		System.out.print("your choice (1|2|3|4) : ");
		String menuAnswer = scanner.nextLine();
		switch (menuAnswer) {
		case "1":
			System.out.println("Creation Activity");

			System.out.print("Please enter the Identity display name");
			String displayName = scanner.nextLine();
			System.out.print("Please enter the Identity email address");
			String email = scanner.nextLine();
			System.out.print("Please enter the Identity uid");
			String uid = scanner.nextLine();
			Identity identity = new Identity(displayName, email, uid);

			try {
				dao.save(identity);
			} catch (DAOSaveException e) {
				System.out.println(e.getSaveFault());
			}

			break;
		case "2":
			//Propose a search activity in order to select the identity to modify
			System.out.println("Modification Activity");
			break;

		case "3":
			//Propose a search activity in order to select the identity to delete
			System.out.println("Deletion Activity");
			break;
		case "4":
			System.out.println("The program will now exit");
			scanner.close();
			return;

		default:
			break;
		}

		scanner.close();
	}

}
