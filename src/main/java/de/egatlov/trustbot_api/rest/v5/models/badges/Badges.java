package de.egatlov.trustbot_api.rest.v5.models.badges;

public class Badges {

	/**
	 * global_mod
	 */
	private final GlobalMod globalMod;
	private final Admin admin;
	private final Broadcaster broadcaster;
	private final Mod mod;
	private final Staff staff;
	private final Turbo turbo;
	private final String subscriber;

	public Badges(GlobalMod globalMod, Admin admin, Broadcaster broadcaster, Mod mod, Staff staff, Turbo turbo,
			String subscriber) {
		this.globalMod = globalMod;
		this.admin = admin;
		this.broadcaster = broadcaster;
		this.mod = mod;
		this.staff = staff;
		this.turbo = turbo;
		this.subscriber = subscriber;
	}

	public GlobalMod globalMod() {
		return globalMod;
	}

	public Admin admin() {
		return admin;
	}

	public Broadcaster broadcaster() {
		return broadcaster;
	}

	public Mod mod() {
		return mod;
	}

	public Staff staff() {
		return staff;
	}

	public Turbo turbo() {
		return turbo;
	}

	public String subscriber() {
		return subscriber;
	}

}
