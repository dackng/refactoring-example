package log;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import config.LoggerException;
import message.Message;
import message.MessageType;

public class FileLog extends Log{
	private static final Logger logger = Logger.getLogger("FileLog");
	private String path;
	public FileLog(String fileDirectory, String fileName, MessageType... messageTypes) {
		super(messageTypes);
		this.path = fileDirectory + fileName;
		createFile();
	}
	@Override
	public void log(Message message) {
		FileHandler fh;
		try {
			fh = new FileHandler(path);
			logger.addHandler(fh);
			logger.log(message.getMessageType().getLevel(), message.getText());
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoggerException("There was a problem logging a message in file");
		}
	}
	private void createFile() {
		File logFile;
		try {
			logFile = new File(path);
			if (!logFile.exists())
			logFile.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoggerException("There was a problem creating file");
		}
	}
}
