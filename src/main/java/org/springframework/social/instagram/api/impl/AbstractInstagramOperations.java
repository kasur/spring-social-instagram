package org.springframework.social.instagram.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Collections;
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

    protected <T> T getWithCompleteUri(String completeUri, Class<T> returnType) {
        return getWithCompleteUri(completeUri, returnType, -1);
    }

    protected <T> T getWithCompleteUri(String completeUri, Class<T> returnType, int count) {
        return doGetWithCompleteUri(URIBuilder.fromUri(completeUri), returnType, count);
    }

    protected <T> T get(String uriTemplate, Class<T> returnType,
                        Map<String, ?> pathVars, Map<String, List<String>> queryParams) {
        return doGet(uriTemplate, returnType, pathVars, new LinkedMultiValueMap<>(queryParams), -1);
    }

    protected <T> T get(String uriTemplate, Class<T> returnType,
                        Map<String, ?> pathVars, Map<String, List<String>> queryParams, int count) {
        return doGet(uriTemplate, returnType, pathVars, new LinkedMultiValueMap<>(queryParams), count);
    }

    protected <T> T get(String uriTemplate, Class<T> returnType,
                        Map<String, ?> pathVars) {

        return doGet(uriTemplate, returnType, pathVars, EMPTY_QUERY_PARAMS, -1);
    }

    protected <T> T get(String uriTemplate, Class<T> returnType,
                        Map<String, ?> pathVars, int count) {

        return doGet(uriTemplate, returnType, pathVars, EMPTY_QUERY_PARAMS, count);
    }

    private <T> T doGet(String uriTemplate, Class<T> returnType,
                        Map<String, ?> pathVars, Map<String, List<String>> queryParams, int count) {

        return doGetWithCompleteUri(buildUri(uriTemplate, pathVars, new LinkedMultiValueMap<>(queryParams)), returnType, count);
    }

    private <T> T doGetWithCompleteUri(URIBuilder builder, Class<T> returnType, int count) {

        MultiValueMap<String, String> qParams = new LinkedMultiValueMap<>();

        if(count >= 0) qParams.add("count", Integer.toString(count, 10));

        return instagramTemplate.getRestTemplate()
                .getForObject(builder.queryParams(qParams).build().toASCIIString(), returnType);
    }

    protected URIBuilder buildUri(String path, Map<String, ?> pathVars, LinkedMultiValueMap<String,String> queryParams) {
        URI uriExpanded = new UriTemplate(API_URL_BASE + path).expand(pathVars);
        return instagramTemplate.withAccessToken(uriExpanded).queryParams(queryParams);
    }

    private static final String API_URL_BASE = "https://api.instagram.com/v1/";

    private static final LinkedMultiValueMap<String,String> EMPTY_QUERY_PARAMS = new LinkedMultiValueMap<>();

    private static final Map<String,?> EMPTY_PATH_PARAMS = Collections.emptyMap();

}
