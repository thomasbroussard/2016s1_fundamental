package fr.tbr.filelib.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileDAO {

	private String filePath;
	private Scanner scanner;
	
	/**
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	public FileDAO(String filePath) throws FileNotFoundException {
		this.filePath = filePath;
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		this.scanner = new Scanner(fileReader);
	
		
	}

	/**
	 * Reads the content from the file
	 * warning, you should have passed a valid path for the file
	 * @return
	 */
	public String readContent() {
		String content = "";
		while (this.scanner.hasNext()){
			content += this.scanner.nextLine();
			content += System.getProperty("line.separator");
		}
		return content;
	}

	/**
	 * 
	 */
	public void close() {
		this.scanner.close();
	}

}
