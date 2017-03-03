package de.egatlov.trustbot_api.callTest;

import de.egatlov.trustbot_api.twitch.api.APIClient;
import de.egatlov.trustbot_api.twitch.api.BlocksAPI;

public class CallTest {

	public void test() {
		BlocksAPI blockApi = APIClient.buildFrom(BlocksAPI.class, "https://api.twitch.tv");
		blockApi.blockUser("OptimusPrime", "Decepticons", "clientId", "accessToken");
	}

	public void test2() {
		BlocksAPI blockApi = APIClient.buildFrom(BlocksAPI.class);
		blockApi.blockUser("OptimusPrime", "Decepticons", "clientId", "accessToken");
	}

}
