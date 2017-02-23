package de.egatlov.trustbot_api.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Stack;

/**
 * IRCConnection.java is an implementation of Connection. It handles all that
 * akward Buffer stuff, which is mostly uninteresting.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class IRCConnection implements Connection {

	private final int port;
	private final String host;
	private BufferedWriter writer;
	private BufferedReader reader;
	private final Stack<ChatCommand> sendCommands;

	public IRCConnection(String host, int port) {
		this.host = host;
		this.port = port;
		this.sendCommands = new Stack<>();
	}

	@Override
	public void connect(String oauthKey, String name) throws Exception {

		@SuppressWarnings("resource")
		Socket socket = new Socket(host, port);
		this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.writer.write("PASS " + oauthKey + "\r\n");
		this.writer.write("NICK " + name + "\r\n");
		this.writer.write("USER " + "something need to be here" + " \r\n"); // TODO
		this.writer.flush();

	}

	@Override
	public void disconnect() {
		// TODO disconnect from channel and chat

	}

	@Override
	public void write(String message) {
		// TODO write something in chat
	}

	@Override
	public Stack<ChatCommand> commands() {
		return sendCommands;
	}

	@Override
	public void start() {
		// TODO start listening to chat and bild commands in stack
	}

}
