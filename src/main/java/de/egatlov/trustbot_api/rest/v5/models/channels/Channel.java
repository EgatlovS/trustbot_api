package de.egatlov.trustbot_api.rest.v5.models.channels;

import java.util.Date;

public class Channel {

	/**
	 * _id
	 */
	private final Long id;
	/**
	 * broadcaster_language
	 */
	private final String broadcasterLanguage;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * display_name
	 */
	private final String displayName;
	private final String email;
	private final Long followers;
	private final String game;
	private final String language;
	private final String logo;
	private final Boolean mature;
	private final String name;
	private final Boolean partner;
	/**
	 * profile_banner
	 */
	private final String profileBanner;
	/**
	 * profile_banner_background_color
	 */
	private final String profileBannerBackgroundColor;
	private final String status;
	/**
	 * stream_key
	 */
	private final String streamKey;
	/**
	 * updated_at
	 */
	private final Date updatedAt;
	private final String url;
	/**
	 * video_banner
	 */
	private final String videoBanner;
	private final Long views;

	public Channel(Long id, String broadcasterLanguage, Date createdAt, String displayName, String email,
			Long followers, String game, String language, String logo, Boolean mature, String name, Boolean partner,
			String profileBanner, String profileBannerBackgroundColor, String status, String streamKey, Date updatedAt,
			String url, String videoBanner, Long views) {
		this.id = id;
		this.broadcasterLanguage = broadcasterLanguage;
		this.createdAt = createdAt;
		this.displayName = displayName;
		this.email = email;
		this.followers = followers;
		this.game = game;
		this.language = language;
		this.logo = logo;
		this.mature = mature;
		this.name = name;
		this.partner = partner;
		this.profileBanner = profileBanner;
		this.profileBannerBackgroundColor = profileBannerBackgroundColor;
		this.status = status;
		this.streamKey = streamKey;
		this.updatedAt = updatedAt;
		this.url = url;
		this.videoBanner = videoBanner;
		this.views = views;
	}

	public Long iId() {
		return id;
	}

	public String broadcasterLanguage() {
		return broadcasterLanguage;
	}

	public Date createdAt() {
		return createdAt;
	}

	public String displayName() {
		return displayName;
	}

	public String email() {
		return email;
	}

	public Long followers() {
		return followers;
	}

	public String game() {
		return game;
	}

	public String language() {
		return language;
	}

	public String logo() {
		return logo;
	}

	public Boolean mature() {
		return mature;
	}

	public String name() {
		return name;
	}

	public Boolean partner() {
		return partner;
	}

	public String profileBanner() {
		return profileBanner;
	}

	public String profileBannerBackgroundColor() {
		return profileBannerBackgroundColor;
	}

	public String status() {
		return status;
	}

	public String streamKey() {
		return streamKey;
	}

	public Date updatedAt() {
		return updatedAt;
	}

	public String url() {
		return url;
	}

	public String videoBanner() {
		return videoBanner;
	}

	public Long views() {
		return views;
	}

}
