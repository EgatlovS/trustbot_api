package de.egatlov.trustbot_api.rest.v5.resources.users;

import javax.ws.rs.client.ClientRequestFilter;

import de.egatlov.trustbot_api.rest.v5.api.APIEndpoint;
import de.egatlov.trustbot_api.rest.v5.resources.users.requests.GetUserRequest;

public class UsersEndpoint implements APIEndpoint {

	/**
	 * * Gets a user object based on the OAuth token provided.</br>
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
	 * 
	 * @param accessToken
	 *            - accessToken - an oauth token which you get by implementing
	 *            the twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 * @return
	 */
	public GetUserRequest getUser(String accessToken, ClientRequestFilter... requestFilters) {
		return new GetUserRequest(accessToken, requestFilters);
	}

}
