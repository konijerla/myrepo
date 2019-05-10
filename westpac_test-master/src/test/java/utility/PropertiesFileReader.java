package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	private static Properties properties = null;

	public static String getProperty(String key) throws IOException {

		if (null == properties) {
			properties = new Properties();
			try {
				properties.load(new FileInputStream("./resources/browser-config.properties"));
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}

		return properties.getProperty(key);
	}

}