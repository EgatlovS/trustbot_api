package de.egatlov.trustbot_api.bot.event;

public abstract class PartEvent implements Event {

	private final String regex = "(>.+tmi.twitch.tv PART.)";

	@Override
	public boolean matches(String text) {
		return text.matches(regex);
	}

}
