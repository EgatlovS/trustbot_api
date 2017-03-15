package de.egatlov.trustbot_api.rest.v5.models.videos;

public class Medium {

	private final String type;
	private final String url;

	public Medium(String type, String url) {
		this.type = type;
		this.url = url;
	}

	public String type() {
		return type;
	}

	public String url() {
		return url;
	}

}
