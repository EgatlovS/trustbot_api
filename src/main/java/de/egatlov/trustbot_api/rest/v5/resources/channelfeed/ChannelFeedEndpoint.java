package de.egatlov.trustbot_api.rest.v5.resources.channelfeed;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.channelfeed.requests.GetPostsRequest;

public final class ChannelFeedEndpoint implements APIEndpoint {

	/**
	 * Gets posts from a specified channel feed. </br>
	 * If authentication is provided, the user_ids array </br>
	 * in the response body contains the requesting user’s ID, </br>
	 * if they have reacted to a post. </br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets the most recent post from channel feed "44322889".</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \ </br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \ </br>
	 * -H 'Authorization: OAuth cfabdegwdoklmawdzdo98xt2fo512y' \ </br>
	 * -X GET 'https://api.twitch.tv/kraken/feed/44322889/posts?limit=1' </br>
	 * 
	 * @param channelId
	 *            - the ID of the channel.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetPostsRequest getPosts(Long channelId, ClientRequestFilter... requestFilters) {
		return new GetPostsRequest(channelId, requestFilters);
	}

}
