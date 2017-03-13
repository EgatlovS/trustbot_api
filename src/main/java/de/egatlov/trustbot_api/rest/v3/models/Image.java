package de.egatlov.trustbot_api.rest.v3.models;

public class Image {

	/**
	 * emoticon_set
	 */
	private final Integer emoticonSet;
	private final Integer height;
	private final Integer width;
	private final String url;

	public Image(Integer emoticonSet, Integer height, Integer width, String url) {
		this.emoticonSet = emoticonSet;
		this.height = height;
		this.width = width;
		this.url = url;
	}

	public Integer emoticonSet() {
		return emoticonSet;
	}

	public Integer height() {
		return height;
	}

	public Integer width() {
		return width;
	}

	public String url() {
		return url;
	}

}
