package de.egatlov.trustbot_api.connection;

/**
 * Connection.java describes an connection and what methods it should provide.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public interface Connection {

	void start() throws Exception;

	void stop() throws Exception;

	void join() throws Exception;

	void part() throws Exception;

	void privmsg(String message) throws Exception;

}
