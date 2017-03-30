package de.egatlov.trustbot_api.bot.event;

public abstract class JoinEvent implements Event {

	private final String regex = "(>.+tmi.twitch.tv JOIN.)";

	@Override
	public boolean matches(String text) {
		return text.matches(regex);
	}

}
