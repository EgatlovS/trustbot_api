package de.egatlov.trustbot_api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertyConfig.java is an implementation of ConnectionConfiguration.java,
 * which reads the given values (oauthKey, name, etc.) from an PropertyFile, at
 * the point it is asked to return them.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class PropertyConfig implements ConnectionConfiguration {

	private final String url;
	private final Properties properties;

	public PropertyConfig(String url) {
		this.url = url;
		this.properties = properties();
	}

	@Override
	public String oauthKey() {
		return read("oauthKey");
	}

	@Override
	public String name() {
		return read("name");
	}

	@Override
	public String host() {
		return read("host");
	}

	@Override
	public int port() {
		return Integer.valueOf(read("port"));
	}

	@Override
	public String channel() {
		return read("channel");
	}

	private String read(String key) {
		return properties.getProperty(key);
	}
	
	private Properties properties() {
		InputStream propertyFile = PropertyConfig.class.getClassLoader().getResourceAsStream(url);
		Properties properties = new Properties();
		try {
			properties.load(propertyFile);
		} catch (IOException e) {
			// TODO
		}
		return properties;
	}

}
