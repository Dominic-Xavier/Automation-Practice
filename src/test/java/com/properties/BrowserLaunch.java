package com.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserLaunch {
	static FileInputStream fis;
	static Properties prop;
	
	public static Properties readPropertiesFile(String FileName) throws IOException {
		fis = new FileInputStream("./src/test/java/com/properties/"+FileName+".properties");
		prop = new Properties();
		prop.load(fis);
		return prop;
	}
}
