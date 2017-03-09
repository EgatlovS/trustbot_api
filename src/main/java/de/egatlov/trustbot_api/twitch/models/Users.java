package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Users {

	/**
	 * _links
	 */
	private final Links links;
	private final List<User> users;

	public Users(Links links, List<User> users) {
		this.links = links;
		this.users = users;
	}

	public Links links() {
		return links;
	}

	public List<User> users() {
		return users;
	}

}
