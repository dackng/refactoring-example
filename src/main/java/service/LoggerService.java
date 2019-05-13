package service;
import java.util.logging.Logger;

import log.JobLogger;
import message.Message;

public class LoggerService {
	private static final Logger logger = Logger.getLogger("JobService");
	private JobLogger jobLogger;
	
	public LoggerService(JobLogger jobLogger) {
		this.jobLogger = jobLogger;
	}
	public void log(Message message) {
		try {
			jobLogger.validateLogTypes();
			message.validate();
			jobLogger.validateSpecificMessageType(message.getMessageType());
			jobLogger.getLogTypes().stream().forEach(item -> item.log(message));	
		}catch(Exception e) {
			logger.severe(e.getMessage());
		}
	}
}
