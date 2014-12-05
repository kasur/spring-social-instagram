package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.MediaOperations;
import org.springframework.social.instagram.api.TagOperations;
import org.springframework.social.instagram.api.UserOperations;
import org.springframework.social.instagram.api.impl.json.InstagramModule;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

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

    private MediaOperations mediaOperations;

    private String applicationScope;

    private ObjectMapper objectMapper;

    private final String clientId;

    private final String clientSecret;

    private final String accessToken;

    /**
     * Create a new instance of InstagramTemplate.
     * This constructor creates a new InstagramTemplate able to perform unauthenticated operations against Instagram's API.
     * Some operations do not require OAuth authentication.
     * For example, retrieving a specified user's profile or feed does not require authentication (although the data returned will be limited to what is publicly available).
     * A InstagramTemplate created with this constructor will support those operations.
     * Those operations requiring authentication will throw {@link NotAuthorizedException}.
     */
    public InstagramTemplate(final String clientId, final String clientSecret) {
        /*this.clientId = Objects.requireNonNull(clientId, "[Client id is required]");
        this.clientSecret = Objects.requireNonNull(clientSecret, "[Client secret is required as  ]");
        this.accessToken = null;*/
        this(clientId, clientSecret, null);
        initialize();
    }


    /**
     * Create a new instance of InstagramTemplate.
     * This constructor creates the InstagramTemplate using a given access token.
     * @param accessToken An access token given by Instagram after a successful OAuth 2 authentication.
     */
    public InstagramTemplate(String clientId, String clientSecret, String accessToken) {
        this(clientId, clientSecret, accessToken, "basic");
    }

    public InstagramTemplate(String clientId, String clientSecret, String accessToken, String applicationScope) {
        super(accessToken);
        this.applicationScope = applicationScope;
        this.clientId = Objects.requireNonNull(clientId, "[Client id is required]");
        this.clientSecret = Objects.requireNonNull(clientSecret, "[Client secret is required as  ]");
        this.accessToken = accessToken;
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

    @Override
    public MediaOperations mediaOperations() {
        return mediaOperations;
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
        userOperations = new UserTemplate(this, isAuthorized());
        tagOperations = new TagTemplate(this, isAuthorized());
        mediaOperations = new MediaTemplate(this, isAuthorized());
    }

    // AbstractOAuth2ApiBinding hooks
    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.DRAFT_10;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new InstagramErrorHandler());
    }

    public URIBuilder withAccessToken(String uri) {
        return (accessToken == null)
                ? URIBuilder.fromUri(uri).queryParam("client_id", clientId)
                : URIBuilder.fromUri(uri).queryParam("access_token", accessToken);
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new InstagramModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }

}
