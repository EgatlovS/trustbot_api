package de.egatlov.trustbot_api.rest.v5.resources.search;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.search.requests.SearchChannelsRequest;

public class SearchEndpoint implements APIEndpoint {

	/**
	 * Searches for channels based on a specified query parameter.</br>
	 * A channel is returned if the query parameter is matched</br>
	 * entirely or partially, in the channel description or game name.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets the 25 most followed channels that have “starcraft”
	 * associated with them.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET
	 * 'https://api.twitch.tv/kraken/search/channels?query=starcraft'</br>
	 * 
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public SearchChannelsRequest searchChannels(ClientRequestFilter... requestFilters) {
		return new SearchChannelsRequest(requestFilters);
	}

}
