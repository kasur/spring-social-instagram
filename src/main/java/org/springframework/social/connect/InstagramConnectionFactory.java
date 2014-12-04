package org.springframework.social.connect;

import org.springframework.social.api.Instagram;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * Instagram ConnectionFactory implementation
 * @author erusak.
 */
public class InstagramConnectionFactory extends OAuth2ConnectionFactory<Instagram> {

    /**
     * Creates a InstagramConnectionFactory for the given application ID and secret.
     * Using this constructor, no application scope is set (and therefore Instagram will grant "basic" scope by default).
     * @param clientId The application's App ID as assigned by Instagram
     * @param clientSecret The application's App Secret as assigned by Instagram
     */
    public InstagramConnectionFactory(String clientId, String clientSecret) {
        this(clientId, clientSecret, "basic");
    }

    /**
     * Creates a InstagramConnectionFactory for the given client ID, secret, scope.
     * @param clientId The application's App ID as assigned by Instagram
     * @param clientSecret The application's App Secret as assigned by Instagram
     * @param scope The application's App Namespace as configured with Instagram.
     */
    public InstagramConnectionFactory(String clientId, String clientSecret, String scope) {
        super("instagram", new InstagramServiceProvider(clientId, clientSecret, scope), new InstagramAdapter());
    }

}
