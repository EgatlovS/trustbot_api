package de.egatlov.trustbot_api.connection;

import java.util.Stack;

/**
 * Connection.java describes an IRC connection and what methods it should
 * provide.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public interface Connection {
	void connect(String oauthKey, String name) throws Exception;

	void disconnect();

	void write(String message);

	void start();

	Stack<ChatCommand> commands();
}
