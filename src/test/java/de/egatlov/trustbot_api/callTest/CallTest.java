package de.egatlov.trustbot_api.callTest;

import de.egatlov.trustbot_api.twitch.api.APIClient;
import de.egatlov.trustbot_api.twitch.api.TwitchBlocks;

public class CallTest {

	public void test() {
		TwitchBlocks blockApi = APIClient.Build.from(TwitchBlocks.class, "https://api.twitch.tv");
		blockApi.blockUser("OptimusPrime", "Decepticons", "clientId", "accessToken");
	}

	public void test2() {
		TwitchBlocks blockApi = APIClient.Build.from(TwitchBlocks.class);
		blockApi.blockUser("OptimusPrime", "Decepticons", "clientId", "accessToken");
	}

}
