package org.springframework.social.instagram.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.List;
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


    protected <T> T get(String uriTemplate, Class<T> returnType,
                        Map<String, ?> pathVars, Map<String, List<String>> queryParams) {
        return instagramTemplate.getRestTemplate()
                .getForObject(buildUri(uriTemplate, pathVars, new LinkedMultiValueMap<>(queryParams)).toASCIIString(), returnType);
    }

    protected <T> T get(String uriTemplate, Class<T> returnType,
                        Map<String, ?> pathVars) {
        return instagramTemplate.getRestTemplate()
                .getForObject(buildUri(uriTemplate, pathVars, EMPTY_QUERY_PARAMS).toASCIIString(), returnType);
    }

    protected URI buildUri(String path, Map<String, ?> pathVars, LinkedMultiValueMap<String,String> queryParams) {
        URI uriExpanded = new UriTemplate(API_URL_BASE + path).expand(pathVars);
        return instagramTemplate.withAccessToken(uriExpanded).queryParams(queryParams).build();
    }

    private static final String API_URL_BASE = "https://api.instagram.com/v1/";

    private static final LinkedMultiValueMap<String,String> EMPTY_QUERY_PARAMS = new LinkedMultiValueMap<>();

}
