package log;
import java.util.HashSet;
import java.util.Set;

import config.LoggerException;
import message.MessageType;

public class JobLogger {
	private Set<Log> logTypes;
	public JobLogger() {
		logTypes = new HashSet<>();
	}
	public void validateLogTypes() {
		if (logTypes.isEmpty()) throw new LoggerException("Invalid configuration");
	}
	public void addLogType(Log log) {
		log.getMessageTypes().forEach(item -> item.validateConsistency());
		logTypes.add(log);
	}
	public void validateSpecificMessageType(MessageType messageType) {		
		logTypes.forEach(log -> {
			log.getMessageTypes().stream()
				.filter(type -> type.getLevel().equals(messageType.getLevel())).findFirst()
				.orElseThrow(()-> new LoggerException(messageType.getLevel() 
						+ " is not supported for this logger type"));
		});	
	}
	
	public Set<Log> getLogTypes() {
		return logTypes;
	}
	public void setLogTypes(Set<Log> logTypes) {
		this.logTypes = logTypes;
	}
}