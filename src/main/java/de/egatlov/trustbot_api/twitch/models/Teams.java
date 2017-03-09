package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Teams {

	/**
	 * _links
	 */
	private final Links links;
	private final List<Team> teams;

	public Teams(Links links, List<Team> teams) {
		this.links = links;
		this.teams = teams;
	}

	public Links links() {
		return links;
	}

	public List<Team> teams() {
		return teams;
	}

}
