package de.egatlov.trustbot_api.twitch.models;

import java.util.Date;

public class Block {

	/**
	 * _id
	 */
	private final Long id;
	/**
	 * updated_at
	 */
	private final Date updatedAt;
	/**
	 * _links
	 */
	private final Links links;
	private final User user;

	public Block(Long id, Date updatedAt, Links links, User user) {
		this.id = id;
		this.updatedAt = updatedAt;
		this.links = links;
		this.user = user;
	}

	public Long id() {
		return id;
	}

	public Date updatedAt() {
		return updatedAt;
	}

	public Links links() {
		return links;
	}

	public User user() {
		return user;
	}

}
