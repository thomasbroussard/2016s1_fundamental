/**
 * 
 */
package fr.tbr.iamcore.tests.services.logger;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author tbrou
 *
 */
public class TestLog {
	
	static final Logger logger = LogManager.getLogger(TestLog.class);

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, IOException {
//		LogManager logManager = LogManager.getLogManager();
//		logManager.reset();
//		Logger globalLogger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
//		logManager.addLogger(globalLogger);
//		FileHandler handler = new FileHandler("myFile.log", true);
//		SimpleFormatter newFormatter = new SimpleFormatter();
//		handler.setFormatter(newFormatter);
//		globalLogger.addHandler(handler);
//		globalLogger.setLevel(Level.ALL);
//		logManager.reset();
//		Log logger = LogFactory.getLog(Application.class);		
//		logger.error("program started");
		
		logger.info("essai");
	}

}
