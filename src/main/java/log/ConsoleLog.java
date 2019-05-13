package log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import message.Message;
import message.MessageType;

public class ConsoleLog extends Log{
	private static final Logger logger = Logger.getLogger("ConsoleLog");
	public ConsoleLog(MessageType... messageTypes) {
		super(messageTypes);
	}
	@Override
	public void log(Message message) {
		logger.addHandler(new ConsoleHandler());
		logger.log(message.getMessageType().getLevel(), message.getText());
	}
}
