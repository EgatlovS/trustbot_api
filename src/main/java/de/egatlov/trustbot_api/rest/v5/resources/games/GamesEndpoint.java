package de.egatlov.trustbot_api.rest.v5.resources.games;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.games.requests.GetTopGamesRequest;

public class GamesEndpoint implements APIEndpoint {

	/**
	 * Gets games sorted by number of current viewers on Twitch,</br>
	 * most popular first.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets the 10 currently most-viewed games on Twitch.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/games/top'</br>
	 * <h2>Errors:</h2></br>
	 * 503 Service Unvailable if error retrieving games status. </br>
	 * 
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetTopGamesRequest getTopGames(ClientRequestFilter... requestFilters) {
		return new GetTopGamesRequest(requestFilters);
	}

}
