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

import de.egatlov.trustbot_api.twitch.models.Follow;
import de.egatlov.trustbot_api.twitch.models.Follows;
import de.egatlov.trustbot_api.twitch.models.Streams;

public interface FollowsAPI extends TwitchAPI {

	/**
	 * Get follows.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - (deprecated) Object offset for pagination. Default is 0.
	 *            Maximum is 1600.
	 * @param cursor
	 *            - Twitch uses cursoring to paginate long lists of followers.
	 *            Check _cursor in response body and set cursor to this value to
	 *            get the next page of results, or use _links.next to navigate
	 *            to the next page of results.
	 * @param direction
	 *            - Creation date sorting direction. Default is desc. Valid
	 *            values are asc and desc.
	 * @return Returns follows.
	 */
	@GET
	@Path("/channels/{channel}/follows")
	Follows getUsersFollowings(@PathParam("channel") String channel, @DefaultValue("25") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset, @QueryParam("cursor") int cursor,
			@DefaultValue("desc") @QueryParam("direction") String direction);

	/**
	 * Get follows.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param sortKey
	 *            - Sort key. Default is created_at. Valid values are
	 *            created_at, last_broadcast, and login.
	 * @param direction
	 *            - Sorting direction. Default is desc. Valid values are asc and
	 *            desc.
	 * @return Returns follows or a {@code 404 Not Found} if
	 *         {@code user} does not exist.
	 */
	@GET
	@Path("/users/{user}/follows/channels")
	Follows getUsersFollows(@PathParam("user") String username, @DefaultValue("25") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset,
			@DefaultValue("created_at") @QueryParam("sortby") String sortKey,
			@DefaultValue("desc") @QueryParam("direction") String direction);

	/**
	 * Get a follow.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param targetChannel
	 *            - the target channel name.
	 * @return Returns a follow or a {@code 404 Not Found} if
	 *         {@code user} is not following {@code target} otherwise.
	 */
	@GET
	@Path("/users/{user}/follows/channels/{target}")
	Follow getUsersFollow(@PathParam("user") String username, @PathParam("target") String targetChannel);

	/**
	 * Adds {@code user} to {@code target}'s followers. {@code user} is the
	 * authenticated user's name and {@code target} is the name of the channel
	 * to be followed.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param targetChannel
	 *            - the target channel name.
	 * @param notifications
	 *            - Whether {@code user} should receive email/push
	 *            notifications (depending on their notification settings) when
	 *            {@code target} goes live. Default is false.
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a follow or a {@code 422 Unprocessable Entity} if
	 *         update fails.
	 */
	@PUT
	@Path("/users/{user}/follows/channels/{target}")
	Follow follow(@PathParam("user") String username, @PathParam("target") String targetChannel,
			@DefaultValue("false") @QueryParam("notifications") boolean notifications,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Removes {@code user} from {@code target}'s followers. {@code user} is
	 * the authenticated user's name and {@code target} is the name of the
	 * channel to be unfollowed.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param targetChannel
	 *            - the target channel name.
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a {@code 204 No Content} if successful or a
	 *         {@code 422 Unprocessable Entity} if delete fails.
	 */
	@DELETE
	@Path("/users/{user}/follows/channels/{target}")
	Response unfollow(@PathParam("user") String username, @PathParam("target") String targetChannel,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Get streams that the authenticated user is following.
	 * 
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param streamType
	 *            - Only shows streams from a certain type. Permitted values:
	 *            all, playlist, live
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns streams.
	 */
	@GET
	@Path("/streams/followed")
	Streams getStreamsFromUser(@DefaultValue("25") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset, @QueryParam("stream_type") String streamType,
			@HeaderParam("Authorization") String accessToken);

}
