package de.egatlov.trustbot_api.rest.v5.resources.teams.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.teams.Teams;

/**
 * <h1>GetAllTeamsRequest</h1> </br>
 *
 * Gets all active teams.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets the team objects for the 25 most recently created
 * teams.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/teams'</br>
 * </br>
 * <h3>Created at: 15-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetAllTeamsRequest extends Request<Teams> {

	private final MultivaluedMap<String, Object> queryParams;

	/**
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetAllTeamsRequest(ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.queryParams = new MultivaluedHashMap<>();
	}

	@Override
	public Teams execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/teams").queryParams(queryParams);

		Response response = target.request().get();
		Teams teams = response.readEntity(Teams.class);
		response.close();
		return teams;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: 25.</br>
	 * Maximum: 100.</br>
	 * 
	 * @param limit
	 *            - Maximum number of objects to return, sorted by creation
	 *            date.
	 */
	public GetAllTeamsRequest withLimitQueryParam(Integer limit) {
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
	public GetAllTeamsRequest withOffsetQueryParam(Integer offset) {
		if (offset != null && !queryParams.containsKey("offset")) {
			queryParams.add("offset", offset);
		}
		return this;
	}

}
