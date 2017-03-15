package de.egatlov.trustbot_api.rest.v5.models.streams;

import java.util.List;

public class Streams {

	/**
	 * _total
	 */
	private final Long total;
	private final List<Stream> streams;

	public Streams(Long total, List<Stream> streams) {
		this.total = total;
		this.streams = streams;
	}

	public Long total() {
		return total;
	}

	public List<Stream> streams() {
		return streams;
	}

}
