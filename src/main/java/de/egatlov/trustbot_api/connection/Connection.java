package de.egatlov.trustbot_api.connection;

import java.util.Queue;
import java.util.concurrent.Callable;

/**
 * Connection.java describes an connection and what methods it should
 * provide.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public interface Connection extends Callable<Void> {

	void start(String oauthKey, String name) throws Exception;

	void stop();

	void write(String message);

	Queue<ChatCommand> commands();

}
