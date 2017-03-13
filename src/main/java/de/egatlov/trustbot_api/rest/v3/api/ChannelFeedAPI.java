package de.egatlov.trustbot_api.rest.v3.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.rest.v3.models.Post;
import de.egatlov.trustbot_api.rest.v3.models.Posts;
import de.egatlov.trustbot_api.rest.v3.models.Reaction;

public interface ChannelFeedAPI extends TwitchAPI {

	/**
	 * Get posts that belong to the channel's feed. Uses limit and cursor
	 * pagination.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param limit
	 *            - Maximum number of objects in array. Default is 10. Maximum
	 *            is 100.
	 * @param cursor
	 *            - Cursor value to begin next page.
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns posts.
	 */
	@GET
	@Path("/feed/{channel}/posts")
	Posts getPosts(@PathParam("channel") long channel, @DefaultValue("10") @QueryParam("limit") int limit,
			@QueryParam("cursor") int cursor, @HeaderParam("Authorization") String accessToken);

	/**
	 * Create a post for a channel's feed.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param content
	 *            - Content of the post
	 * @param share
	 *            - When set to true, shares the post, with a link to the post
	 *            URL, on the channel's Twitter if it's connected.
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns the post created.
	 */
	@POST
	@Path("/feed/{channel}/posts")
	Post createPost(@PathParam("channel") String channel, String content, @QueryParam("share") boolean share,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Get a specific post belonging to the channel.
	 * 
	 * @param id
	 *            - ID of the specific post
	 * @param channel
	 *            - the channelname
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a post.
	 */
	@GET
	@Path("/feed/{channel}/posts/{id}")
	Post getPost(@PathParam("id") long id, @PathParam("channel") String channel,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Delete a post.
	 * 
	 * @param id
	 *            - ID of the specific post
	 * @param channel
	 *            - the channelname
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 */
	@DELETE
	@Path("/feed/{channel}/posts/{id}")
	void deletePost(@PathParam("id") long id, @PathParam("channel") String channel,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Create a reaction to a post.
	 * 
	 * @param id
	 *            - ID of the specific post
	 * @param channel
	 *            - the channelname
	 * @param emoteId
	 *            - Single emote id (ex: "25" => Kappa) or the string "endorse"
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns the reaction created.
	 */
	@POST
	@Path("/feed/{channel}/posts/{id}/reactions")
	Reaction createReaction(@PathParam("id") long id, @PathParam("channel") String channel,
			@QueryParam("emote_id") String emoteId, @HeaderParam("Authorization") String accessToken);

	/**
	 * Delete a reaction to a post.
	 * 
	 * @param id
	 *            - ID of the specific post
	 * @param channel
	 *            - the channelname
	 * @param emoteId
	 *            - Single emote id (ex: "25" => Kappa) or the string "endorse"
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 */
	@DELETE
	@Path("/feed/{channel}/posts/{id}/reactions")
	void deleteReaction(@PathParam("id") long id, @PathParam("channel") String channel,
			@QueryParam("emote_id") String emoteId, @HeaderParam("Authorization") String accessToken);

}
