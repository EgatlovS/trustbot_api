package de.egatlov.trustbot_api.config;

/**
 * ConnectionConfiguration.java
 * 
 * Created at: 25.02.2017
 * @author egatlov
 */
public interface ConnectionConfiguration {

	String host();

	int port();

	String oauthKey();

	String name();

	String channel();

}
