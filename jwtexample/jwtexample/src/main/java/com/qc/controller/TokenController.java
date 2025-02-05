package com.qc.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

	@GetMapping("/token")
	public String getToken(
			// return "Redirect to Okta for authentication.";
			@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient authorizedClient,
			@AuthenticationPrincipal OidcUser oidcUser) {
		// Extract the access token
		String accessToken = authorizedClient.getAccessToken().getTokenValue();
		return "Access Token: " + accessToken;
	}
}
