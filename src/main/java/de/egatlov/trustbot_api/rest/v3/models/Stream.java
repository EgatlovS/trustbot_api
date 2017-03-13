package de.egatlov.trustbot_api.rest.v3.models;

import java.util.Date;

public class Stream {

	private final String game;
	private final Long viewers;
	/**
	 * average_fps
	 */
	private final Double averageFps;
	private final Integer delay;
	/**
	 * video_height
	 */
	private final Integer videoHeight;
	/**
	 * is_playlist
	 */
	private final Boolean isPlaylist;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * _id
	 */
	private final Long id;
	private final Channel channel;
	private final Preview preview;
	/**
	 * _links
	 */
	private final Links links;

	public Stream(String game, Long viewers, Double averageFps, Integer delay, Integer videoHeight, Boolean isPlaylist,
			Date createdAt, Long id, Channel channel, Preview preview, Links links) {
		this.game = game;
		this.viewers = viewers;
		this.averageFps = averageFps;
		this.delay = delay;
		this.videoHeight = videoHeight;
		this.isPlaylist = isPlaylist;
		this.createdAt = createdAt;
		this.id = id;
		this.channel = channel;
		this.preview = preview;
		this.links = links;
	}

	public String game() {
		return game;
	}

	public Long viewers() {
		return viewers;
	}

	public Double averageFps() {
		return averageFps;
	}

	public Integer delay() {
		return delay;
	}

	public Integer videoHeight() {
		return videoHeight;
	}

	public Boolean isPlaylist() {
		return isPlaylist;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Long id() {
		return id;
	}

	public Channel channel() {
		return channel;
	}

	public Preview preview() {
		return preview;
	}

	public Links links() {
		return links;
	}

}
