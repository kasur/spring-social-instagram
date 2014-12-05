package org.springframework.social.instagram.connect;

import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.impl.InstagramTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 *
 * Instagram ServiceProvider implementation.
 *
 * @author erusak.
 */
public class InstagramServiceProvider extends AbstractOAuth2ServiceProvider<Instagram> {

    private final String scope;
    private final String clientId;
    private final String clientSecret;


    public InstagramServiceProvider(String clientId, String clientSecret, String scope) {
        super( new InstagramOAuth2Template(clientId, clientSecret) );
        this.scope = scope;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public Instagram getApi(String accessToken) {
        return new InstagramTemplate(clientId, clientSecret, accessToken, scope);
    }
}
