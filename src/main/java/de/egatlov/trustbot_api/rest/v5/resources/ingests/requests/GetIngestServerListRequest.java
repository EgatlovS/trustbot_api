/**
 * 
 */
package de.egatlov.trustbot_api.rest.v5.resources.ingests.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.ingests.Ingests;

/**
 * <h1>GetIngestServerListRequest</h1></br>
 * 
 * Gets a list of Twitch ingest servers.</br>
 * The Twitch ingesting system is the first stop for a broadcast stream.</br>
 * An ingest server receives your stream, and the ingesting</br>
 * system authorizes and registers streams, then prepares them for viewers.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets a list of all Twitch ingest servers.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/ingests'</br>
 * 
 * <h3>Created at: 14-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetIngestServerListRequest extends Request<Ingests> {

	/**
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetIngestServerListRequest(ClientRequestFilter... requestFilters) {
		super(requestFilters);
	}

	@Override
	public Ingests execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/ingests");

		Response response = target.request().get();
		Ingests ingests = response.readEntity(Ingests.class);
		response.close();
		return ingests;
	}

}
