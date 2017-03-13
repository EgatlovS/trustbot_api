package de.egatlov.trustbot_api.rest.v3.models;

import java.util.Date;
import java.util.List;

public class Post {

	private final String id;
	/**
	 * created_at
	 */
	private final Date createdAt;

	private final Boolean deleted;

	private final List<Emoticons> emotes;

	private final Reactions reactions;

	private final String body;

	private final User user;

	public Post(String id, Date createdAt, Boolean deleted, List<Emoticons> emotes, Reactions reactions, String body,
			User user) {
		this.id = id;
		this.createdAt = createdAt;
		this.deleted = deleted;
		this.emotes = emotes;
		this.reactions = reactions;
		this.body = body;
		this.user = user;
	}

	public String id() {
		return id;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Boolean deleted() {
		return deleted;
	}

	public List<Emoticons> emotes() {
		return emotes;
	}

	public Reactions reactions() {
		return reactions;
	}

	public String body() {
		return body;
	}

	public User user() {
		return user;
	}

}
