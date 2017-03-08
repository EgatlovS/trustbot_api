package de.egatlov.trustbot_api.twitch.models;

public class Ingest {

	private final String name;
	/**
	 * default
	 */
	private final Boolean isDefault;
	/**
	 * _id
	 */
	private final Long id;
	/**
	 * url_template
	 */
	private final String urlTemplate;
	private final Double availability;

	public Ingest(String name, Boolean isDefault, Long id, String urlTemplate, Double availability) {
		this.name = name;
		this.isDefault = isDefault;
		this.id = id;
		this.urlTemplate = urlTemplate;
		this.availability = availability;
	}

	public String name() {
		return name;
	}

	public Boolean isDefault() {
		return isDefault;
	}

	public Long getId() {
		return id;
	}

	public String urlTemplate() {
		return urlTemplate;
	}

	public Double availability() {
		return availability;
	}

}
