package org.springframework.social.api.impl;

import org.springframework.social.NotAuthorizedException;
import org.springframework.social.api.Instagram;
import org.springframework.social.api.TagOperations;
import org.springframework.social.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

/**
 * <p>This is the central class for interacting with Instagram.</p>
 * <p>
 * There are some operations, such as searching, that do not require OAuth
 * authentication. In those cases, you may use a {@link InstagramTemplate} that is
 * created through the default constructor and without any OAuth details.
 * Attempts to perform secured operations through such an instance, however,
 * will result in {@link NotAuthorizedException} being thrown.
 * </p>
 *
 * @author erusak
 *
 */
public class InstagramTemplate extends AbstractOAuth2ApiBinding implements Instagram {

    private TagOperations tagOperations;

    private UserOperations userOperations;

    private String applicationScope;

    /**
     * Create a new instance of InstagramTemplate.
     * This constructor creates a new InstagramTemplate able to perform unauthenticated operations against Instagram's API.
     * Some operations do not require OAuth authentication.
     * For example, retrieving a specified user's profile or feed does not require authentication (although the data returned will be limited to what is publicly available).
     * A InstagramTemplate created with this constructor will support those operations.
     * Those operations requiring authentication will throw {@link NotAuthorizedException}.
     */
    public InstagramTemplate() {
        initialize();
    }


    /**
     * Create a new instance of InstagramTemplate.
     * This constructor creates the InstagramTemplate using a given access token.
     * @param accessToken An access token given by Instagram after a successful OAuth 2 authentication (or through Instagram's JS library).
     */
    public InstagramTemplate(String accessToken) {
        this(accessToken, null);
    }

    public InstagramTemplate(String accessToken, String applicationScope) {
        super(accessToken);
        this.applicationScope = applicationScope;
        initialize();
    }


    @Override
    public TagOperations tagOperations() {
        return tagOperations;
    }

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    public String getApplicationScope() {
        return applicationScope;
    }

    // private helpers
    private void initialize() {
        // Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }

    private void initSubApis() {
        userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
        tagOperations = new TagTemplate(getRestTemplate(), isAuthorized());
    }

}
