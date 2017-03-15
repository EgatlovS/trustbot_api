package de.egatlov.trustbot_api.rest.v5.models.videos;

import java.util.List;

public class Thumbnails {

	private final List<Large> large;
	private final List<Medium> medium;
	private final List<Small> small;
	private final List<Template> template;

	public Thumbnails(List<Large> large, List<Medium> medium, List<Small> small, List<Template> template) {
		this.large = large;
		this.medium = medium;
		this.small = small;
		this.template = template;
	}

	public List<Large> large() {
		return large;
	}

	public List<Medium> medium() {
		return medium;
	}

	public List<Small> small() {
		return small;
	}

	public List<Template> template() {
		return template;
	}

}
