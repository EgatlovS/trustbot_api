package de.egatlov.trustbot_api.rest.v3.models;

public class CurrentStreamsSummary {

	private final Long viewers;
	/**
	 * _links
	 */
	private final Links links;
	private final Long channels;

	public CurrentStreamsSummary(Long viewers, Links links, Long channels) {
		this.viewers = viewers;
		this.links = links;
		this.channels = channels;
	}

	public Long viewers() {
		return viewers;
	}

	public Links links() {
		return links;
	}

	public Long channels() {
		return channels;
	}

}
