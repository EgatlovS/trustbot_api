package de.egatlov.trustbot_api.rest.v5.resources.streams.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.streams.Streams;

/**
 * <h1>GetStreamByUserRequest</h1> </br>
 *
 * Gets stream information (the stream object) for a specified user.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets stream information for channel 44322889.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/streams/44322889'</br>
 * </br>
 * <h3>Created at: 15-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetStreamByUserRequest extends Request<Streams> {

	private final MultivaluedMap<String, Object> queryParams;
	private final Long channelId;

	/**
	 * Required params from this request need to be provided!
	 * 
	 * @param channelId
	 *            - the ID of the channel.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetStreamByUserRequest(Long channelId, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.queryParams = new MultivaluedHashMap<>();
		this.channelId = channelId;
	}

	@Override
	public Streams execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/streams/" + channelId)
				.queryParams(queryParams);

		Response response = target.request().get();
		Streams streams = response.readEntity(Streams.class);
		response.close();
		return streams;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: live.</br>
	 * 
	 * @param streamType
	 *            - Constrains the type of streams returned. Valid values: live,
	 *            playlist, all. Playlists are offline streams of VODs (Video on
	 *            Demand) that appear live.
	 */
	public GetStreamByUserRequest withStreamTypeQueryParam(String streamType) {
		if (streamType != null && !queryParams.containsKey("stream_type")) {
			queryParams.add("stream_type", streamType);
		}
		return this;
	}

}
