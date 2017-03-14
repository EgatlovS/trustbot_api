package de.egatlov.trustbot_api.rest.v5.models.badges;

public class Admin {

	private final String alpha;
	private final String image;
	private final String svg;

	public Admin(String alpha, String image, String svg) {
		this.alpha = alpha;
		this.image = image;
		this.svg = svg;
	}

	public String alpha() {
		return alpha;
	}

	public String image() {
		return image;
	}

	public String svg() {
		return svg;
	}
	
}
