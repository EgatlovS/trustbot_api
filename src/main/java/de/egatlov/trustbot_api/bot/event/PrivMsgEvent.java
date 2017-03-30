package de.egatlov.trustbot_api.bot.event;

public abstract class PrivMsgEvent implements Event {

	private final String regex = "(>.+tmi.twitch.tv PRIVMSG.)";

	@Override
	public boolean matches(String text) {
		return text.matches(regex);
	}
	
}
