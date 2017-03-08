package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Follows {

	/**
	 * _links
	 */
	private final Links links;
	/**
	 * _total
	 */
	private final Integer total;
	private final List<Follow> follows;

	public Follows(Links links, Integer total, List<Follow> follows) {
		this.links = links;
		this.total = total;
		this.follows = follows;
	}

	public Links links() {
		return links;
	}

	public Integer total() {
		return total;
	}

	public List<Follow> follows() {
		return follows;
	}

}
