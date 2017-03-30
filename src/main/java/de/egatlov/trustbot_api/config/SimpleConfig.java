package de.egatlov.trustbot_api.config;

/**
 * SimpleConfig.java is an implementation of ConnectionConfiguration.java, which just holds
 * the values oauthKey, name, channel, host and port.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class SimpleConfig implements ConnectionConfiguration {

	private final String name;
	private final String oauthKey;
	private final String channel;
	private final String host;
	private final int port;

	public SimpleConfig(String oauthKey, String name, int port, String channel) {
		this(oauthKey, name, "irc.chat.twitch.tv", port, channel);
	}

	public SimpleConfig(String oauthKey, String name, String host, String channel) {
		this(oauthKey, name, host, 6667, channel);
	}

	public SimpleConfig(String oauthKey, String name, String channel) {
		this(oauthKey, name, 6667, channel);
	}

	public SimpleConfig(String oauthKey, String name, String host, int port, String channel) {
		this.name = name;
		this.oauthKey = oauthKey;
		this.host = host;
		this.port = port;
		this.channel = channel;
	}

	@Override
	public String oauthKey() {
		return oauthKey;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String host() {
		return host;
	}

	@Override
	public int port() {
		return port;
	}

	@Override
	public String channel() {
		return channel;
	}

}
