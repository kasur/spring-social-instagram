package org.springframework.social.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.Map;

/**
 * @author erusak.
 */
abstract class AbstractInstagramOperations {

    private final boolean isAuthorized;

    private final InstagramTemplate instagramTemplate;

    AbstractInstagramOperations(InstagramTemplate instagram, boolean isAuthorized) {
        this.instagramTemplate = instagram;
        this.isAuthorized = isAuthorized;
    }


    protected void requireAuthorization() {
        if(!isAuthorized) {
            throw new MissingAuthorizationException("instagram");
        }
    }


    protected <T> T get(URI uri, Class<T> returnType, Map<String, ?> pathVariables) {

        return instagramTemplate.getRestTemplate().getForObject(uri.toASCIIString(), returnType, pathVariables);
    }

    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
    }

    private static final String API_URL_BASE = "https://api.instagram.com/v1/";

    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<>();

}
