package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/**
	 * This method is used to load properties from config.properties file
	 */
	public Properties init_prop(){
		prop=new Properties();
		try {
			FileInputStream fp=new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
