import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;

import config.DBConfig;
import logger.ConsoleLogger;
import logger.DatabaseLogger;
import logger.FileLogger;
import logger.LoggerConfig;
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
		
		LoggerConfig jobLogger = new LoggerConfig();
		ConsoleLogger consoleLog = new ConsoleLogger(warning,error);
		jobLogger.addLogType(consoleLog);
		
		DatabaseLogger databaseLog = new DatabaseLogger(message, error);
		jobLogger.addLogType(databaseLog);
		
		FileLogger fileLog = new FileLogger(PropertiesValue.FILE_DIRECTORY, PropertiesValue.FILE_NAME, warning);
		jobLogger.addLogType(fileLog);
		
		loggerService = new LoggerService(jobLogger);
	}
	
	@Test
	public void logMessageTest(){
		loggerService.log(new Message("test", warning));
	}
	@Test
	public void showDatabase() throws SQLException {
		Statement stmt = DBConfig.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Log_Values");
		while (rs.next()) {
            System.out.println("{ Message: "+rs.getString("text")+", Type: "+rs.getString("type")+"}");
        }
		stmt.close();
	}
}
