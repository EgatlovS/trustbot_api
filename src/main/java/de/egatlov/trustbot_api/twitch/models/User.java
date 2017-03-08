package de.egatlov.trustbot_api.twitch.models;

import java.util.Date;

public class User {

	/**
	 * _links
	 */
	private final Links links;
	/**
	 * updated_at
	 */
	private final Date updatedAt;
	/**
	 * display_name
	 */
	private final String displayName;

	private final String type;

	private final String bio;

	private final String name;
	/**
	 * _id
	 */
	private final Long id;

	private final String logo;
	/**
	 * created_at
	 */
	private final Date createdAt;

	public User(Links links, Date updatedAt, String displayName, String type, String bio, String name, Long id,
			String logo, Date createdAt) {
		this.links = links;
		this.updatedAt = updatedAt;
		this.displayName = displayName;
		this.type = type;
		this.bio = bio;
		this.name = name;
		this.id = id;
		this.logo = logo;
		this.createdAt = createdAt;
	}

	public Links links() {
		return links;
	}

	public Date updatedAt() {
		return updatedAt;
	}

	public String displayName() {
		return displayName;
	}

	public String type() {
		return type;
	}

	public String bio() {
		return bio;
	}

	public String name() {
		return name;
	}

	public Long id() {
		return id;
	}

	public String logo() {
		return logo;
	}

	public Date createdAt() {
		return createdAt;
	}

}