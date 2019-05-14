package logger;

import java.util.logging.Logger;

import message.Message;
import message.MessageType;

public class ConsoleLogger extends GeneralLogger{
	private static final Logger logger = Logger.getLogger("ConsoleLog");
	public ConsoleLogger(MessageType... messageTypes) {
		super(messageTypes);
	}
	
	@Override
	public void log(Message message) {
		logger.log(message.getMessageType().getLevel(), message.getText());
	}
}
