package de.egatlov.trustbot_api.rest.v3.models;

import java.util.List;

public class Videos {

	/**
	 * _links
	 */
	private final Links links;
	private final List<Video> videos;

	public Videos(Links links, List<Video> videos) {
		this.links = links;
		this.videos = videos;
	}

	public Links links() {
		return links;
	}

	public List<Video> videos() {
		return videos;
	}

}
