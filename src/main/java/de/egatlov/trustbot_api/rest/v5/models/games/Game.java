package de.egatlov.trustbot_api.rest.v5.models.games;

import de.egatlov.trustbot_api.rest.v5.models.viewables.Box;
import de.egatlov.trustbot_api.rest.v5.models.viewables.Logo;

public class Game {

	private final String name;

	private final Box box;

	private final Logo logo;
	/**
	 * _id
	 */
	private final Long id;
	/**
	 * giantbomb_id
	 */
	private final Integer giantbombId;
	private final Long popularity;

	public Game(String name, Box box, Logo logo, Long id, Integer giantbombId, Long popularity) {
		this.name = name;
		this.box = box;
		this.logo = logo;
		this.id = id;
		this.giantbombId = giantbombId;
		this.popularity = popularity;
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

	public Long id() {
		return id;
	}

	public Integer giantbombId() {
		return giantbombId;
	}

	public Long popularity() {
		return popularity;
	}

}
