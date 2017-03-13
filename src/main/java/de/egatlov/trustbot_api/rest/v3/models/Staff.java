package de.egatlov.trustbot_api.rest.v3.models;

public class Staff {
	
	private final String alpha;
	private final String image;
	private final String svg;

	public Staff(String alpha, String image, String svg) {
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
