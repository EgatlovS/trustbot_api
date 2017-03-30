package de.egatlov.trustbot_api.bot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import de.egatlov.trustbot_api.bot.event.Event;

public class EventBot implements Bot {

	private final Set<Event> events;
	private boolean running;
	private BufferedReader reader;
	private BufferedWriter writer;

	public EventBot(Event... events) {
		this(new HashSet<Event>(Arrays.asList(events)));
	}

	public EventBot(Set<Event> events) {
		this.events = events;
	}

	@Override
	public void run() {
		this.running = true;
		while (running) {
			String nextLine = nextLine();
			if (nextLine != null) {
				for (Event event : events) {
					if (event.matches(nextLine)) {
						event.handle(nextLine, reader, writer);
					}
				}
			}
		}
	}

	@Override
	public void stop() {
		this.running = false;
	}

	@Override
	public void ouputTo(BufferedWriter writer) {
		this.writer = writer;
	}

	@Override
	public void inputFrom(BufferedReader reader) {
		this.reader = reader;
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

}
