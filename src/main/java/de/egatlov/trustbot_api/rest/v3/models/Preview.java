package de.egatlov.trustbot_api.rest.v3.models;

public class Preview {

	private final String small;
	private final String medium;
	private final String large;
	private final String template;

	public Preview(String small, String medium, String large, String template) {
		this.small = small;
		this.medium = medium;
		this.large = large;
		this.template = template;
	}

	public String small() {
		return small;
	}

	public String medium() {
		return medium;
	}

	public String large() {
		return large;
	}

	public String template() {
		return template;
	}

}
