package de.egatlov.trustbot_api.rest.v3.models;

public class ChannelChange {

	private final Channel channel;

	public ChannelChange(Channel channel) {
		this.channel = channel;
	}

	public Channel channel() {
		return channel;
	}

}
