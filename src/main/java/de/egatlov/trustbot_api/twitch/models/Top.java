package de.egatlov.trustbot_api.twitch.models;

public class Top {

	private final Game game;

	private final Long viewers;

	private final Integer channels;

	public Top(Game game, Long viewers, Integer channels) {
		this.game = game;
		this.viewers = viewers;
		this.channels = channels;
	}

	public Game game() {
		return game;
	}

	public Long viewers() {
		return viewers;
	}

	public Integer channels() {
		return channels;
	}

}
