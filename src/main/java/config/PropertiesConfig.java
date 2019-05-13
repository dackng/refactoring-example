package config;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesConfig {
	private static ResourceBundle resourceBundle = null;
	static{
		try {
			if (resourceBundle == null)
				resourceBundle = ResourceBundle.getBundle("application", Locale.getDefault());
		} catch (Exception ex) {
			throw new LoggerException("Problems in properties reading");
		}
	}
	public static String getString(String key) {  
        return resourceBundle.getString(key);  
    } 
}
