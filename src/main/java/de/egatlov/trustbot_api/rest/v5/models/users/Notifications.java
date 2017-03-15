package de.egatlov.trustbot_api.rest.v5.models.users;

public class Notifications {

	private final Boolean email;
	private final Boolean push;

	public Notifications(Boolean email, Boolean push) {
		this.email = email;
		this.push = push;
	}

	public Boolean email() {
		return email;
	}

	public Boolean push() {
		return push;
	}

}
