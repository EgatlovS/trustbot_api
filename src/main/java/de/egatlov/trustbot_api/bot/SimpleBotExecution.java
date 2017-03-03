package de.egatlov.trustbot_api.bot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleBotExecution.java is the simplest BotExecution.java implementation, i
 * could imagine.
 * 
 * Created at: 25.02.2017
 * 
 * @author egatlov
 */
public final class SimpleBotExecution implements BotExecution {

	private Bot bot;
	private final ExecutorService executor;

	public SimpleBotExecution(Bot bot) {
		this.executor = Executors.newFixedThreadPool(1);
		this.bot = bot;
	}

	public SimpleBotExecution() {
		this(null);
	}

	@Override
	public void start(BufferedReader reader, BufferedWriter writer) {
		if (bot == null) {
			this.bot = new BotExecution.SimpleBot(reader, writer);
		}
		executor.execute(bot);
	}

	@Override
	public void stop() {
		this.bot.stop();
		this.executor.shutdown();
	}

}
