package de.egatlov.trustbot_api.rest.v3.models;

import java.util.Date;

public class Channel {

	private final Boolean mature;
	private final String status;
	/**
	 * broadcaster_language
	 */
	private final String broadcasterLanguage;
	/**
	 * display_name
	 */
	private final String displayName;
	private final String game;
	private final Integer delay;
	private final String language;
	/**
	 * _id
	 */
	private final Long id;
	private final String name;
	/**
	 * created_at
	 */
	private final Date createdAt;
	/**
	 * updated_at
	 */
	private final Date updatedAt;
	private final String logo;
	private final String banner;
	/**
	 * video_banner
	 */
	private final String videoBanner;
	private final String background;
	/**
	 * profile_banner
	 */
	private final String profileBanner;
	/**
	 * profile_banner_background_color
	 */
	private final String profileBannerBackgroundColor;
	private final Boolean partner;
	private final String url;
	private final Long views;
	private final Long followers;
	private final String email;
	private final String streamKey;
	/**
	 * _links
	 */
	private final Links links;
	private final Boolean channelFeedEnabled;

	public Channel(Boolean mature, String status, String broadcasterLanguage, String displayName, String game,
			Integer delay, String language, Long id, String name, Date createdAt, Date updatedAt, String logo,
			String banner, String videoBanner, String background, String profileBanner,
			String profileBannerBackgroundColor, Boolean partner, String url, Long views, Long followers, Links links,
			String email, String streamKey, Boolean channelFeedEnabled) {
		this.mature = mature;
		this.status = status;
		this.broadcasterLanguage = broadcasterLanguage;
		this.displayName = displayName;
		this.game = game;
		this.delay = delay;
		this.language = language;
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.logo = logo;
		this.banner = banner;
		this.videoBanner = videoBanner;
		this.background = background;
		this.profileBanner = profileBanner;
		this.profileBannerBackgroundColor = profileBannerBackgroundColor;
		this.partner = partner;
		this.url = url;
		this.views = views;
		this.followers = followers;
		this.links = links;
		this.email = email;
		this.streamKey = streamKey;
		this.channelFeedEnabled = channelFeedEnabled;
	}

	public Boolean mature() {
		return mature;
	}

	public String status() {
		return status;
	}

	public String broadcasterLanguage() {
		return broadcasterLanguage;
	}

	public String displayName() {
		return displayName;
	}

	public String game() {
		return game;
	}

	public Integer delay() {
		return delay;
	}

	public String language() {
		return language;
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}

	public Date createdAt() {
		return createdAt;
	}

	public Date updatedAt() {
		return updatedAt;
	}

	public String logo() {
		return logo;
	}

	public String banner() {
		return banner;
	}

	public String videoBanner() {
		return videoBanner;
	}

	public String background() {
		return background;
	}

	public String profileBanner() {
		return profileBanner;
	}

	public String profileBannerBackgroundColor() {
		return profileBannerBackgroundColor;
	}

	public Boolean partner() {
		return partner;
	}

	public String url() {
		return url;
	}

	public Long views() {
		return views;
	}

	public Long followers() {
		return followers;
	}

	public String email() {
		return email;
	}

	public String streamKey() {
		return streamKey;
	}

	public Links links() {
		return links;
	}

	public Boolean channelFeedEnabled() {
		return channelFeedEnabled;
	}

}
