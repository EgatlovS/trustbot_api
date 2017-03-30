package de.egatlov.trustbot_api.execution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.egatlov.trustbot_api.bot.Bot;

/**
 * BotExecution.java is a Wrapper for bots to execute them.
 * 
 * Created at: 25.02.2017
 * 
 * @author egatlov
 */
public interface BotExecution {

	void start(BufferedReader reader, BufferedWriter writer);

	void stop();

	class Simple implements BotExecution {

		private Bot bot;
		private final ExecutorService executor;

		public Simple(Bot bot) {
			this.executor = Executors.newFixedThreadPool(1);
			this.bot = bot;
		}

		public Simple() {
			this(null);
		}

		@Override
		public void start(BufferedReader reader, BufferedWriter writer) {
			if (bot == null) {
				this.bot.inputFrom(reader);
				this.bot.ouputTo(writer);
				this.bot = new Bot.Simple();
			}
			executor.execute(bot);
		}

		@Override
		public void stop() {
			this.bot.stop();
			this.executor.shutdown();
		}

	}

}
