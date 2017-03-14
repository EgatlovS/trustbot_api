package de.egatlov.trustbot_api.rest.v5.resources.channels.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.channels.Channel;

/**
 * <h1>GetChannelRequest</h1> </br>
 * 
 * Gets a channel object based on a specified OAuth token. </br>
 * Get Channel returns more data than Get Channel by ID</br>
 * because Get Channel is privileged.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This returns the channel object associated with OAuth token
 * cfabdegwdoklmawdzdo98xt2fo512y.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -H 'Authorization: OAuth cfabdegwdoklmawdzdo98xt2fo512y' \</br>
 * -X GET 'https://api.twitch.tv/kraken/channels'</br>
 * </br>
 * <h3>Created at: 14-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetChannelRequest extends Request<Channel> {

	/**
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetChannelRequest(ClientRequestFilter... requestFilters) {
		super(requestFilters);
	}

	@Override
	public Channel execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/channels");

		Response response = target.request().get();
		Channel channel = response.readEntity(Channel.class);
		response.close();
		return channel;
	}

}
