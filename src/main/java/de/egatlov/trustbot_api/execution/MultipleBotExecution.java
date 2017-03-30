package de.egatlov.trustbot_api.execution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.egatlov.trustbot_api.bot.Bot;

public final class MultipleBotExecution implements BotExecution {

	private final Set<Bot> bots;
	private final ExecutorService executor;

	public MultipleBotExecution(Bot... bots) {
		this(new HashSet<Bot>(Arrays.asList(bots)));
	}

	public MultipleBotExecution(Set<Bot> bots) {
		this.executor = Executors.newFixedThreadPool(1);
		this.bots = bots;
	}

	@Override
	public void start(BufferedReader reader, BufferedWriter writer) {
		for (Bot bot : bots) {
			bot.inputFrom(reader);
			bot.ouputTo(writer);
			executor.execute(bot);
		}
	}

	@Override
	public void stop() {
		for (Bot bot : bots) {
			bot.stop();
		}
		this.executor.shutdown();
	}

}
