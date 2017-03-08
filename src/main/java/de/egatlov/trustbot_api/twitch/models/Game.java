package de.egatlov.trustbot_api.twitch.models;

public class Game {

	private final String name;

	private final Box box;

	private final Logo logo;
	/**
	 * _links
	 */
	private final Links links;
	/**
	 * _id
	 */
	private final Long id;
	/**
	 * giantbomb_id
	 */
	private final Integer giantbombId;

	public Game(String name, Box box, Logo logo, Links links, Long id, Integer giantbombId) {
		this.name = name;
		this.box = box;
		this.logo = logo;
		this.links = links;
		this.id = id;
		this.giantbombId = giantbombId;
	}

	public String name() {
		return name;
	}

	public Box box() {
		return box;
	}

	public Logo logo() {
		return logo;
	}

	public Links links() {
		return links;
	}

	public Long id() {
		return id;
	}

	public Integer giantbombId() {
		return giantbombId;
	}

}
