/**
 * 
 */
package de.egatlov.trustbot_api.rest.v5.resources.chat.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.badges.Badges;

/**
 * <h1>GetBadgesByChannelRequest</h1></br>
 *
 * Gets a list of badges that can be used in chat for a specified channel.</br>
 *
 * <h2>Example Request:</h2> </br>
 * <b>This gets a list of chat badges for channel 44322889.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -X GET 'https://api.twitch.tv/kraken/chat/44322889/badges'</br>
 * </br>
 * <h3>Created at: 14-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetBadgesByChannelRequest extends Request<Badges> {

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
	public GetBadgesByChannelRequest(Long channelId, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.channelId = channelId;
	}

	@Override
	public Badges execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/chat/" + channelId + "/badges");

		Response response = target.request().get();
		Badges badges = response.readEntity(Badges.class);
		response.close();
		return badges;
	}

}
