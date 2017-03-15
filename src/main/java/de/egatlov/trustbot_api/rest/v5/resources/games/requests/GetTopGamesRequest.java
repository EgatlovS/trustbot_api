package de.egatlov.trustbot_api.rest.v5.resources.games.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.games.Games;

/**
 * <h1>GetTopGamesRequest</h1></br>
 * 
 * Gets games sorted by number of current viewers on Twitch,</br>
 * most popular first.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets the 10 currently most-viewed games on Twitch.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/games/top'</br>
 * <h2>Errors:</h2></br>
 * 503 Service Unvailable if error retrieving games status. </br>
 * <h3>Created at: 14-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetTopGamesRequest extends Request<Games> {

	private final MultivaluedMap<String, Object> queryParams;

	/**
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetTopGamesRequest(ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.queryParams = new MultivaluedHashMap<>();
	}

	@Override
	public Games execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/games/top").queryParams(queryParams);

		Response response = target.request().get();
		Games games = response.readEntity(Games.class);
		response.close();
		return games;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: 10.</br>
	 * Maximum: 100.</br>
	 * 
	 * @param limit
	 *            - Maximum number of most-recent objects to return.
	 */
	public GetTopGamesRequest withLimitQueryParam(Integer limit) {
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
	public GetTopGamesRequest withOffsetQueryParam(Integer offset) {
		if (offset != null && !queryParams.containsKey("offset")) {
			queryParams.add("offset", offset);
		}
		return this;
	}

}
