/**
 * 
 */
package fr.tbr.filelib.test.read;

import java.io.IOException;

import fr.tbr.filelib.read.FileDAO;

/**
 * A class to achieve tests operations for the FileDAO
 * @author tbrou
 *
 */
public class ReadTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String filePath = "/tests/file.txt";
		
		FileDAO fileDAO = new FileDAO(filePath);
		String content = fileDAO.readContent();
		
		System.out.println(content);
		
		fileDAO.close();

	}

}
