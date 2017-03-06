package de.egatlov.trustbot_api.twitch.api.client;

import javax.ws.rs.client.ClientRequestFilter;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import de.egatlov.trustbot_api.twitch.api.TwitchAPI;

/**
 * APIClient.java produces clients from there REST-Definition-Interface.
 * 
 * Created at: 01.03.2017
 * 
 * @author egatlov
 */
public final class APIClient {

	public static <T extends TwitchAPI> T buildFrom(Class<T> clazz, ClientRequestFilter... requestFilter) {
		return buildFrom(clazz, "https://api.twitch.tv", requestFilter);
	}

	public static <T extends TwitchAPI> T buildFrom(Class<T> clazz, String url, ClientRequestFilter... requestFilter) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		for (ClientRequestFilter filter : requestFilter) {
			client.register(filter);
		}
		return client.target(url).proxy(clazz);
	}

}
