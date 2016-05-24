/**
 * 
 */
package fr.tbr.iamcore.launcher;

import java.util.Scanner;

import fr.tbr.iamcore.service.authentication.AuthenticationService;

/**
 * @author tbrou
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the IAM System");
		
		System.out.println("Please enter your user name: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your passord: ");
		String password = scanner.nextLine();
		
		AuthenticationService authService = new AuthenticationService();
		if (!authService.authenticate(username,password)){
			System.out.println("The provided credentials are wrong");
			scanner.close();
			return;
		}
	
		
		
		scanner.close();
	}

}
