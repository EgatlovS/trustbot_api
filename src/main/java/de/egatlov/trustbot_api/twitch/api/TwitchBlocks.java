package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import de.egatlov.trustbot_api.twitch.models.Block;
import de.egatlov.trustbot_api.twitch.models.Blocks;

@Path("/kraken")
public interface TwitchBlocks {

	@GET
	@Path("/users/{username}/blocks")
	Blocks getBlocks(@PathParam("username") String username, @HeaderParam("Client-ID: ") String clientId,
			@HeaderParam("Authorization: OAuth ") String accessToken);

	@PUT
	@Path("/users/{username}/blocks/{targetUsername}")
	Block blockUser(@PathParam("username") String username, @PathParam("targetUsername") String targetUsername,
			@HeaderParam("Client-ID: ") String clientId, @HeaderParam("Authorization: OAuth ") String accessToken);

	@DELETE
	@Path("/users/{username}/blocks/{targetUsername}")
	void unblockUser(@PathParam("username") String username, @PathParam("targetUsername") String targetUsername,
			@HeaderParam("Client-ID: ") String clientId, @HeaderParam("Authorization: OAuth ") String accessToken);
}
