package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.twitch.models.CurrentStreamsSummary;
import de.egatlov.trustbot_api.twitch.models.Featureds;
import de.egatlov.trustbot_api.twitch.models.Stream;
import de.egatlov.trustbot_api.twitch.models.Streams;

public interface StreamsAPI extends TwitchAPI {

	/**
	 * Get a stream object if live.
	 * 
	 * @return Returns a stream object.
	 */
	@GET
	@Path("/streams/{channel}/")
	Stream getStream();

	/**
	 * Get stream objects that are queried by a number of parameters sorted by
	 * number of viewers descending.
	 * 
	 * @param game
	 *            - Streams categorized under game.
	 * @param channel
	 *            - Streams from a comma separated list of channels.
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param language
	 *            - Only shows streams of a certain language. Permitted values
	 *            are locale ID strings, e.g. `en`, `fi`, `es-mx`.
	 * @param streamType
	 *            - Only shows streams from a certain type. Permitted values:
	 *            all, playlist, live
	 * @return Returns stream objects.
	 */
	@GET
	@Path("/streams")
	Streams getStreams(@QueryParam("game") String game, @QueryParam("channel") String channel,
			@DefaultValue("25") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset,
			@QueryParam("language") String language, @QueryParam("stream_type") String streamType);

	/**
	 * Get featured (promoted) stream objects. Note that the number of promoted
	 * streams varies from day to day, and there is no guarantee on how many
	 * streams will be promoted at a given time.
	 * 
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @return Returns featured objects.
	 */
	@GET
	@Path("/streams/featured")
	Featureds getFeaturedStreams(@DefaultValue("25") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset);

	/**
	 * Get a summary of current streams.
	 * 
	 * @param game
	 *            - Only show stats for the set game
	 * @return Returns a summary of current streams.
	 */
	@GET
	@Path("/streams/summary")
	CurrentStreamsSummary getCurrentStreamsSummary(@QueryParam("game") int game);

	/**
	 * Get stream objects that the authenticated user is following.
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
	 * @return Returns stream objects.
	 */
	@GET
	@Path("/streams/followed")
	Streams getStreamsFromUser(@DefaultValue("25") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset, @QueryParam("stream_type") String streamType,
			@HeaderParam("Authorization") String accessToken);

}
