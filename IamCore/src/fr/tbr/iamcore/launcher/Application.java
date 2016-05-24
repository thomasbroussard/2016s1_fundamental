/**
 * 
 */
package fr.tbr.iamcore.launcher;

import java.io.IOException;
import java.util.Scanner;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.service.authentication.AuthenticationService;
import fr.tbr.iamcore.service.dao.IdentityFileDAO;

/**
 * @author tbrou
 *
 */
public class Application {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the IAM System");

		System.out.println("Please enter your user name: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your passord: ");
		String password = scanner.nextLine();

		AuthenticationService authService = new AuthenticationService();
		if (!authService.authenticate(username, password)) {
			System.out.println("The provided credentials are wrong");
			scanner.close();
			return;
		}
		IdentityFileDAO dao = new IdentityFileDAO("/tests/identities.txt");
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

			dao.save(identity);

			break;
		case "2":
			System.out.println("Modification Activity");
			break;

		case "3":
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
