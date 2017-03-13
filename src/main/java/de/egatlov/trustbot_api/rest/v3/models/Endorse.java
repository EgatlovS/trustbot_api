package de.egatlov.trustbot_api.rest.v3.models;

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
