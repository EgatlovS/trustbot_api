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

	void ouputTo(BufferedWriter writer);

	void inputFrom(BufferedReader reader);

	void stop();

	class Simple implements Bot {

		private boolean running;
		private BufferedReader reader;
		private BufferedWriter writer;
		private final EndOfLine lineEnd;

		public Simple() {
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

		@Override
		public void ouputTo(BufferedWriter writer) {
			this.writer = writer;
		}

		@Override
		public void inputFrom(BufferedReader reader) {
			this.reader = reader;
		}

	}

}
