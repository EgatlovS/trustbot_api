package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Games {

	/**
	 * _links
	 */
	private final Links links;
	/**
	 * _total
	 */
	private final Integer total;
	/**
	 * top
	 */
	private final List<Top> tops;

	public Games(Links links, Integer total, List<Top> tops) {
		this.links = links;
		this.total = total;
		this.tops = tops;
	}

	public Links links() {
		return links;
	}

	public Integer total() {
		return total;
	}

	public List<Top> tops() {
		return tops;
	}
}