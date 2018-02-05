package edu.agh.ics.lab6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.io.InputStream;

public class PropTest {
	public static void main(String[] args) throws IOException {
		PropTest propTest = new PropTest();
		propTest.loadConfig();
	}

	/**
	 * Default name of config file
	 */
	public static String CONFIG = "sample.properties";
	public static String HOSTNAME = "hostname";
	public static String PORT = "port";

	private final Map<String, String> map = new HashMap<String, String>();

	/**
	 * Loads configuration from a file
	 * @throws IOException
	 */
	public void loadConfig() throws IOException {
	Properties prop = new Properties();
	try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(CONFIG)) {
		if (inputStream != null) {
			prop.load(inputStream);
			for (Entry<Object, Object> entry : prop.entrySet()) {
				map.put("" + entry.getKey(), "" + entry.getValue());
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		} else {
			throw new FileNotFoundException("property file '" + CONFIG + "' not found in the file");
		}
	}
}}
