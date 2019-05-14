package logger;
import java.util.HashSet;
import java.util.Set;

import config.LoggerException;

public class LoggerConfig {
	private Set<GeneralLogger> logTypes;
	public LoggerConfig() {
		logTypes = new HashSet<>();
	}
	public void validateLogTypes() {
		if (logTypes.isEmpty()) throw new LoggerException("Invalid configuration");
	}
	public void addLogType(GeneralLogger log) {
		log.getMessageTypes().forEach(item -> item.validateConsistency());
		logTypes.add(log);
	}
	public Set<GeneralLogger> getLogTypes() {
		return logTypes;
	}
	public void setLogTypes(Set<GeneralLogger> logTypes) {
		this.logTypes = logTypes;
	}
}