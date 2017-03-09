package de.egatlov.trustbot_api.twitch.models;

import java.util.List;

public class Subscriptions {

	/**
	 * _total
	 */
	private final Long total;
	/**
	 * _links
	 */
	private final Links links;
	private final List<Subscription> subscriptions;

	public Subscriptions(Long total, Links links, List<Subscription> subscriptions) {
		this.total = total;
		this.links = links;
		this.subscriptions = subscriptions;
	}

	public Long total() {
		return total;
	}

	public Links links() {
		return links;
	}

	public List<Subscription> subscriptions() {
		return subscriptions;
	}

}
