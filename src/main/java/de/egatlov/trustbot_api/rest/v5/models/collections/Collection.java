package de.egatlov.trustbot_api.rest.v5.models.collections;

import java.util.Date;

import de.egatlov.trustbot_api.rest.v5.models.users.User;
import de.egatlov.trustbot_api.rest.v5.models.viewables.Thumbnails;

public class Collection {

	/**
	 * _id
	 */
	private final String id;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * items_count
	 */
	private final Long itemsCount;
	private final User owner;
	private final Thumbnails thumbnails;
	private final String title;
	/**
	 * total_duration
	 */
	private final Long totalDuration;
	/**
	 * updated_at
	 */
	private final Date updatedAt;
	private final Long views;
	
	public Collection(String id, Date createdAt, Long itemsCount, User owner, Thumbnails thumbnails, String title,
			Long totalDuration, Date updatedAt, Long views) {
		this.id = id;
		this.createdAt = createdAt;
		this.itemsCount = itemsCount;
		this.owner = owner;
		this.thumbnails = thumbnails;
		this.title = title;
		this.totalDuration = totalDuration;
		this.updatedAt = updatedAt;
		this.views = views;
	}

	public String id() {
		return id;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Long itemsCount() {
		return itemsCount;
	}

	public User owner() {
		return owner;
	}

	public Thumbnails thumbnails() {
		return thumbnails;
	}

	public String title() {
		return title;
	}

	public Long totalDuration() {
		return totalDuration;
	}

	public Date updatedAt() {
		return updatedAt;
	}

	public Long views() {
		return views;
	}
	
}
