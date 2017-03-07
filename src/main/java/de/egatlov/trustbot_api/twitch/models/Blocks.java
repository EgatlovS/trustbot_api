package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Blocks {

	/**
	 * _links
	 */
	private final Links links;
	private final List<Block> blocks;

	public Blocks(Links links, List<Block> blocks) {
		this.links = links;
		this.blocks = blocks;
	}

	public Links links() {
		return links;
	}

	public List<Block> blocks() {
		return blocks;
	}

}
