package de.egatlov.trustbot_api.rest.v5.models.collections;

public class Thumbnails {

	private final String large;
	private final String medium;
	private final String small;
	private final String template;

	public Thumbnails(String large, String medium, String small, String template) {
		this.large = large;
		this.medium = medium;
		this.small = small;
		this.template = template;
	}

	public String large() {
		return large;
	}

	public String medium() {
		return medium;
	}

	public String small() {
		return small;
	}

	public String template() {
		return template;
	}

}
