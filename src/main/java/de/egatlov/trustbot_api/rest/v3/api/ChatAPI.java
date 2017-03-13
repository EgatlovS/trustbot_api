package de.egatlov.trustbot_api.rest.v3.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import de.egatlov.trustbot_api.rest.v3.models.Badges;
import de.egatlov.trustbot_api.rest.v3.models.Emoticons;
import de.egatlov.trustbot_api.rest.v3.models.Links;

public interface ChatAPI extends TwitchAPI {

	/**
	 * Get links to all other chat endpoints.
	 * 
	 * @param channel
	 *            - the channelname
	 * @return Returns links.
	 */
	@GET
	@Path("/chat/{channel}")
	Links getOtherChatEndpoints(@PathParam("channel") String channelName);

	/**
	 * Get all emoticons for Twitch.
	 * 
	 * @return Returns emoticons.
	 */
	@GET
	@Path("/chat/emoticons")
	Emoticons getTwitchEmoticons();

	/**
	 * Get emoticons.
	 * 
	 * @param emoteSets
	 *            - Emotes from a comma separated list of emote sets.
	 * @return Returns emoticons.
	 */
	@GET
	@Path("/chat/emoticon_images")
	Emoticons getEmoticons(@QueryParam("emotesets") String emoteSets);

	/**
	 * Get chat badges that can be used in the {@code channel}'s chat.
	 * 
	 * @param channel
	 *            - the channelname
	 * @return Returns badges.
	 */
	@GET
	@Path("/chat/{channel}/badges")
	Badges getChatBadges(@PathParam("channel") String channelName);

}
