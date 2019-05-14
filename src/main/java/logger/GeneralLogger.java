package logger;

import java.util.Set;

import message.Message;
import message.MessageType;

public abstract class GeneralLogger {
	private Set<MessageType> messageTypes;
	public GeneralLogger(MessageType... messageTypes) {
		this.messageTypes = Set.of(messageTypes);
	}
	public abstract void log(Message message);
	public boolean isContained(MessageType messageType) {
		return messageTypes.contains(messageType); 
	}
	public Set<MessageType> getMessageTypes() {
		return messageTypes;
	}
	public void setMessageType(Set<MessageType> messageTypes) {
		this.messageTypes = messageTypes;
	}
}
