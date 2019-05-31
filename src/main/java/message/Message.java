package message;

import config.LoggerException;

public class Message {
	private String text;
	private MessageType messageType;
	public Message(String text, MessageType messageType) {
		this.text = text;
		this.messageType = messageType;
	}
	public void validate() {
		validateText();
		validateType();
	}
	private void validateText() {
		if (text == null) throw new LoggerException("Message text must be specified");
		text.trim();
		if (text.isEmpty()) throw new LoggerException("Message text must not contain whitespace");
	}
	private void validateType() {
		if (messageType == null) throw new LoggerException("Message type must be specified");
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
}
