package de.egatlov.trustbot_api.rest.v5.models.videos;

import java.util.Date;
import java.util.List;

import de.egatlov.trustbot_api.rest.v5.models.channels.Channel;
import de.egatlov.trustbot_api.rest.v5.models.viewables.Preview;

public class Video {

	/**
	 * _id
	 */
	private final String id;
	/**
	 * broadcast_id
	 */
	private final Long broadcastId;
	/**
	 * broadcast_type
	 */
	private final String broadcastType;
	private final Channel channel;
	/**
	 * created_at
	 */
	private final Date createdAt;
	private final String description;
	/**
	 * description_html
	 */
	private final String descriptionHtml;
	private final Fps fps;
	private final String game;
	private final String language;
	private final Long length;
	/**
	 * muted_segments
	 */
	private final List<MutedSegment> mutedSegments;
	private final Preview preview;
	/**
	 * published_at
	 */
	private final Date publishedAt;
	private final Resolutions resolutions;
	private final String status;
	/**
	 * tag_list
	 */
	private final String tagList;
	private final Thumbnails thumbnails;
	private final String title;
	private final String url;
	private final String viewable;
	/**
	 * viewable_at
	 */
	private final Date viewableAt;
	private final Long views;

	public Video(String id, Long broadcastId, String broadcastType, Channel channel, Date createdAt, String description,
			String descriptionHtml, Fps fps, String game, String language, Long length,
			List<MutedSegment> mutedSegments, Preview preview, Date publishedAt, Resolutions resolutions, String status,
			String tagList, Thumbnails thumbnails, String title, String url, String viewable, Date viewableAt,
			Long views) {
		this.id = id;
		this.broadcastId = broadcastId;
		this.broadcastType = broadcastType;
		this.channel = channel;
		this.createdAt = createdAt;
		this.description = description;
		this.descriptionHtml = descriptionHtml;
		this.fps = fps;
		this.game = game;
		this.language = language;
		this.length = length;
		this.mutedSegments = mutedSegments;
		this.preview = preview;
		this.publishedAt = publishedAt;
		this.resolutions = resolutions;
		this.status = status;
		this.tagList = tagList;
		this.thumbnails = thumbnails;
		this.title = title;
		this.url = url;
		this.viewable = viewable;
		this.viewableAt = viewableAt;
		this.views = views;
	}

	public String id() {
		return id;
	}

	public Long broadcastId() {
		return broadcastId;
	}

	public String broadcastType() {
		return broadcastType;
	}

	public Channel channel() {
		return channel;
	}

	public Date createdAt() {
		return createdAt;
	}

	public String description() {
		return description;
	}

	public String descriptionHtml() {
		return descriptionHtml;
	}

	public Fps fps() {
		return fps;
	}

	public String game() {
		return game;
	}

	public String language() {
		return language;
	}

	public Long length() {
		return length;
	}

	public List<MutedSegment> mutedSegments() {
		return mutedSegments;
	}

	public Preview preview() {
		return preview;
	}

	public Date publishedAt() {
		return publishedAt;
	}

	public Resolutions resolutions() {
		return resolutions;
	}

	public String status() {
		return status;
	}

	public String tagList() {
		return tagList;
	}

	public Thumbnails thumbnails() {
		return thumbnails;
	}

	public String title() {
		return title;
	}

	public String url() {
		return url;
	}

	public String viewable() {
		return viewable;
	}

	public Date viewableAt() {
		return viewableAt;
	}

	public Long views() {
		return views;
	}

}
