package de.egatlov.trustbot_api.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import de.egatlov.trustbot_api.config.ConnectionConfiguration;
import de.egatlov.trustbot_api.constants.EndOfLine;
import de.egatlov.trustbot_api.execution.BotExecution;

/**
 * IRCConnection.java describes an IRC-Connection with an implementation of the
 * common method, which are described in Connection.java
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public class IRCConnection implements Connection {

	private final ConnectionConfiguration config;
	private final EndOfLine lineEnd;
	private final BotExecution botExecution;
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;

	public IRCConnection(ConnectionConfiguration config, BotExecution botExecution) {
		this.botExecution = botExecution;
		this.config = config;
		this.lineEnd = new EndOfLine();
	}

	@Override
	public void start() throws Exception {

		this.socket = new Socket(config.host(), config.port());
		this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.writer.write("PASS " + config.oauthKey() + lineEnd);
		this.writer.write("NICK " + config.name() + lineEnd);
		// For getting more precise information about commands which where send
		this.writer.write("CAP REQ :twitch.tv/commands " + lineEnd);
		// For getting all information about channel joins parts and modes
		// u can also receive the names of members in channel on join
		this.writer.write("CAP REQ :twitch.tv/membership " + lineEnd);
		this.writer.flush();

		this.join();

		botExecution.start(reader, writer);
	}

	@Override
	public void privmsg(String message) throws Exception {
		this.writer.write("PRIVMSG #" + config.channel() + ":" + message + " " + lineEnd);
		this.writer.flush();
	}

	@Override
	public void join() throws Exception {
		this.writer.write("JOIN #" + config.channel() + " " + lineEnd);
		this.writer.flush();
	}

	@Override
	public void part() throws Exception {
		this.writer.write("PART #" + config.channel() + " " + lineEnd);
		this.writer.flush();
	}

	@Override
	public void stop() throws Exception {
		this.botExecution.stop();
		this.part();
		this.socket.close();
	}

}
