package de.egatlov.trustbot_api.rest.v5.resources.videos.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.videos.Video;

/**
 * <h1>GetVideoRequest</h1> </br>
 *
 * Gets a specified video object.</br>
 * Note that in prior versions of the API,</br>
 * the specified video ID required a “v” prefix.</br>
 * That prefix is deprecated.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This returns the object for video 106400740.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/videos/106400740'</br>
 * </br>
 * <h3>Created at: 15-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetVideoRequest extends Request<Video> {

	private final Long videoId;

	/**
	 * Required params from this request need to be provided!
	 * 
	 * @param videoId
	 *            - the ID of the video.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetVideoRequest(Long videoId, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.videoId = videoId;
	}

	@Override
	public Video execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/videos/" + videoId);

		Response response = target.request().get();
		Video video = response.readEntity(Video.class);
		response.close();
		return video;
	}

}
