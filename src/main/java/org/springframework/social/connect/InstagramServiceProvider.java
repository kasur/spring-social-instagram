package org.springframework.social.connect;

import org.springframework.social.api.Instagram;
import org.springframework.social.api.impl.InstagramTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 *
 * Instagram ServiceProvider implementation.
 *
 * @author erusak.
 */
public class InstagramServiceProvider extends AbstractOAuth2ServiceProvider<Instagram> {

    private final String scope;

    public InstagramServiceProvider(String clientId, String clientSecret, String scope) {
        super( new InstagramOAuth2Template(clientId, clientSecret) );
        this.scope = scope;
    }

    @Override
    public Instagram getApi(String accessToken) {
        return new InstagramTemplate(accessToken, scope);
    }
}
