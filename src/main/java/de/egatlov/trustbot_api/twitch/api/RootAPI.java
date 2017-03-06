package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;

import de.egatlov.trustbot_api.twitch.models.Root;

public interface RootAPI extends TwitchAPI {

	/**
	 * Get top level links and authorization status. If you are authenticated,
	 * the response includes the status of your token and links to other related
	 * resources.
	 * 
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns basic information ({@code Root}) about the API and
	 *         authentication status
	 */
	@GET
	Root getInformation(@HeaderParam("Authorization") String accessToken);

}
