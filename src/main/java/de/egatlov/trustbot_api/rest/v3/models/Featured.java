package de.egatlov.trustbot_api.rest.v3.models;

public class Featured {

	private final String image;
	private final String text;
	private final String title;
	private final Boolean sponsored;
	private final Boolean scheduled;
	private final Stream stream;

	public Featured(String image, String text, String title, Boolean sponsored, Boolean scheduled, Stream stream) {
		this.image = image;
		this.text = text;
		this.title = title;
		this.sponsored = sponsored;
		this.scheduled = scheduled;
		this.stream = stream;
	}

	public String image() {
		return image;
	}

	public String text() {
		return text;
	}

	public String title() {
		return title;
	}

	public Boolean sponsored() {
		return sponsored;
	}

	public Boolean scheduled() {
		return scheduled;
	}

	public Stream stream() {
		return stream;
	}

}
