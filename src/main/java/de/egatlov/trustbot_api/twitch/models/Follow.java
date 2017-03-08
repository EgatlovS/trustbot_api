package de.egatlov.trustbot_api.twitch.models;

import java.util.Date;

public class Follow {

	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * _links
	 */
	private final Links links;
	private final Boolean notifications;
	private final Channel channel;

	public Follow(Date createdAt, Links links, boolean notifications, Channel channel) {
		this.createdAt = createdAt;
		this.links = links;
		this.notifications = notifications;
		this.channel = channel;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Links links() {
		return links;
	}

	public boolean notifications() {
		return notifications;
	}

	public Channel channel() {
		return channel;
	}

}
