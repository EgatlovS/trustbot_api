package de.egatlov.trustbot_api.rest.v5.models.posts;

public class Permissions {

	/**
	 * can_delete
	 */
	private final Boolean canDelete;
	/**
	 * can_moderate
	 */
	private final Boolean canModerate;
	/**
	 * can_reply
	 */
	private final Boolean canReply;

	public Permissions(Boolean canDelete, Boolean canModerate, Boolean canReply) {
		this.canDelete = canDelete;
		this.canModerate = canModerate;
		this.canReply = canReply;
	}

	public Boolean canDelete() {
		return canDelete;
	}

	public Boolean canModerate() {
		return canModerate;
	}

	public Boolean canReply() {
		return canReply;
	}

}
