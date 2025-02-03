package utilities.utilitiesPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWriteProperties {

	Properties prop = new Properties();
	String fileName = "config.properties";

	public void writeProperties() {

		prop.setProperty("Name", "Yash Pareek");
		prop.setProperty("Location", "Ahmedabad");
		prop.setProperty("Designation", "Automation Developer");

		FileOutputStream output = null;

		try {
			output = new FileOutputStream(fileName);
			prop.store(output, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void readProperties(String filePath) {

		FileInputStream input = null;
		try {
			input = new FileInputStream(filePath);
			prop.load(input);
			System.out.println(prop.getProperty("Name"));
			System.out.println(prop.getProperty("Location"));
			System.out.println(prop.getProperty("Designation"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		ReadWriteProperties read = new ReadWriteProperties();
		read.writeProperties();
		read.readProperties(read.fileName);
	}

}
