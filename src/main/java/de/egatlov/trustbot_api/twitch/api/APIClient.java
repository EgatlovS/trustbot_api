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
public interface APIClient {

	class Build {

		public static <T extends TwitchAPI> T from(Class<T> clazz) {
			return from(clazz, "https://api.twitch.tv");
		}

		public static <T extends TwitchAPI> T from(Class<T> clazz, String url) {
			Client client = ClientBuilder.newClient();
			ResteasyWebTarget target = (ResteasyWebTarget) client.target(url);
			return target.proxy(clazz);
		}

	}

}
