package de.egatlov.trustbot_api.rest.v5.client.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class ClientIDRequestFilter implements ClientRequestFilter {

	private final String clientId;

	public ClientIDRequestFilter(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("Client-ID", clientId);
	}

}
