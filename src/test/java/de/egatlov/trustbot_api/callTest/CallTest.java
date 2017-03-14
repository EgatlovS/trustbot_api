package de.egatlov.trustbot_api.callTest;

import de.egatlov.trustbot_api.rest.v5.api.filter.ClientIDRequestFilter;
import de.egatlov.trustbot_api.rest.v5.api.filter.VersionRequestFilter;
import de.egatlov.trustbot_api.rest.v5.api.request.Request;
import de.egatlov.trustbot_api.rest.v5.models.posts.Posts;
import de.egatlov.trustbot_api.rest.v5.resources.channelfeed.ChannelFeedEndpoint;

public class CallTest {

	public void test() {
		ChannelFeedEndpoint feed = new ChannelFeedEndpoint();
		Request<Posts> request = feed
				.getPosts(44322889l, new ClientIDRequestFilter("uo6dggojyb8d6soh92zknwmi5ej1q2"),
						new VersionRequestFilter(5))
				.withLimitQueryParam(1l).withAuthorizationHeader("OAuth cfabdegwdoklmawdzdo98xt2fo512y");
		Posts posts = request.execute();
	}

	public void test2() {
		Posts posts = new ChannelFeedEndpoint().getPosts(44322889l).execute();
	}

}
