package de.egatlov.trustbot_api.rest.v3.models;

import java.util.List;

public class Reactions {

	private final Endorse endorse;
	private final List<Reaction> reactions;

	public Reactions(Endorse endorse, List<Reaction> reactions) {
		this.endorse = endorse;
		this.reactions = reactions;
	}

	public Endorse endorse() {
		return endorse;
	}

	public List<Reaction> reactions() {
		return reactions;
	}

}
