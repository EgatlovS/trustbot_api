package de.egatlov.trustbot_api.rest.v3.models;

import java.util.List;

public class Featureds {

	/**
	 * _links
	 */
	private final Links links;
	private final List<Featured> featured;

	public Featureds(Links links, List<Featured> featured) {
		this.links = links;
		this.featured = featured;
	}

	public Links getLinks() {
		return links;
	}

	public List<Featured> getFeatured() {
		return featured;
	}

}
