package de.egatlov.trustbot_api.twitch.api;

import java.nio.channels.Channels;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.twitch.models.Games;
import de.egatlov.trustbot_api.twitch.models.Streams;

public interface SearchAPI extends TwitchAPI {

	/**
	 * Get channels matching the search query.
	 * 
	 * @param query
	 *            - A url-encoded search query.
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @return Returns channels or a {@code 503 Service Unavailable} if
	 *         unable to retrieve search results.
	 */
	@GET
	@Path("/search/channels")
	Channels getMatchingChannels(@QueryParam("query") String query, @DefaultValue("25") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("offset") int offset);

	/**
	 * Get streams matching the search query.
	 * 
	 * @param query
	 *            - A url-encoded search query.
	 * @param hls
	 *            - If set to true, only returns streams using HLS. If set to
	 *            false, only returns streams that are non-HLS.
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @return Returns streams or a {@code 503 Service Unavailable} if
	 *         unable to retrieve search results.
	 */
	@GET
	@Path("/search/streams")
	Streams getMatchingStreams(@QueryParam("query") String query, @DefaultValue("false") @QueryParam("hls") boolean hls,
			@DefaultValue("25") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset);

	/**
	 * Get games matching the search query.
	 * 
	 * @param query
	 *            - A url-encoded search query.
	 * @param type
	 *            - suggest: Suggests a list of games similar to query, e.g.
	 *            'star' query might suggest 'StarCraft II: Wings of Liberty'.
	 * @param live
	 *            - If true, only returns games that are live on at least one
	 *            channel.
	 * @return Returns games or a {@code 503 Service Unavailable} if
	 *         unable to retrieve search results.
	 */
	@GET
	@Path("/search/games")
	Games getMatchingGames(@QueryParam("query") String query, @QueryParam("type") String type,
			@QueryParam("live") boolean live);
}
