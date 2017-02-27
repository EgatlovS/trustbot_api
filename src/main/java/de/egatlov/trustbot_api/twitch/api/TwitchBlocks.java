package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.twitch.models.Block;
import de.egatlov.trustbot_api.twitch.models.Blocks;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/kraken")
public interface TwitchBlocks {

	/**
	 * Returns a list of blocks objects on :user's block list. List sorted by
	 * recency, newest first.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @param limit
	 * @param offset
	 * @return Returns a list of blocks objects on :user's block list. List
	 *         sorted by recency, newest first.
	 */
	@GET
	@Path("/users/{username}/blocks")
	Blocks getBlocks(@PathParam("username") String username, @HeaderParam("Client-ID: ") String clientId,
			@HeaderParam("Authorization: OAuth ") String accessToken,
			@DefaultValue("25") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset);

	/**
	 * Adds :target to :user's block list. :user is the authenticated user and
	 * :target is user to be blocked.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param targetUsername
	 *            - the user to block
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a blocks object.
	 */
	@PUT
	@Path("/users/{username}/blocks/{targetUsername}")
	Block blockUser(@PathParam("username") String username, @PathParam("targetUsername") String targetUsername,
			@HeaderParam("Client-ID: ") String clientId, @HeaderParam("Authorization: OAuth ") String accessToken);

	/**
	 * Removes :target from :user's block list. :user is the authenticated user
	 * and :target is user to be unblocked.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param targetUsername
	 *            - the user to unblock
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return 204 No Content if successful. 404 Not Found if :target not on
	 *         :user's block list. 422 Unprocessable Entity if delete failed.
	 */
	@DELETE
	@Path("/users/{username}/blocks/{targetUsername}")
	Response unblockUser(@PathParam("username") String username, @PathParam("targetUsername") String targetUsername,
			@HeaderParam("Client-ID: ") String clientId, @HeaderParam("Authorization: OAuth ") String accessToken);

	class APIClient {

		public static TwitchBlocks newClient() {
			Client client = ClientBuilder.newClient();
			String url = "https://api.twitch.tv";
			ResteasyWebTarget target = (ResteasyWebTarget) client.target(url);
			return target.proxy(TwitchBlocks.class);
		}

	}
}
