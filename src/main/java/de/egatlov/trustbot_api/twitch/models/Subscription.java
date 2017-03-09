package de.egatlov.trustbot_api.twitch.models;

import java.util.Date;

public class Subscription {

	/**
	 * _id
	 */
	private final String id;
	private final User user;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * _links
	 */
	private final Links links;

	public Subscription(String id, User user, Date createdAt, Links links) {
		this.id = id;
		this.user = user;
		this.createdAt = createdAt;
		this.links = links;
	}

	public String id() {
		return id;
	}

	public User user() {
		return user;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Links links() {
		return links;
	}

}
