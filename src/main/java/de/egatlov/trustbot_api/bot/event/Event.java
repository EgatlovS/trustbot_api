package de.egatlov.trustbot_api.bot.event;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public interface Event {

	void handle(String text, BufferedReader reader, BufferedWriter writer);
	boolean matches(String text);

}
