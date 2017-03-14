package de.egatlov.trustbot_api.rest.v5.resources.communities;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.communities.requests.GetCommunityByNameRequest;

public class CommunitiesEndpoint implements APIEndpoint {

	/**
	 * Gets a specified community.</br>
	 * The name of the community is specified in a required query-string
	 * parameter. It must be 3-25 characters.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets the DallasTesterCommunity community.</b></br>
	 * curl -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -X GET
	 * 'https://api.twitch.tv/kraken/communities?name=DallasTesterCommunity'</br>
	 * 
	 * @param communityName
	 *            - the communities name.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetCommunityByNameRequest getCommunityByName(String communityName, ClientRequestFilter... requestFilters) {
		return new GetCommunityByNameRequest(communityName, requestFilters);
	}

}
