package de.egatlov.trustbot_api.rest.v3.models;

import java.util.Date;

public class Team {

	private final String info;
	/**
	 * _links
	 */
	private final Links links;
	private final String background;
	private final String banner;
	private final String name;
	/**
	 * _id
	 */
	private final Long id;
	/**
	 * updated_at
	 */
	private final Date updatedAt;
	/**
	 * display_name
	 */
	private final String displayName;
	/**
	 * created_at
	 */
	private final Date createdAt;
	private final String logo;

	public Team(String info, Links links, String background, String banner, String name, Long id, Date updatedAt,
			String displayName, Date createdAt, String logo) {
		this.info = info;
		this.links = links;
		this.background = background;
		this.banner = banner;
		this.name = name;
		this.id = id;
		this.updatedAt = updatedAt;
		this.displayName = displayName;
		this.createdAt = createdAt;
		this.logo = logo;
	}

	public String info() {
		return info;
	}

	public Links links() {
		return links;
	}

	public String background() {
		return background;
	}

	public String banner() {
		return banner;
	}

	public String name() {
		return name;
	}

	public Long id() {
		return id;
	}

	public Date updatedAt() {
		return updatedAt;
	}

	public String displayName() {
		return displayName;
	}

	public Date createdAt() {
		return createdAt;
	}

	public String logo() {
		return logo;
	}
}
