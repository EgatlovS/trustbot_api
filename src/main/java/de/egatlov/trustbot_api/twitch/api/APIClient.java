package de.egatlov.trustbot_api.twitch.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 * APIClient.java produces clients from there REST-Definition-Interface.
 * 
 * Created at: 01.03.2017
 * 
 * @author egatlov
 */
public final class APIClient {

	public static <T extends TwitchAPI> T buildFrom(Class<T> clazz) {
		return buildFrom(clazz, "https://api.twitch.tv");
	}

	public static <T extends TwitchAPI> T buildFrom(Class<T> clazz, String url) {
		Client client = ClientBuilder.newClient();
		ResteasyWebTarget target = (ResteasyWebTarget) client.target(url);
		return target.proxy(clazz);
	}

}
