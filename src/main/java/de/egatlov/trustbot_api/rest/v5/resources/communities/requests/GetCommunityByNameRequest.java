/**
 * 
 */
package de.egatlov.trustbot_api.rest.v5.resources.communities.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.communities.Community;

/**
 * <h1>GetCommunityByNameRequest</h1></br>
 * 
 * Gets a specified community.</br>
 * The name of the community is specified in a required query-string parameter.
 * It must be 3-25 characters.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets the DallasTesterCommunity community.</b></br>
 * curl -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -X GET
 * 'https://api.twitch.tv/kraken/communities?name=DallasTesterCommunity'</br>
 * </br>
 * <h3>Created at: 14-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetCommunityByNameRequest extends Request<Community> {

	private final String communityName;

	/**
	 * Required params from this request need to be provided!
	 * 
	 * @param communityName
	 *            - the communities name.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetCommunityByNameRequest(String communityName, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.communityName = communityName;
	}

	@Override
	public Community execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/communities").queryParam("name",
				communityName);

		Response response = target.request().get();
		Community community = response.readEntity(Community.class);
		response.close();
		return community;
	}

}
