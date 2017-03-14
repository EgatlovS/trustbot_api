package de.egatlov.trustbot_api.rest.v5.api.request;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.ClientRequestFilter;

public abstract class Request<T> {

	protected final List<ClientRequestFilter> requestFilters;

	public Request(ClientRequestFilter... requestFilters) {
		this.requestFilters = Arrays.asList(requestFilters);
	}

	abstract public T execute();

}
