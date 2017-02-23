package de.egatlov.trustbot_api.bot;

/**
 * Bot.java is an interface, which describes
 * each Bot implemented in this project.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public interface Bot {
	void connect() throws Exception;

	void disconnect();

	void write(String message);

	void listen();
}
