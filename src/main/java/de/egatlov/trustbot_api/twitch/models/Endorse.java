package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Endorse {

	private final Integer count;
	/**
	 * user_ids
	 */
	private final List<Integer> userIds;

	public Endorse(Integer count, List<Integer> userIds) {
		this.count = count;
		this.userIds = userIds;
	}

	public Integer count() {
		return count;
	}

	public List<Integer> userIds() {
		return userIds;
	}

}
