package de.egatlov.trustbot_api.rest.v5.resources.ingests;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.ingests.requests.GetIngestServerListRequest;

public class IngestsEndpoint implements APIEndpoint {

	/**
	 * Gets a list of Twitch ingest servers.</br>
	 * The Twitch ingesting system is the first stop for a broadcast
	 * stream.</br>
	 * An ingest server receives your stream, and the ingesting</br>
	 * system authorizes and registers streams, then prepares them for
	 * viewers.</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets a list of all Twitch ingest servers.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/ingests'</br>
	 * 
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetIngestServerListRequest getIngestServerList(ClientRequestFilter... requestFilters) {
		return new GetIngestServerListRequest(requestFilters);
	}

}
