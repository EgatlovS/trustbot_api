package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.twitch.models.Video;
import de.egatlov.trustbot_api.twitch.models.Videos;

public interface VideosAPI extends TwitchAPI {

	/**
	 * Get a video.
	 * 
	 * @param id
	 *            - the video id.
	 * @return Returns a video.
	 */
	@GET
	@Path("/videos/{id}")
	Video getVideo(@PathParam("id") String id);

	/**
	 * Get videos created in a given time period sorted by number of views, most
	 * popular first.
	 * 
	 * @param limit
	 *            - Maximum number of objects in array. Default is 10. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param game
	 *            - Returns only videos from game.
	 * @param period
	 *            - Returns only videos created in time period. Valid values are
	 *            week, month, or all. Default is week.
	 * @return Returns videos.
	 */
	@GET
	@Path("/videos/top")
	Videos getTopVideos(@DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset, @QueryParam("game") String game,
			@DefaultValue("week") @QueryParam("period") String period);

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
