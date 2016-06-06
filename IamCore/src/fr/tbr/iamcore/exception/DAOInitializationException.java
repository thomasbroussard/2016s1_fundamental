/**
 * 
 */
package fr.tbr.iamcore.exception;

/**
 * @author tbrou
 *
 */
public class DAOInitializationException extends Exception {
	

	
	private String initializationFault;
	
	private DAOExceptionsMessages message;
	
	public DAOInitializationException(String message) {
		this.initializationFault =  message;
	}
	
	public DAOInitializationException(DAOExceptionsMessages message) {
		this.message =  message;
	}

	public String getInitializationFault() {
		return initializationFault;
	}

	
	
}
