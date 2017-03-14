package de.egatlov.trustbot_api.rest.v5.resources.collections;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.collections.requests.GetCollectionMetadataRequest;

public class CollectionsEndpoint implements APIEndpoint {

	/**
	 * Gets summary information about a specified collection.</br>
	 * This does not return the collection items (videos).</br>
	 * 
	 * <h2>Example Request:</h2> </br>
	 * <b>This gets metadata about collection myIbIFkZphQSbQ.</b></br>
	 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
	 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
	 * -X GET 'https://api.twitch.tv/kraken/collections/myIbIFkZphQSbQ'</br>
	 * 
	 * @param collectionId
	 *            - the ID of the collection.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetCollectionMetadataRequest getCollectionMetadata(Long collectionId,
			ClientRequestFilter... requestFilters) {
		return new GetCollectionMetadataRequest(collectionId, requestFilters);
	}

}
