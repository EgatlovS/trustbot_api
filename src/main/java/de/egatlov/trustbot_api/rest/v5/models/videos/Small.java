package de.egatlov.trustbot_api.rest.v5.models.videos;

public class Small {

	private final String type;
	private final String url;

	public Small(String type, String url) {
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
