package de.egatlov.trustbot_api.rest.v3.models;

public class StreamContainer {

	/**
	 * _links
	 */
	private final Links links;
	private final Stream stream;

	public StreamContainer(Links links, Stream stream) {
		this.links = links;
		this.stream = stream;
	}

	public Links links() {
		return links;
	}

	public Stream stream() {
		return stream;
	}

}
