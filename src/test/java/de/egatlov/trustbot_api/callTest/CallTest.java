package de.egatlov.trustbot_api.callTest;

import de.egatlov.trustbot_api.twitch.api.BlocksAPI;
import de.egatlov.trustbot_api.twitch.api.client.APIClient;
import de.egatlov.trustbot_api.twitch.api.client.filter.ClientIDRequestFilter;

public class CallTest {

	public void test() {
		BlocksAPI blockApi = APIClient.buildFrom(BlocksAPI.class, "https://api.twitch.tv");
		blockApi.blockUser("OptimusPrime", "Decepticons", "accessToken");
	}

	public void test2() {
		BlocksAPI blockApi = APIClient.buildFrom(BlocksAPI.class);
		blockApi.blockUser("OptimusPrime", "Decepticons", "accessToken");
	}

	public void recommended() {
		BlocksAPI blockApi = APIClient.buildFrom(BlocksAPI.class, new ClientIDRequestFilter("clientID"));
		blockApi.blockUser("OptimusPrime", "Decepticons", "accessToken");
	}

}
