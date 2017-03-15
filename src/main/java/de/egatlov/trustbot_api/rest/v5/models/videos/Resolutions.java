package de.egatlov.trustbot_api.rest.v5.models.videos;

public class Resolutions {

	/**
	 * 1080p
	 */
	private final Float p1080;
	/**
	 * 144p
	 */
	private final Float p144;
	/**
	 * 240p
	 */
	private final Float p240;
	/**
	 * 360p
	 */
	private final Float p360;
	/**
	 * 480p
	 */
	private final Float p480;
	/**
	 * 720p
	 */
	private final Float p720;

	public Resolutions(Float p1080, Float p144, Float p240, Float p360, Float p480, Float p720) {
		this.p1080 = p1080;
		this.p144 = p144;
		this.p240 = p240;
		this.p360 = p360;
		this.p480 = p480;
		this.p720 = p720;
	}

	public Float p1080() {
		return p1080;
	}

	public Float p144() {
		return p144;
	}

	public Float p240() {
		return p240;
	}

	public Float p360() {
		return p360;
	}

	public Float p480() {
		return p480;
	}

	public Float p720() {
		return p720;
	}

}
