package de.egatlov.trustbot_api.rest.v5.resources.teams;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.teams.requests.GetAllTeamsRequest;

public class TeamsEndpoint implements APIEndpoint {

	/**
	 * * Gets all active teams.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets the team objects for the 25 most recently created
	 * teams.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/teams'</br>
	 * 
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetAllTeamsRequest getAllTeams(ClientRequestFilter... requestFilters) {
		return new GetAllTeamsRequest(requestFilters);
	}

}
