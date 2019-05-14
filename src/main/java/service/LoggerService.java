package service;
import java.util.logging.Logger;

import logger.LoggerConfig;
import message.Message;

public class LoggerService {
	private static final Logger logger = Logger.getLogger("JobService");
	private LoggerConfig loggerConfig;
	
	public LoggerService(LoggerConfig loggerConfig){
		this.loggerConfig = loggerConfig;
	}
	public void log(Message message) {
		try {
			loggerConfig.validateLogTypes();
			message.validate();
			loggerConfig.getLogTypes().stream().forEach(logger -> {
				if(logger.isContained(message.getMessageType())) logger.log(message);
			});	
		}catch(Exception e) {
			logger.severe(e.getMessage());
		}
	}
}
