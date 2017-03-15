package de.egatlov.trustbot_api.rest.v5.models.videos;

public class MutedSegment {

	private final Long duration;
	private final Long offset;

	public MutedSegment(Long duration, Long offset) {
		this.duration = duration;
		this.offset = offset;
	}

	public Long duration() {
		return duration;
	}

	public Long offset() {
		return offset;
	}

}
