package de.egatlov.trustbot_api.rest.v5.resources.streams;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.streams.requests.GetStreamByUserRequest;

public class StreamsEndpoint implements APIEndpoint {

	/**
	 * * Gets stream information (the stream object) for a specified user.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets stream information for channel 44322889.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/streams/44322889'</br>
	 * 
	 * @param channelId
	 *            - the ID of the channel.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetStreamByUserRequest getStreamByUser(Long channelId, ClientRequestFilter... requestFilters) {
		return new GetStreamByUserRequest(channelId, requestFilters);
	}

}
