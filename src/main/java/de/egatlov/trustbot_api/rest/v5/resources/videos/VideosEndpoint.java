package de.egatlov.trustbot_api.rest.v5.resources.videos;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.videos.requests.GetVideoRequest;

public class VideosEndpoint implements APIEndpoint {

	/**
	 * * Gets a specified video object.</br>
	 * Note that in prior versions of the API,</br>
	 * the specified video ID required a “v” prefix.</br>
	 * That prefix is deprecated.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This returns the object for video 106400740.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/videos/106400740'</br>
	 * 
	 * @param videoId
	 *            - the ID of the video.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetVideoRequest getVideo(Long videoId, ClientRequestFilter... requestFilters) {
		return new GetVideoRequest(videoId, requestFilters);
	}

}
