package de.egatlov.trustbot_api.rest.v5.resources.chat;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.chat.requests.GetBadgesByChannelRequest;

public class ChatEndpoint implements APIEndpoint {

	/**
	 * Gets a list of badges that can be used in chat for a specified
	 * channel.</br>
	 *
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets a list of chat badges for channel 44322889.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/chat/44322889/badges'</br>
	 * 
	 * @param channelId
	 *            - the ID of the channel.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetBadgesByChannelRequest getBadgesByChannel(Long channelId, ClientRequestFilter... requestFilters) {
		return new GetBadgesByChannelRequest(channelId, requestFilters);
	}

}
