package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.PropertiesValue;

public class DBConfig {
	private static Connection connection = null;
	public static Connection getConnection() {
		try {
			if (connection == null) {
				Class.forName(PropertiesValue.DB_DRIVER_CLASS_NAME);
				connection = DriverManager.getConnection(PropertiesValue.DB_URL, PropertiesValue.DB_USERNAME,
						PropertiesValue.DB_PASSWORD);
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("CREATE TABLE Log_Values(id int primary key, text varchar(255), type varchar(50))");
				stmt.close();
			}
		} catch (ClassNotFoundException | SQLException ex) {
			throw new LoggerException("Problems in database connection");
		}
		return connection;
	}
}
