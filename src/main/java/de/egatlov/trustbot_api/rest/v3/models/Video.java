package de.egatlov.trustbot_api.rest.v3.models;

import java.util.Date;

public class Video {

	private final String title;
	private final String description;
	/**
	 * broadcast_id
	 */
	private final Long broadcastId;
	private final String status;
	/**
	 * _id
	 */
	private final String id;
	/**
	 * tag_list
	 */
	private final String tagList;
	/**
	 * recorded_at
	 */
	private final Date recordedAt;
	private final String game;
	private final Integer length;
	private final String preview;
	private final String url;
	private final Long views;
	/**
	 * broadcast_type
	 */
	private final String broadcastType;
	/**
	 * _links
	 */
	private final Links links;
	private final Channel channel;

	public Video(String title, String description, Long broadcastId, String status, String id, String tagList,
			Date recordedAt, String game, Integer length, String preview, String url, Long views, String broadcastType,
			Links links, Channel channel) {
		this.title = title;
		this.description = description;
		this.broadcastId = broadcastId;
		this.status = status;
		this.id = id;
		this.tagList = tagList;
		this.recordedAt = recordedAt;
		this.game = game;
		this.length = length;
		this.preview = preview;
		this.url = url;
		this.views = views;
		this.broadcastType = broadcastType;
		this.links = links;
		this.channel = channel;
	}

	public String title() {
		return title;
	}

	public String description() {
		return description;
	}

	public Long broadcastId() {
		return broadcastId;
	}

	public String status() {
		return status;
	}

	public String id() {
		return id;
	}

	public String tagList() {
		return tagList;
	}

	public Date recordedAt() {
		return recordedAt;
	}

	public String game() {
		return game;
	}

	public Integer length() {
		return length;
	}

	public String preview() {
		return preview;
	}

	public String url() {
		return url;
	}

	public Long views() {
		return views;
	}

	public String broadcastType() {
		return broadcastType;
	}

	public Links links() {
		return links;
	}

	public Channel channel() {
		return channel;
	}

}
