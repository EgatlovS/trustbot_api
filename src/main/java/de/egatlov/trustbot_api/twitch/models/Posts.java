package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Posts {

	/**
	 * _total
	 */
	private final Integer total;
	/**
	 * _cursor
	 */
	private final String cursor;
	private final List<Post> posts;

	public Posts(Integer total, String cursor, List<Post> posts) {
		this.total = total;
		this.cursor = cursor;
		this.posts = posts;
	}

	public Integer total() {
		return total;
	}

	public String cursor() {
		return cursor;
	}

	public List<Post> posts() {
		return posts;
	}

}
