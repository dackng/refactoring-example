package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.PropertiesValue;

public class DBConfig {
	private static Connection connection = null;
	public static Connection getConnection() {
		try {
			if (connection == null) {
				Class.forName(PropertiesValue.DB_DRIVER_CLASS_NAME);
				connection = DriverManager.getConnection(PropertiesValue.DB_URL, PropertiesValue.DB_USERNAME,
						PropertiesValue.DB_PASSWORD);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			throw new LoggerException("Problems in database connection");
		}
		return connection;
	}
}
