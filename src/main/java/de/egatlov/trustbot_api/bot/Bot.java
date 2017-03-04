package de.egatlov.trustbot_api.bot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import de.egatlov.trustbot_api.constants.EndOfLine;

/**
 * Bot.java is an interface, which describes each Bot implemented in this
 * project.
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public interface Bot extends Runnable {

	void stop();

	class Simple implements Bot {

		private boolean running;
		private final EndOfLine lineEnd;
		private final BufferedReader reader;
		private final BufferedWriter writer;

		public Simple(BufferedReader reader, BufferedWriter writer) {
			this.reader = reader;
			this.writer = writer;
			this.lineEnd = new EndOfLine();
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

		private void pingPong(String line) {
			if (line.toLowerCase().startsWith("ping")) {
				write("PONG " + line.substring(5) + lineEnd);
			}
		}

		private String nextLine() {
			String nextLine = null;
			try {
				nextLine = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return nextLine;
		}

		private void write(String text) {
			try {
				this.writer.write(text);
				this.writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
