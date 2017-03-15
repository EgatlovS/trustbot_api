package de.egatlov.trustbot_api.rest.v5.models.teams;

import java.util.List;

import de.egatlov.trustbot_api.rest.v5.models.teams.Team;

public class Teams {

	private final List<Team> teams;

	public Teams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Team> teams() {
		return teams;
	}

}
