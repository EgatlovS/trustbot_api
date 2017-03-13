package de.egatlov.trustbot_api.rest.v5.resources.channelfeed;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v3.models.Posts;
import de.egatlov.trustbot_api.rest.v5.client.call.Call;

/**
 * <h1>GetFeedPostsCall</h1> </br>
 *
 * Gets posts from a specified channel feed. </br>
 * If authentication is provided, the user_ids array </br>
 * in the response body contains the requesting user’s ID, </br>
 * if they have reacted to a post. </br>
 * 
 * <h2>Example call:</h2> </br>
 * This gets the most recent post from channel feed 44322889.</br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \ </br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \ </br>
 * -H 'Authorization: OAuth cfabdegwdoklmawdzdo98xt2fo512y' \ </br>
 * -X GET 'https://api.twitch.tv/kraken/feed/44322889/posts?limit=1' </br>
 * </br>
 * <h3>Created at: 13-03-2017</h3>
 * 
 * @author egatlov
 */
public final class GetPostsCall extends Call<Posts> {

	/**
	 * required pathparam
	 */
	private final Long channelId;
	/**
	 * Maximum number of most-recent objects to return. Default: 10. Maximum:
	 * 100.
	 */
	private Long limit;
	/**
	 * Tells the server where to start fetching the next set of results in a
	 * multi-page response.
	 */
	private String cursor;
	/**
	 * Specifies the number of most-recent comments on posts that are included
	 * in the response. Default: 5. Maximum: 5.
	 */
	private Long comments;
	/**
	 * an oauth token which you get by implementing the twitch-oauth-api or just
	 * get it from http://twitchapps.com/tmi/
	 */
	private String accessToken;

	/**
	 * @param channelId
	 *            - the ID of the channel.
	 */
	public GetPostsCall(Long channelId, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.channelId = channelId;
	}

	@Override
	public Posts execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/feed/" + channelId + "/posts")
				.queryParams(queryParams());

		Response response = target.request().headers(headers()).get();
		Posts posts = response.readEntity(Posts.class);
		response.close();
		return posts;
	}

	private MultivaluedMap<String, Object> queryParams() {
		MultivaluedMap<String, Object> map = new MultivaluedHashMap<>();
		if (limit != null) {
			map.add("limit", limit);
		}
		if (cursor != null) {
			map.add("cursor", cursor);
		}
		if (comments != null) {
			map.add("comments", comments);
		}
		return map;
	}

	private MultivaluedMap<String, Object> headers() {
		MultivaluedMap<String, Object> map = new MultivaluedHashMap<>();
		if (accessToken != null) {
			map.add("Authorization", accessToken);
		}
		return map;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: 10.</br>
	 * Maximum: 100.</br>
	 * 
	 * @param limit
	 *            - Maximum number of most-recent objects to return.
	 */
	public void setLimit(Long limit) {
		this.limit = limit;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * 
	 * @param cursor
	 *            - Tells the server where to start fetching the next set of
	 *            results in a multi-page response.
	 */
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: 5.</br>
	 * Maximum: 5.</br>
	 * 
	 * @param comments
	 *            - Specifies the number of most-recent comments on posts that
	 *            are included in the response.
	 */
	public void setComments(Long comments) {
		this.comments = comments;
	}

	/**
	 * <h1>Optional Header Parameter.</h1></br>
	 * If authentication is provided, the user_ids array in the response body
	 * contains the requesting user’s ID, if they have reacted to a post.
	 * 
	 * @param accessToken
	 *            - accessToken - an oauth token which you get by implementing
	 *            the twitch-oauth-api or just get it from
	 *            http://twitchapps.com/tmi/
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
