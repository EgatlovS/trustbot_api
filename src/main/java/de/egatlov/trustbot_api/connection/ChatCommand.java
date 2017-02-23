package de.egatlov.trustbot_api.connection;

/**
 * ChatCommand.java
 * 
 * Created at: 23.02.2017
 * 
 * @author egatlov
 */
public final class ChatCommand {

	private final String sendCommand;
	private final String sender;

	public ChatCommand(String sendCommand, String sender) {
		this.sendCommand = sendCommand;
		this.sender = sender;
	}

	public String command() {
		return sendCommand;
	}

	public String sender() {
		return sender;
	}

	public boolean equals(ChatCommand command) {
		return this.sendCommand.equals(command.command()) && this.sender.equals(command.sender());
	}

}
