package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import de.egatlov.trustbot_api.twitch.models.Channel;
import de.egatlov.trustbot_api.twitch.models.ChannelChange;
import de.egatlov.trustbot_api.twitch.models.Follows;
import de.egatlov.trustbot_api.twitch.models.Teams;
import de.egatlov.trustbot_api.twitch.models.Users;
import de.egatlov.trustbot_api.twitch.models.Videos;

public interface ChannelsAPI extends TwitchAPI {

	/**
	 * Get a channel.
	 * 
	 * @param channel
	 *            - the channelname
	 * @return Returns a channel.
	 */
	@GET
	@Path("/channels/{channel}")
	Channel getChannel(@PathParam("channel") String channel);

	/**
	 * Get a channel of the authenticated user. Channel object includes a
	 * stream key.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a channel.
	 */
	@GET
	@Path("/channel/{channel}")
	Channel getChannelFromAuthenticatedUser(@PathParam("channel") String channel,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Get videos ordered by time of creation, starting with the most recent
	 * from {@code :channel}.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param limit
	 *            - Maximum number of objects in array. Default is 10. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param broadcasts
	 *            - Returns only broadcasts when true. Otherwise only highlights
	 *            are returned. Default is false.
	 * @param hls
	 *            - If set to true, only returns streams using HLS. If set to
	 *            false, only returns streams that are non-HLS. - Returns only
	 *            HLS VoDs when true. Otherwise only non-HLS VoDs are returned.
	 *            Default is false.
	 * @return Returns videos.
	 */
	@GET
	@Path("/channels/{channel}/videos")
	Videos getVideoFromChannel(@PathParam("channel") String channel, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset,
			@DefaultValue("false") @QueryParam("broadcasts") boolean broadcasts,
			@DefaultValue("false") @QueryParam("hls") boolean hls);

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
	Follows getFollowsFromChannel(@PathParam("channel") String channel,
			@DefaultValue("25") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset,
			@QueryParam("cursor") String cursor, @DefaultValue("desc") @QueryParam("direction") String direction);

	/**
	 * Get users who are editors of {@code :channel}.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns users who are editors.
	 */
	@GET
	@Path("/channels/{channel}/editors")
	Users getEditorsFromChannel(@PathParam("channel") String channel, @HeaderParam("Authorization") String accessToken);

	/**
	 * Update channel's properties.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param payload
	 *            - { "channel": { "status": "Playing cool new game!", "game":
	 *            "Diablo", "delay": 60, "channel_feed_enabled": false } } -
	 *            status is optional: the Channel's title. - game is optional:
	 *            the Game category to be classified as. - delay is optional:
	 *            the Channel delay in seconds. Requires the channel owner's
	 *            OAuth token. - channel_feed_enabled is optional: the Whether
	 *            the channel's feed is enabled. Requires the channel owner's
	 *            OAuth token.
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns the channel updated or {@code 422 Unprocessable Entity}
	 *         if trying to set delay for a channel that is not partnered.
	 */
	@PUT
	@Path("/channels/{channel}")
	Channel updateChannel(@PathParam("channel") String channel, ChannelChange payload,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Resets channel's stream key.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns the channel.
	 */
	@DELETE
	@Path("/channels/{channel}/stream_key")
	Channel resetStreamKey(@PathParam("channel") String channel, @HeaderParam("Authorization") String accessToken);

	/**
	 * Start commercial on channel with the specified {@code length}.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param length
	 *            - Length of commercial break in seconds. Default value is 30.
	 *            Valid values are 30, 60, 90, 120, 150, and 180. You can only
	 *            trigger a commercial once every 8 minutes.
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return {@code 204 No Content} if successful.
	 *         {@code 422 Unprocessable Entity} if commercial length not
	 *         allowed, a commercial was ran less than 8 minutes ago, or the
	 *         channel is not partnered.
	 */
	@POST
	@Path("/channels/{channel}/commercial")
	Response startCommercial(@PathParam("channel") String channel, int length,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Returns teams {@code :channel} belongs to.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns teams {@code :channel} belongs to.
	 */
	@GET
	@Path("/channels/{channel}/teams")
	Teams getChannelTeams(@PathParam("channel") String channel, @HeaderParam("Authorization") String accessToken);

}
