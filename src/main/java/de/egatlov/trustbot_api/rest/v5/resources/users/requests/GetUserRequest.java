package de.egatlov.trustbot_api.rest.v5.resources.users.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.users.User;

/**
 * <h1>GetUserRequest</h1> </br>
 *
 * Gets a user object based on the OAuth token provided.</br>
 * If the user’s Twitch-registered email address is not verified,</br>
 * null is returned. Get User returns more data than Get User by ID,</br>
 * because Get User is privileged.</br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This returns the user object associated with OAuth token
 * cfabdegwdoklmawdzdo98xt2fo512y.</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \</br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \</br>
 * -H 'Authorization: OAuth cfabdegwdoklmawdzdo98xt2fo512y' \</br>
 * -X GET 'https://api.twitch.tv/kraken/user'</br>
 * </br>
 * <h3>Created at: 15-03-2017</h3>
 * 
 * @author egatlov
 */
public class GetUserRequest extends Request<User> {

	private final MultivaluedMap<String, Object> headers;

	/**
	 * Required params from this request need to be provided!
	 * 
	 * @param accessToken
	 *            - accessToken - an oauth token which you get by implementing
	 *            the twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetUserRequest(String accessToken, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.headers = new MultivaluedHashMap<>();
		this.headers.add("Authorization", accessToken);
	}

	@Override
	public User execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/user");

		Response response = target.request().headers(headers).get();
		User user = response.readEntity(User.class);
		response.close();
		return user;
	}

}
