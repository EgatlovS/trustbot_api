package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Ingests {

	/**
	 * _links
	 */
	private final Links links;
	private final List<Ingest> ingests;

	public Ingests(Links links, List<Ingest> ingests) {
		this.links = links;
		this.ingests = ingests;
	}

	public Links links() {
		return links;
	}

	public List<Ingest> ingests() {
		return ingests;
	}

}
