package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.twitch.models.Team;
import de.egatlov.trustbot_api.twitch.models.Teams;

public interface TeamsAPI extends TwitchAPI {

	/**
	 * Get active teams. Teams are an organization of channels.
	 * 
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @return Returns teams.
	 */
	@GET
	@Path("/teams")
	public Teams getTeams(@DefaultValue("25") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset);

	/**
	 * Get a team object for {@code :team}.
	 * 
	 * @param team
	 *            - the teams name
	 * @return Returns a team object.
	 */
	@GET
	@Path("/teams/{team}")
	public Team getTeam(@PathParam("team") String team);

}
