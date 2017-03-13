package de.egatlov.trustbot_api.rest.v5.client.call;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.ClientRequestFilter;

public abstract class Call<T> {

	protected final List<ClientRequestFilter> requestFilters;

	public Call(ClientRequestFilter... requestFilters) {
		this.requestFilters = Arrays.asList(requestFilters);
	}

	abstract public T execute();

}
