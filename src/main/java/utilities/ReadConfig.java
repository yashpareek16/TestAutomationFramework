package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

// -----------------create object of properties and store properties file path in a path variable----------------
	Properties properties;

	String path = System.getProperty("user.dir") + "\\configuration\\config.properties";

//-----------------initialize the properties object and load the config file----------------------------
	public ReadConfig() {

		properties = new Properties();
		FileInputStream fileInput;

		try {
			fileInput = new FileInputStream(path);
			properties.load(fileInput);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method will get url from the config file
	 * 
	 * @return url
	 */
	public String getURL() {

		String url = properties.getProperty("url");

		if (url == null) {
			throw new RuntimeException("url not specified in the config file.");
		} else {
			return url;
		}

	}

	/**
	 * This method will get browserName from the config file
	 * 
	 * @return browserName
	 */
	public String getBrowser() {

		String browserName = properties.getProperty("browserName");

		if (browserName == null) {
			throw new RuntimeException("browserName not specified in the config file.");
		} else {
			return browserName;
		}

	}

}
