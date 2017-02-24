package de.egatlov.trustbot_api.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * SimpleConnection.java describes an simple connection with an implementation
 * of the methods which are most likely always implemented like simple
 * connection has implemented them.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public abstract class SimpleConnection implements Connection {

	protected final int port;
	protected final String host;
	protected final Queue<ChatCommand> sendCommands;
	protected final ExecutorService executor;
	protected BufferedWriter writer;
	protected BufferedReader reader;
	protected boolean started;

	public SimpleConnection(String host, int port) {
		this.host = host;
		this.port = port;
		this.sendCommands = new LinkedList<>();
		this.executor = Executors.newFixedThreadPool(1);
	}

	@Override
	public void start(String oauthKey, String name) throws Exception {

		@SuppressWarnings("resource")
		Socket socket = new Socket(host, port);
		this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.writer.write("PASS " + oauthKey + "\r\n");
		this.writer.write("NICK " + name + "\r\n");
		this.writer.write("USER " + "something need to be here" + " \r\n"); // TODO
		this.writer.flush();

		// start listening to chat
		this.started = true;
		FutureTask<Void> connectionTask = new FutureTask<Void>(this);
		executor.execute(connectionTask);

	}

	@Override
	public void stop() {
		this.started = false;
		executor.shutdown();
		// TODO disconnect from channel and chat
	}

	/**
	 * <b>!ATTENTION!</b><br/>
	 * Should never be called!<br/>
	 * Call {@code start()} instead!
	 * 
	 * @throws Exception
	 */
	@Override
	public Void call() throws Exception {
		while (started) {
			listenToChat();
		}
		return null;
	}

	/**
	 * This method should:</br>
	 * 1. handle ping and pong</br>
	 * 2. handle "!"-commands and build chatcommands in queue</br>
	 */
	protected abstract void listenToChat();

	@Override
	public abstract void write(String message);

	@Override
	public abstract Queue<ChatCommand> commands();
}
