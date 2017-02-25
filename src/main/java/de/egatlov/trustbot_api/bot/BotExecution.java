package de.egatlov.trustbot_api.bot;

import java.io.Reader;

/**
 * BotExecution.java is a Wrapper for bots to execute them.
 * 
 * Created at: 25.02.2017
 * @author egatlov
 */
public interface BotExecution {

	void start(Reader reader);

	void stop();

	class SimpleBot implements Bot {

		private boolean running;
		private final Reader reader;

		public SimpleBot(Reader reader) {
			this.reader = reader;
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
