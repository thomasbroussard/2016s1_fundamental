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
	
	public DAOInitializationException(String message) {
		this.initializationFault =  message;
	}

	public String getInitializationFault() {
		return initializationFault;
	}

	
	
}
