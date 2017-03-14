package de.egatlov.trustbot_api.rest.v5.resources.channelfeed.requests;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.posts.Posts;

/**
 * <h1>GetPostsRequest</h1> </br>
 *
 * Gets posts from a specified channel feed. </br>
 * If authentication is provided, the user_ids array </br>
 * in the response body contains the requesting user’s ID, </br>
 * if they have reacted to a post. </br>
 * 
 * <h2>Example Request:</h2> </br>
 * <b>This gets the most recent post from channel feed "44322889".</b></br>
 * curl -H 'Accept: application/vnd.twitchtv.v5+json' \ </br>
 * -H 'Client-ID: uo6dggojyb8d6soh92zknwmi5ej1q2' \ </br>
 * -H 'Authorization: OAuth cfabdegwdoklmawdzdo98xt2fo512y' \ </br>
 * -X GET 'https://api.twitch.tv/kraken/feed/44322889/posts?limit=1' </br>
 * </br>
 * <h3>Created at: 13-03-2017</h3>
 * 
 * @author egatlov
 */
public final class GetPostsRequest extends Request<Posts> {

	private final Long channelId;
	private final MultivaluedMap<String, Object> queryParams;
	private final MultivaluedMap<String, Object> headers;

	/**
	 * Required params from this request need to be provided!
	 * 
	 * @param channelId
	 *            - the ID of the channel.
	 * @param requestFilters
	 *            - Add additional headers to provide for example versioning and
	 *            client-id
	 */
	public GetPostsRequest(Long channelId, ClientRequestFilter... requestFilters) {
		super(requestFilters);
		this.channelId = channelId;
		this.headers = new MultivaluedHashMap<>();
		this.queryParams = new MultivaluedHashMap<>();
	}

	@Override
	public Posts execute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilters) {
			client.register(filter);
		}
		ResteasyWebTarget target = client.target("https://api.twitch.tv/kraken/feed/" + channelId + "/posts")
				.queryParams(queryParams);

		Response response = target.request().headers(headers).get();
		Posts posts = response.readEntity(Posts.class);
		response.close();
		return posts;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * Default: 10.</br>
	 * Maximum: 100.</br>
	 * 
	 * @param limit
	 *            - Maximum number of most-recent objects to return.
	 */
	public GetPostsRequest withLimitQueryParam(Long limit) {
		if (limit != null) {
			queryParams.add("limit", limit);
		}
		return this;
	}

	/**
	 * <h1>Optional Query String Parameter.</h1></br>
	 * 
	 * @param cursor
	 *            - Tells the server where to start fetching the next set of
	 *            results in a multi-page response.
	 */
	public GetPostsRequest withCursorQueryParam(String cursor) {
		if (cursor != null) {
			queryParams.add("cursor", cursor);
		}
		return this;
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
	public GetPostsRequest withCommentsQueryParam(Long comments) {
		if (comments != null) {
			queryParams.add("comments", comments);
		}
		return this;
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
	public GetPostsRequest withAuthorizationHeader(String accessToken) {
		if (accessToken != null) {
			headers.add("Authorization", accessToken);
		}
		return this;
	}

}
