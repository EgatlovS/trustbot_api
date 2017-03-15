package de.egatlov.trustbot_api.rest.v5.models.users;

import java.util.Date;

public class User {

	/**
	 * _id
	 */
	private final Long id;
	private final String bio;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * display_name
	 */
	private final String displayName;
	private final String email;
	/**
	 * email_verified
	 */
	private final Boolean emailVerified;
	private final String logo;
	private final String name;
	private final Notifications notifications;
	private final Boolean partnered;
	/**
	 * twitter_connected
	 */
	private final Boolean twitterConnected;
	private final String type;
	/**
	 * updated_at
	 */
	private final Date updatedAt;

	public User(Long id, String bio, Date createdAt, String displayName, String email, Boolean emailVerified,
			String logo, String name, Notifications notifications, Boolean partnered, Boolean twitterConnected,
			String type, Date updatedAt) {
		this.id = id;
		this.bio = bio;
		this.createdAt = createdAt;
		this.displayName = displayName;
		this.email = email;
		this.emailVerified = emailVerified;
		this.logo = logo;
		this.name = name;
		this.notifications = notifications;
		this.partnered = partnered;
		this.twitterConnected = twitterConnected;
		this.type = type;
		this.updatedAt = updatedAt;
	}

	public Long id() {
		return id;
	}

	public String bio() {
		return bio;
	}

	public Date createdAt() {
		return createdAt;
	}

	public String displayName() {
		return displayName;
	}

	public String email() {
		return email;
	}

	public Boolean emailVerified() {
		return emailVerified;
	}

	public String logo() {
		return logo;
	}

	public String name() {
		return name;
	}

	public Notifications notifications() {
		return notifications;
	}

	public Boolean partnered() {
		return partnered;
	}

	public Boolean twitterConnected() {
		return twitterConnected;
	}

	public String type() {
		return type;
	}

	public Date updatedAt() {
		return updatedAt;
	}

}
