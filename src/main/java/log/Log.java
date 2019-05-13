package log;

import java.util.Set;

import message.Message;
import message.MessageType;

public abstract class Log {
	private Set<MessageType> messageTypes;
	public Log(MessageType... messageTypes) {
		this.messageTypes = Set.of(messageTypes);
	}
	public abstract void log(Message message);
	public Set<MessageType> getMessageTypes() {
		return messageTypes;
	}
	public void setMessageType(Set<MessageType> messageTypes) {
		this.messageTypes = messageTypes;
	}
}
