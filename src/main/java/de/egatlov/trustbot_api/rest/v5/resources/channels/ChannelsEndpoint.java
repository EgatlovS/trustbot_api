package de.egatlov.trustbot_api.rest.v5.resources.channels;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.channels.requests.GetChannelRequest;

public class ChannelsEndpoint implements APIEndpoint {

	/**
	 * Gets a channel object based on a specified OAuth token. </br>
	 * Get Channel returns more data than Get Channel by ID</br>
	 * because Get Channel is privileged.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This returns the channel object associated with OAuth token
	 * cfabdegwdoklmawdzdo98xt2fo512y.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -H 'Authorization: OAuth cfabdegwdoklmawdzdo98xt2fo512y' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/channels'</br>
	 * 
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetChannelRequest getChannel(ClientRequestFilter... requestFilters) {
		return new GetChannelRequest(requestFilters);
	}

}
