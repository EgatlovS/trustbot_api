package de.egatlov.trustbot_api.rest.v5.resources.search.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.channels.Channels;

/**
 * <h1>SearchChannelsRequest</h1> </br>
 *
 * Searches for channels based on a specified query parameter.</br>
 * A channel is returned if the query parameter is matched</br>
 * entirely or partially, in the channel description or game name.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets the 25 most followed channels that have “starcraft” associated
 * with them.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/search/channels?query=starcraft'</br>
 * </br>
 * <h3>Created at: 15-03-2017</h3>
 * 
 * @author egatlov
 */
public class SearchChannelsRequest extends Request<Channels> {

	private final MultivaluedMap<String, Object> queryParams;

	/**
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public SearchChannelsRequest(ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.queryParams = new MultivaluedHashMap<>();
	}

	@Override
	public Channels execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/search/channels")
				.queryParams(queryParams);

		Response response = target.request().get();
		Channels channels = response.readEntity(Channels.class);
		response.close();
		return channels;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: 25.</br>
	 * Maximum: 100.</br>
	 * 
	 * @param limit
	 *            - Maximum number of objects to return, sorted by number of
	 *            followers.
	 */
	public SearchChannelsRequest withLimitQueryParam(Integer limit) {
		if (limit != null && !queryParams.containsKey("limit")) {
			queryParams.add("limit", limit);
		}
		return this;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: 0.</br>
	 * 
	 * @param offset
	 *            - Object offset for pagination of results.
	 */
	public SearchChannelsRequest withOffsetQueryParam(Integer offset) {
		if (offset != null && !queryParams.containsKey("offset")) {
			queryParams.add("offset", offset);
		}
		return this;
	}

}
