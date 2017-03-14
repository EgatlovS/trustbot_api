package de.egatlov.trustbot_api.rest.v5.models.ingests;

import java.util.List;

public class Ingests {

	private final List<Ingest> ingests;

	public Ingests(List<Ingest> ingests) {
		this.ingests = ingests;
	}

	public List<Ingest> ingests() {
		return ingests;
	}

}
