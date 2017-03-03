package de.egatlov.trustbot_api.twitch.api.client.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class VersionRequestFilter implements ClientRequestFilter {

	private final int version;

	public VersionRequestFilter(int version) {
		this.version = version;
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("Accept", "application/vnd.twitchtv.v" + version + "+json");
	}

}
