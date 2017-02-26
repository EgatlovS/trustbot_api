package de.egatlov.trustbot_api.callTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import de.egatlov.trustbot_api.twitch.api.TwitchBlocks;
import de.egatlov.trustbot_api.twitch.models.Block;

public class CallTest {

	public void test() {
		Client client = ClientBuilder.newClient();
		String url = "https://api.twitch.tv";
		ResteasyWebTarget target = (ResteasyWebTarget) client.target(url);
		TwitchBlocks pojo = target.proxy(TwitchBlocks.class);
		Block result = pojo.blockUser("OptimusPrime", "Decepticons", "clientId", "accessToken");
		System.out.println(result);
	}

}
