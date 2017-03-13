package de.egatlov.trustbot_api.rest.v3.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import de.egatlov.trustbot_api.rest.v3.models.Ingests;

public interface IngestsAPI extends TwitchAPI {

	/**
	 * Get ingests.
	 * 
	 * @return Returns ingests or a {@code 503 Service Unavailable} if
	 *         error retrieving ingest status.
	 */
	@GET
	@Path("/ingests")
	Ingests getIngests();

}
