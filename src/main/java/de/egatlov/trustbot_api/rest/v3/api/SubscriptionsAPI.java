package de.egatlov.trustbot_api.rest.v3.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.rest.v3.models.Channel;
import de.egatlov.trustbot_api.rest.v3.models.Subscription;
import de.egatlov.trustbot_api.rest.v3.models.Subscriptions;

public interface SubscriptionsAPI extends TwitchAPI {

	/**
	 * Get subscriptions sorted by subscription relationship creation date which
	 * contain users subscribed to {@code channel}.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param limit
	 *            - Maximum number of objects in array. Default is 25. Maximum
	 *            is 100.
	 * @param offset
	 *            - Object offset for pagination. Default is 0.
	 * @param direction
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns subscriptions.
	 */
	@GET
	@Path("/channels/{channel}/subscriptions")
	public Subscriptions getSubscriptions(@PathParam("channel") String channel,
			@DefaultValue("25") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset,
			@DefaultValue("asc") @QueryParam("direction") String direction,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Get a subscription which includes the user if that user is subscribed.
	 * Requires authentication for {@code channel}.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param username
	 *            - your twitch username
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a subscription or a {@code 404 Not Found} if user is not
	 *         subscribed.
	 */
	@GET
	@Path("/channels/{channel}/subscriptions/{user}")
	public Subscription getSubscription(@PathParam("channel") String channel, @PathParam("user") String username,
			@HeaderParam("Authorization") String accessToken);

	/**
	 * Get a channel that user subscribes to. Requires authentication for
	 * {@code user}.
	 * 
	 * @param channel
	 *            - the channelname
	 * @param username
	 *            - your twitch username
	 * @param accessToken
	 *            - an oauth token which you get by implementing the
	 *            twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 * @return Returns a channel, a {@code 404 Not Found} if user is not
	 *         subscribed or a {@code 422 Unprocessable Entity} if channel has
	 *         no subscription program.
	 */
	@GET
	@Path("/users/{user}/subscriptions/{channel}")
	public Channel getChannel(@PathParam("channel") String channel, @PathParam("user") String username,
			@HeaderParam("Authorization") String accessToken);

}
