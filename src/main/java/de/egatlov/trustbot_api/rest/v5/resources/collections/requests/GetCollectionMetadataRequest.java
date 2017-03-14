package de.egatlov.trustbot_api.rest.v5.resources.collections.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.collections.Collection;

/**
 * <h1>GetCollectionMetadataRequest</h1></br>
 *
 * Gets summary information about a specified collection.</br>
 * This does not return the collection items (videos).</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets metadata about collection myIbIFkZphQSbQ.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/collections/myIbIFkZphQSbQ'</br>
 * </br>
 * <h3>Created at: 14-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetCollectionMetadataRequest extends Request<Collection> {

	private final Long collectionId;

	/**
	 * Required params from this request need to be provided!
	 * 
	 * @param collectionId
	 *            - the ID of the collection.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetCollectionMetadataRequest(Long collectionId, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.collectionId = collectionId;
	}

	@Override
	public Collection execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/collections/" + collectionId);

		Response response = target.request().get();
		Collection collection = response.readEntity(Collection.class);
		response.close();
		return collection;
	}

}
