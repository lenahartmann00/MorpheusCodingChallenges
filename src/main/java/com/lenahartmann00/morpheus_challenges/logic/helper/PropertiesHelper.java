package com.lenahartmann00.morpheus_challenges.logic.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesHelper {

	private static final Logger LOGGER = Logger.getLogger(PropertiesHelper.class.getName());
	private static final String APPLICATION_PROPERTIES = "application.properties";

	private static PropertiesHelper propertiesHelper;

	private Properties properties;

	private PropertiesHelper() {
		this.properties = new Properties();
		loadApplicationProperties();
	}

	public static PropertiesHelper getInstance() {
		if (propertiesHelper == null) {
			propertiesHelper = new PropertiesHelper();
		}
		return propertiesHelper;
	}

	public Properties getProperties() {
		return properties;
	}

	private void loadApplicationProperties(){
		final URL resource = Thread.currentThread().getContextClassLoader()
			.getResource(APPLICATION_PROPERTIES);

		if (resource != null) {
			final String applicationPath = resource.getPath();
			try {
				properties.load(new FileInputStream(applicationPath));
			} catch (FileNotFoundException e) {
				LOGGER.log(Level.WARNING, "{0} file could not be found. Properties not loaded.",
					APPLICATION_PROPERTIES);
			} catch (IOException e) {
				LOGGER.log(Level.WARNING,
					"Could not read input stream from properties file. Properties not loaded.", e);

			}
		} else {
			LOGGER.log(Level.WARNING, "{0} file could not be found. Properties not loaded.",
				APPLICATION_PROPERTIES);
		}
	}
}
