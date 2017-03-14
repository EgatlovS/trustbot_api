package de.egatlov.trustbot_api.rest.v5.models.communities;

public class Community {

	/**
	 * _id
	 */
	private final String id;
	/**
	 * avatar_image_url
	 */
	private final String avatarImageUrl;
	/**
	 * cover_image_url
	 */
	private final String coverImageUrl;
	private final String description;
	/**
	 * description_html
	 */
	private final String descriptionHtml;
	private final String language;
	private final String name;
	/**
	 * owner_id
	 */
	private final String ownerId;
	private final String rules;
	/**
	 * rules_html
	 */
	private final String rulesHtml;
	private final String summary;

	public Community(String id, String avatarImageUrl, String coverImageUrl, String description, String descriptionHtml,
			String language, String name, String ownerId, String rules, String rulesHtml, String summary) {
		this.id = id;
		this.avatarImageUrl = avatarImageUrl;
		this.coverImageUrl = coverImageUrl;
		this.description = description;
		this.descriptionHtml = descriptionHtml;
		this.language = language;
		this.name = name;
		this.ownerId = ownerId;
		this.rules = rules;
		this.rulesHtml = rulesHtml;
		this.summary = summary;
	}

	public String id() {
		return id;
	}

	public String avatarImageUrl() {
		return avatarImageUrl;
	}

	public String coverImageUrl() {
		return coverImageUrl;
	}

	public String description() {
		return description;
	}

	public String descriptionHtml() {
		return descriptionHtml;
	}

	public String language() {
		return language;
	}

	public String name() {
		return name;
	}

	public String ownerId() {
		return ownerId;
	}

	public String rules() {
		return rules;
	}

	public String rulesHtml() {
		return rulesHtml;
	}

	public String summary() {
		return summary;
	}

}
