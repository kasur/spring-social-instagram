package org.springframework.social.connect;

import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author erusak.
 */
public class InstagramOAuth2Template extends OAuth2Template {

    public InstagramOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret,
                "https://api.instagram.com/oauth/authorize",
                "https://api.instagram.com/oauth/access_token"
        );
    }

}
