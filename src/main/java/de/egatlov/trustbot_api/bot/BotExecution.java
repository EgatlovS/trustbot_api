package de.egatlov.trustbot_api.bot;

import java.io.Reader;
import java.io.Writer;

/**
 * BotExecution.java is a Wrapper for bots to execute them.
 * 
 * Created at: 25.02.2017
 * 
 * @author egatlov
 */
public interface BotExecution {

	void start(Reader reader, Writer writer);

	void stop();

	class SimpleBot implements Bot {

		private boolean running;
		private final Reader reader;
		private final Writer writer;

		public SimpleBot(Reader reader, Writer writer) {
			this.reader = reader;
			this.writer = writer;
		}

		@Override
		public void run() {
			this.running = true;
			while (running) {
				// 1. handle ping and pong
				// 2. handle "!"-commands and build chatcommands in queue
			}
		}

		@Override
		public void stop() {
			this.running = false;
		}

	}

}
