package de.egatlov.trustbot_api.rest.v3.models;

import java.util.List;

public class Emoticon {

	private final String regex;
	private final List<Image> images;
	
	public Emoticon(String regex, List<Image> images) {
		this.regex = regex;
		this.images = images;
	}

	public String regex() {
		return regex;
	}

	public List<Image> images() {
		return images;
	}

}
