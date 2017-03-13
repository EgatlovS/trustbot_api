package de.egatlov.trustbot_api.rest.v3.models;

import java.util.List;

public class Emoticons {

	/**
	 * _links
	 */
	private final Links links;
	private final List<Emoticon> emoticons;
	
	public Emoticons(Links links, List<Emoticon> emoticons) {
		this.links = links;
		this.emoticons = emoticons;
	}

	public Links links() {
		return links;
	}

	public List<Emoticon> emoticons() {
		return emoticons;
	}
	
	
}
