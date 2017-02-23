package de.egatlov.trustbot_api.bot.config;

/**
 * SimpleConfig.java is an implementation of BotConfig.java, which just holds
 * the values oauthKey and name.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class SimpleConfig implements BotConfig {

	private final String name;
	private final String oauthKey;

	public SimpleConfig(String oauthKey, String name) {
		this.name = name;
		this.oauthKey = oauthKey;
	}

	@Override
	public String oauthKey() {
		return oauthKey;
	}

	@Override
	public String name() {
		return name;
	}

}
