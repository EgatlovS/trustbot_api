package de.egatlov.trustbot_api.rest.v5.models.channels;

import java.util.List;

public class Channels {

	/**
	 * _total
	 */
	private final Long total;
	private final List<Channel> channels;
	
	public Channels(Long total, List<Channel> channels) {
		this.total = total;
		this.channels = channels;
	}

	public Long total() {
		return total;
	}

	public List<Channel> channels() {
		return channels;
	}
	
}
