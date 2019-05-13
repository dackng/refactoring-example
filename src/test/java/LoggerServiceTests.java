import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;

import log.ConsoleLog;
import log.DatabaseLog;
import log.FileLog;
import log.JobLogger;
import message.Message;
import message.MessageType;
import service.LoggerService;
import util.PropertiesValue;

public class LoggerServiceTests {
	
	LoggerService loggerService;
	MessageType message;
	MessageType warning;
	MessageType error;
	
	@Before
	public void prepararTest(){
		message = new MessageType(Level.INFO);
		warning = new MessageType(Level.WARNING);
		error = new MessageType(Level.SEVERE);
		
		JobLogger jobLogger = new JobLogger();
		ConsoleLog consoleLog = new ConsoleLog(message);
		jobLogger.addLogType(consoleLog);
		
//		DatabaseLog databaseLog = new DatabaseLog(message, error);
//		jobLogger.addLogType(databaseLog);
//		
//		FileLog fileLog = new FileLog(PropertiesValue.FILE_DIRECTORY, PropertiesValue.FILE_NAME, warning, error);
//		jobLogger.addLogType(fileLog);
		
		loggerService = new LoggerService(jobLogger);
	}
	
	@Test
	public void logMessageTest(){
		loggerService.log(new Message("test", message));
		System.out.println("HOLA");
	}
}
