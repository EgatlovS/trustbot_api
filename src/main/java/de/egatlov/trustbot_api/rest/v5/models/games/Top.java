package de.egatlov.trustbot_api.rest.v5.models.games;

public class Top {

	private final Game game;

	private final Long viewers;

	private final Long channels;

	public Top(Game game, Long viewers, Long channels) {
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

	public Long channels() {
		return channels;
	}

}
