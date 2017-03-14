package de.egatlov.trustbot_api.rest.v5.models.games;

import java.util.List;

public class Games {

	/**
	 * _total
	 */
	private final Long total;
	/**
	 * top
	 */
	private final List<Top> tops;

	public Games(Long total, List<Top> tops) {
		this.total = total;
		this.tops = tops;
	}

	public Long total() {
		return total;
	}

	public List<Top> tops() {
		return tops;
	}

}
