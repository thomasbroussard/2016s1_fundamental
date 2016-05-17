package fr.tbr.bankaccount.launcher;

import java.util.Scanner;

import fr.tbr.bankaccount.datamodel.Customer;
import fr.tbr.bankaccount.datamodel.SavingsAccount;


public class Application {

	/**
	 * Java documentation
	 * (javadoc) which is really helpful, especially if you don't want to spend
	 * too much time on technical documentation
	 * @param args
	 */
	public static void main(String[] args) {
		
		//firstInstantiationTestCase();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type an initial balance");		
		
		String readBalance = scanner.nextLine();
		System.out.println(readBalance);
		
		System.out.println("Please type an interest rate");
		String readRate = scanner.nextLine();
		System.out.println(readRate);
		
		SavingsAccount account = new SavingsAccount(Double.valueOf(readRate), Double.valueOf(readBalance));
		System.out.println(account.getBalance());
		account.withdraw(20.0);
		
		System.out.println(account.getBalance());
		account.computeSavings();
		
		System.out.println(account.getBalance());
		
		scanner.close();
	}

	private static void firstInstantiationTestCase() {
		//line comment
		/*
		 * block comment
		 * several lines
		 * of 
		 * comment
		 */
		
		//Instantiation
		Customer thomas = new Customer();
		
		//Initialization
		thomas.setAddress("123 main street");

		
		
		//Instantiation for the customer julian
		Customer julian = new Customer();
		
		//then initialization of its properties
		julian.setAddress("456 church street");
		julian.setName("Julian");
		
		//the same for savings account
		SavingsAccount savingsAccountJulian = new SavingsAccount(0.02, 125.5 );
		// we're able to set the balance here because savings account inherits from
		// account which has a couple of public getter/setter for the property "balance" 
		
		
		
		//Array creation, with a size of 3
		SavingsAccount[] savingsAccountsArray = new SavingsAccount[3];
		
		//At the first array position we set the instance of savingsAccount 
		// that we created just before
		savingsAccountsArray[0] = savingsAccountJulian;
		
		
		//finally we set the array to be the SavingsAccount list of julian
		julian.setSavingsAccounts(savingsAccountsArray);
	}

}
