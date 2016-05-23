/**
 * 
 */
package fr.tbr.filelib.test.read;

import java.io.FileNotFoundException;
import java.io.IOException;

import fr.tbr.filelib.read.FileDAO;

/**
 * @author tbrou
 *
 */
public class WriteTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String filePath = "/tests/file.txt";
		
		FileDAO fileDAO = new FileDAO(filePath);
		
		fileDAO.writeContent("this is a write test");
		fileDAO.writeContent("this is another test");
	
		
		fileDAO.close();

	}

}
