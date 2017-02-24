package de.egatlov.trustbot_api.connection;

import java.util.Queue;

/**
 * IRCConnection.java is an implementation of SimpleConnection. It handles all
 * that akward Buffer stuff, which is mostly uninteresting.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class IRCConnection extends SimpleConnection {

	public IRCConnection(String host, int port) {
		super(host, port);
	}

	/**
	 * @param message
	 *            - String message the message to write
	 */
	@Override
	public void write(String message) {
		// TODO write something in chat
	}

	@Override
	public Queue<ChatCommand> commands() {
		return sendCommands;
	}

	/**
	 * Handle Ping and Pong and build {@code ChatCommands} out of "!"-commands
	 * to store them in {@code sendCommands}-Queue
	 */
	protected void listenToChat() {
		// TODO read line from chat and:
		// - handle ping and pong
		// - handle "!command"-commands and build chatcommands in queue
	}

}
