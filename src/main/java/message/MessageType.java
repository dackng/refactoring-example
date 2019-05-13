package message;

import java.util.logging.Level;

import config.LoggerException;

public class MessageType {
	private Level level;
	public void validateConsistency() {
		if (!(level.equals(Level.INFO) || level.equals(Level.WARNING) || level.equals(Level.SEVERE)))
			throw new LoggerException("Must specify the log type like INFO, WARNING or SEVERE");
	}
	public MessageType(Level level) {
		this.level = level;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
}
