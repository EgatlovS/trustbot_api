package de.egatlov.trustbot_api.rest.v3.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.rest.v3.models.Emoticons;
import de.egatlov.trustbot_api.rest.v3.models.Streams;
import de.egatlov.trustbot_api.rest.v3.models.User;
import de.egatlov.trustbot_api.rest.v3.models.Videos;

public interface UsersAPI extends TwitchAPI {

	/**
	 * Get a user.
	 * 
	 * @param username
	 *            - your twitch username
	 * @return Returns a user.
	 */
	@GET
	@Path("/users/{user}")
	User getUserByName(@PathParam("user") String username);

	/**
	 * Get emoticons that the user is authorized to use.
	 * 
	 * @param username
	 *            - your twitch username
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns emoticons.
	 */
	@GET
	@Path("/users/{user}/emotes")
	Emoticons getAuthorizedEmoticons(@PathParam("user") String username,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Get a user.
	 * 
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a user or if the user's registered Email Address
	 *         is not verified, null.
	 */
	@GET
	@Path("/user")
	User getUser(@HeaderParam("Authorization") String accessToken);

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

	/**
	 * Get videos from channels that the authenticated user is following.
	 * 
	 * @param limit
	 *            - Maximum number of objects in array. Default is 10. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param broadcastType
	 *            - Only shows videos of a certain type. Supported values: all,
	 *            archive, highlight. Default: all.
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns videos.
	 */
	@GET
	@Path("/videos/followed")
	Videos getVideosFromFollowedChannels(@DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset,
			@DefaultValue("all") @QueryParam("broadcast_type") String broadcastType,
			@HeaderParam("Authorization") String accessToken);

}
