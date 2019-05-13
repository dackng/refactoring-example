package util;

import config.PropertiesConfig;

public class PropertiesValue {
	//params for database connection
	public static final String DB_DRIVER_CLASS_NAME = PropertiesConfig.getString("db.driverClassName");
	public static final String DB_URL = PropertiesConfig.getString("db.url");
	public static final String DB_USERNAME = PropertiesConfig.getString("db.username");
	public static final String DB_PASSWORD = PropertiesConfig.getString("db.password");
	
	//#file directory
	public static final String FILE_DIRECTORY = PropertiesConfig.getString("file.directory");
	public static final String FILE_NAME = PropertiesConfig.getString("file.name");
}
