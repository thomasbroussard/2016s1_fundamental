/**
 * 
 */
package fr.tbr.filelib.test.read;

import java.io.FileNotFoundException;

import fr.tbr.filelib.read.FileDAO;

/**
 * @author tbrou
 *
 */
public class ReadTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "/tests/file.txt";
		
		FileDAO fileDAO = new FileDAO(filePath);
		
		String content = fileDAO.readContent();
		
		System.out.println(content);
		
		fileDAO.close();

	}

}
