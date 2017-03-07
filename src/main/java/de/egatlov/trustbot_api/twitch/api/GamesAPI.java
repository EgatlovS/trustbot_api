package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.twitch.models.Games;

public interface GamesAPI extends TwitchAPI {

	/**
	 * Get games sorted by number of current viewers on Twitch, most
	 * popular first.
	 * 
	 * @param limit
	 *            - Maximum number of objects in array. Default is 10. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @return Returns games or a {@code 503 Service Unvailable} if error
	 *         retrieving games status.
	 */
	@GET
	@Path("/games/top")
	Games getGames(@DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset);

}
