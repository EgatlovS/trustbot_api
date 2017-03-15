package de.egatlov.trustbot_api.rest.v5.models.teams;

import java.util.Date;

public class Team {

	/**
	 * _id
	 */
	private final Long id;
	private final String background;
	private final String banner;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * display_name
	 */
	private final String displayName;
	private final String info;
	private final String logo;
	private final String name;
	/**
	 * updated_at
	 */
	private final Date updatedAt;

	public Team(Long id, String background, String banner, Date createdAt, String displayName, String info, String logo,
			String name, Date updatedAt) {
		this.id = id;
		this.background = background;
		this.banner = banner;
		this.createdAt = createdAt;
		this.displayName = displayName;
		this.info = info;
		this.logo = logo;
		this.name = name;
		this.updatedAt = updatedAt;
	}

	public Long id() {
		return id;
	}

	public String background() {
		return background;
	}

	public String banner() {
		return banner;
	}

	public Date createdAt() {
		return createdAt;
	}

	public String displayName() {
		return displayName;
	}

	public String info() {
		return info;
	}

	public String logo() {
		return logo;
	}

	public String name() {
		return name;
	}

	public Date updatedAt() {
		return updatedAt;
	}

}
