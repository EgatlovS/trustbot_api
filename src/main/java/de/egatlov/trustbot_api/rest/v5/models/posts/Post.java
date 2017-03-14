package de.egatlov.trustbot_api.rest.v5.models.posts;

import java.util.Date;
import java.util.List;

import de.egatlov.trustbot_api.rest.v5.models.Embed;
import de.egatlov.trustbot_api.rest.v5.models.Emote;
import de.egatlov.trustbot_api.rest.v5.models.Reactions;
import de.egatlov.trustbot_api.rest.v5.models.comments.Comments;
import de.egatlov.trustbot_api.rest.v5.models.users.User;

public class Post {

	private final String body;
	private final Comments comments;
	/**
	 * created_at
	 */
	private final Date createdAt;
	private final Boolean deleted;
	private final List<Embed> embeds;
	private final List<Emote> emotes;
	private final String id;
	private final Permissions permissions;
	private final Reactions reactions;
	private final User user;

	public Post(String body, Comments comments, Date createdAt, Boolean deleted, List<Embed> embeds, List<Emote> emotes,
			String id, Permissions permissions, Reactions reactions, User user) {
		this.body = body;
		this.comments = comments;
		this.createdAt = createdAt;
		this.deleted = deleted;
		this.embeds = embeds;
		this.emotes = emotes;
		this.id = id;
		this.permissions = permissions;
		this.reactions = reactions;
		this.user = user;
	}

	public String body() {
		return body;
	}

	public Comments comments() {
		return comments;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Boolean deleted() {
		return deleted;
	}

	public List<Embed> embeds() {
		return embeds;
	}

	public List<Emote> emotes() {
		return emotes;
	}

	public String id() {
		return id;
	}

	public Permissions permissions() {
		return permissions;
	}

	public Reactions reactions() {
		return reactions;
	}

	public User user() {
		return user;
	}

}
