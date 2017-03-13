package de.egatlov.trustbot_api.rest.v5.models;

import java.util.List;

public class Posts {

	/**
	 * _cursor
	 */
	private final String cursor;
	/**
	 * _topic
	 */
	private final String topic;
	/**
	 * _disabled
	 */
	private final Boolean disabled;
	private final List<Post> posts;

	public Posts(String cursor, String topic, Boolean disabled, List<Post> posts) {
		this.cursor = cursor;
		this.topic = topic;
		this.disabled = disabled;
		this.posts = posts;
	}

	public String cursor() {
		return cursor;
	}

	public String topic() {
		return topic;
	}

	public Boolean disabled() {
		return disabled;
	}

	public List<Post> posts() {
		return posts;
	}

}
