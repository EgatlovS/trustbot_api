package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import de.egatlov.trustbot_api.twitch.models.Block;
import de.egatlov.trustbot_api.twitch.models.Blocks;

public interface BlocksAPI extends TwitchAPI {

	/**
	 * Returns block objects on {@code :username}'s block list. List sorted by
	 * recency, newest first.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @return Returns block objects on {@code :username}'s block list. List
	 *         sorted by recency, newest first.
	 */
	@GET
	@Path("/users/{username}/blocks")
	Blocks getBlocks(@PathParam("username") String username, @HeaderParam("Authorization") String accessToken,
			@DefaultValue("25") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset);

	/**
	 * Adds {@code :targetUsername} to {@code :username}'s block list.
	 * {@code :username} is the authenticated user and {@code :targetUsername}
	 * is user to be blocked.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param targetUsername
	 *            - the user to block
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a block object.
	 */
	@PUT
	@Path("/users/{username}/blocks/{targetUsername}")
	Block blockUser(@PathParam("username") String username, @PathParam("targetUsername") String targetUsername,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Removes {@code :targetUsername} from {@code :username}'s block list.
	 * {@code :username} is the authenticated user and {@code :targetUsername}
	 * is user to be unblocked.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param targetUsername
	 *            - the user to unblock
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return {@code 204 No Content} if successful. {@code 404 Not Found} if
	 *         {@code :targetUsername} not on {@code :username}'s block list.
	 *         {@code 422 Unprocessable Entity} if delete failed.
	 */
	@DELETE
	@Path("/users/{username}/blocks/{targetUsername}")
	Response unblockUser(@PathParam("username") String username, @PathParam("targetUsername") String targetUsername,
			@HeaderParam("Authorization") String accessToken);

}
