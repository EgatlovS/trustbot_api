package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.twitch.models.Channel;
import de.egatlov.trustbot_api.twitch.models.ChannelChange;
import de.egatlov.trustbot_api.twitch.models.Follows;
import de.egatlov.trustbot_api.twitch.models.Teams;
import de.egatlov.trustbot_api.twitch.models.Users;
import de.egatlov.trustbot_api.twitch.models.Videos;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/kraken")
public interface TwitchChannels {

	/**
	 * Get a channel Object.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @return Returns a channel object.
	 */
	@GET
	@Path("/channels/{channel}")
	Channel getChannel(@PathParam("channel") String channel, @HeaderParam("Client-ID: ") String clientId);

	/**
	 * Get a channel object of the authenticated user. Channel object includes a
	 * stream key.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a channel object of authenticated user. Channel object
	 *         includes stream key.
	 */
	@GET
	@Path("/channel/{channel}")
	Channel getChannelFromAuthenticatedUser(@PathParam("channel") String channel,
			@HeaderParam("Client-ID: ") String clientId, @HeaderParam("Authorization: OAuth ") String accessToken);

	/**
	 * Get a list of videos ordered by time of creation, starting with the most
	 * recent from :channel.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param limit
	 *            - Maximum number of objects in array. Default is 10. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param broadcasts
	 *            - Returns only broadcasts when true. Otherwise only highlights
	 *            are returned. Default is false.
	 * @param hls
	 *            - Returns only HLS VoDs when true. Otherwise only non-HLS VoDs
	 *            are returned. Default is false.
	 * @return Returns a list of videos.
	 */
	@GET
	@Path("/channels/{channel}/videos")
	Videos getVideoFromChannel(@PathParam("channel") String channel, @HeaderParam("Client-ID: ") String clientId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset,
			@DefaultValue("false") @QueryParam("broadcasts") boolean broadcasts,
			@DefaultValue("false") @QueryParam("hls") boolean hls);

	/**
	 * Get a list of follow objects.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
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
	 * @return Returns a list of follow objects.
	 */
	@GET
	@Path("/channels/{channel}/follows")
	Follows getFollowsFromChannel(@PathParam("channel") String channel, @HeaderParam("Client-ID: ") String clientId,
			@DefaultValue("25") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset,
			@QueryParam("cursor") String cursor, @DefaultValue("desc") @QueryParam("direction") String direction);

	/**
	 * Get a list of user objects who are editors of :channel.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a list of user objects who are editors.
	 */
	@GET
	@Path("/channels/{channel}/editors")
	Users getEditorsFromChannel(@PathParam("channel") String channel, @HeaderParam("Client-ID: ") String clientId,
			@HeaderParam("Authorization: OAuth ") String accessToken);

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
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns the Channel updated or 422 Unprocessable Entity if trying
	 *         to set delay for a channel that is not partnered.
	 */
	@PUT
	@Path("/channels/{channel}")
	Channel updateChannel(@PathParam("channel") String channel, ChannelChange payload,
			@HeaderParam("Client-ID: ") String clientId, @HeaderParam("Authorization: OAuth ") String accessToken);

	/**
	 * Resets channel's stream key.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns the channel with reseted streamKey.
	 */
	@DELETE
	@Path("/channels/{channel}/stream_key")
	Channel resetStreamKey(@PathParam("channel") String channel, @HeaderParam("Client-ID: ") String clientId,
			@HeaderParam("Authorization: OAuth ") String accessToken);

	/**
	 * Start commercial on channel with the specified {@code length}.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param length
	 *            - Length of commercial break in seconds. Default value is 30.
	 *            Valid values are 30, 60, 90, 120, 150, and 180. You can only
	 *            trigger a commercial once every 8 minutes.
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return 204 No Content if successful. 422 Unprocessable Entity if
	 *         commercial length not allowed, a commercial was ran less than 8
	 *         minutes ago, or the channel is not partnered.
	 */
	@POST
	@Path("/channels/{channel}/commercial")
	Response startCommercial(@PathParam("channel") String channel, int length,
			@HeaderParam("Client-ID: ") String clientId, @HeaderParam("Authorization: OAuth ") String accessToken);

	/**
	 * Returns a list of team objects :channel belongs to.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param clientId
	 *            - the clientid you get if you registrate your program on
	 *            twitch
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a list of team objects :channel belongs to.
	 */
	@GET
	@Path("/channels/{channel}/teams")
	Teams getChannelTeams(@PathParam("channel") String channel, @HeaderParam("Client-ID: ") String clientId,
			@HeaderParam("Authorization: OAuth ") String accessToken);

	class APIClient {

		public static TwitchChannels newClient() {
			Client client = ClientBuilder.newClient();
			String url = "https://api.twitch.tv";
			ResteasyWebTarget target = (ResteasyWebTarget) client.target(url);
			return target.proxy(TwitchChannels.class);
		}

	}

}
