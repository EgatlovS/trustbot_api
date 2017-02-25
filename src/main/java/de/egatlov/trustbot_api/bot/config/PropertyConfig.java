package de.egatlov.trustbot_api.bot.config;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PropertyConfig.java is an implementation of ConnectionConfiguration.java, which reads the
 * given values (oauthKey, name, etc.) from an PropertyFile, at the point it is
 * asked to return them.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class PropertyConfig implements ConnectionConfiguration {

	private final Path path;

	public PropertyConfig(Path path) {
		this.path = path;
	}

	public PropertyConfig(String url) {
		this(Paths.get(url));
	}

	@Override
	public String oauthKey() {
		return null; // TODO read from propertyfile
	}

	@Override
	public String name() {
		return null; // TODO read from propertyfile
	}

	@Override
	public String host() {
		return null; // TODO read from propertyfile
	}

	@Override
	public int port() {
		return 0; // TODO read from propertyfile
	}

	@Override
	public String channel() {
		return null; // TODO read from propertyfile
	}

}
