package de.egatlov.trustbot_api.rest.v3.models;

import java.util.Date;

public class Reaction {

	private final String id;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * emote_id
	 */
	private final String emoteId;

	private final User user;

	public Reaction(String id, Date createdAt, String emoteId, User user) {
		this.id = id;
		this.createdAt = createdAt;
		this.emoteId = emoteId;
		this.user = user;
	}

	public String id() {
		return id;
	}

	public Date createdAt() {
		return createdAt;
	}

	public String emoteId() {
		return emoteId;
	}

	public User user() {
		return user;
	}

}
