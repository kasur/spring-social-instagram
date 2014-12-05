package org.springframework.social.instagram.security;

import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.connect.InstagramConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

/**
 * @author erusak.
 */
public class InstagramAuthenticationService extends OAuth2AuthenticationService<Instagram> {

    public InstagramAuthenticationService(String clientId, String clientSecret) {
        super(new InstagramConnectionFactory(clientId, clientSecret));
    }

    public InstagramAuthenticationService(String clientId, String clientSecret, String scope) {
        super(new InstagramConnectionFactory(clientId, clientSecret, scope));
    }
}
