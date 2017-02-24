package de.egatlov.trustbot_api.bot;

import de.egatlov.trustbot_api.bot.config.BotConfig;
import de.egatlov.trustbot_api.connection.IRCConnection;

/**
 * TrustBot.java is an implementation of an Bot which simply shows how to do it
 * right.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class TrustBot implements Bot {

	private final BotConfig config;
	private final IRCConnection connection;

	public TrustBot(BotConfig config, IRCConnection connection) {
		this.config = config;
		this.connection = connection;
	}

	@Override
	public void connect() throws Exception {
		this.connection.start(config.oauthKey(), config.name());
	}

	@Override
	public void disconnect() {
		// TODO
		this.connection.stop();
	}

	@Override
	public void write(String message) {
		// TODO
	}

	@Override
	public void listen() {
		// TODO listen to each command in connection stack work with it and pop
		// it
	}

}
