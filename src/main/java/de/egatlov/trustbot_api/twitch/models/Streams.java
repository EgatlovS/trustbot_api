package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Streams {

	private final Long total;
	private final List<Stream> streams;
	/**
	 * _links
	 */
	private final Links links;

	public Streams(Long total, List<Stream> streams, Links links) {
		this.total = total;
		this.streams = streams;
		this.links = links;
	}

	public Long total() {
		return total;
	}

	public List<Stream> streams() {
		return streams;
	}

	public Links links() {
		return links;
	}

}
