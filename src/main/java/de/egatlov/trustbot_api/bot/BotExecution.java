package de.egatlov.trustbot_api.bot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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

	class SimpleBot implements Bot {

		private boolean running;
		private final BufferedReader reader;
		private final BufferedWriter writer;

		public SimpleBot(BufferedReader reader, BufferedWriter writer) {
			this.reader = reader;
			this.writer = writer;
		}

		@Override
		public void run() {
			this.running = true;
			while (running) {
				String nextLine = nextLine();
				if (nextLine != null) {
					pingPong(nextLine);
				}
			}
		}

		@Override
		public void stop() {
			this.running = false;
		}

		private String nextLine() {
			String nextLine = null;
			try {
				nextLine = reader.readLine();
			} catch (IOException e) {
				// should never throw an exception
			}
			return nextLine;
		}

		private void pingPong(String line) {
			// TODO handle ping and pong
		}

	}

}
