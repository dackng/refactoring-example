package logger;

import java.sql.SQLException;
import java.sql.Statement;

import config.DBConfig;
import config.LoggerException;
import message.Message;
import message.MessageType;

public class DatabaseLogger extends GeneralLogger{
	public DatabaseLogger(MessageType... messageTypes) {
		super(messageTypes);
	}
	@Override
	public void log(Message message) {
		Statement stmt;
		try {
			stmt = DBConfig.getConnection().createStatement();
			stmt.executeUpdate("insert into Log_Values (id, text, type) values (100,'" + message.getText() + "', '" 
					+ message.getMessageType().getLevel().getName() + "')");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoggerException("There was a problem logging a message in database");
		}
	}
}
