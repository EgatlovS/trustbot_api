package de.egatlov.trustbot_api.rest.v5.models.streams;

import java.util.Date;

import de.egatlov.trustbot_api.rest.v5.models.channels.Channel;
import de.egatlov.trustbot_api.rest.v5.models.viewables.Preview;

public class Stream {

	/**
	 * _id
	 */
	private final Long id;
	private final String game;
	private final Long viewers;
	/**
	 * video_height
	 */
	private final Long videoHeight;
	/**
	 * average_fps
	 */
	private final Long averageFps;
	private final Long delay;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * is_playlist
	 */
	private final Boolean isPlaylist;
	private final Preview preview;
	private final Channel channel;

	public Stream(Long id, String game, Long viewers, Long videoHeight, Long averageFps, Long delay, Date createdAt,
			Boolean isPlaylist, Preview preview, Channel channel) {
		this.id = id;
		this.game = game;
		this.viewers = viewers;
		this.videoHeight = videoHeight;
		this.averageFps = averageFps;
		this.delay = delay;
		this.createdAt = createdAt;
		this.isPlaylist = isPlaylist;
		this.preview = preview;
		this.channel = channel;
	}

	public Long id() {
		return id;
	}

	public String game() {
		return game;
	}

	public Long viewers() {
		return viewers;
	}

	public Long videoHeight() {
		return videoHeight;
	}

	public Long averageFps() {
		return averageFps;
	}

	public Long delay() {
		return delay;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Boolean isPlaylist() {
		return isPlaylist;
	}

	public Preview preview() {
		return preview;
	}

	public Channel channel() {
		return channel;
	}

}
