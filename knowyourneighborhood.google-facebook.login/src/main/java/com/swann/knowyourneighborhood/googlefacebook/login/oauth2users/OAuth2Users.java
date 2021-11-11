package com.swann.knowyourneighborhood.googlefacebook.login.oauth2users;

import java.util.Map;

public abstract class OAuth2Users {

	// Using Map function for all OAuth like Google
	protected Map<String, Object> attributes;

	// Constructor
	public abstract String getId();

	public OAuth2Users(Map<String, Object> attributes) {
		super();
		this.attributes = attributes;
	}

	public abstract String getName();

	public abstract String getEmail();

	public abstract String getImageUrl();
}
