package org.springframework.social.api.impl;

import org.springframework.social.api.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author erusak.
 */
public class TagTemplate extends AbstractInstagramOperations implements TagOperations {

    private final RestTemplate restTemplate;

    public TagTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    public InstagramProfile getUserProfile(String userId) {
        return restTemplate.getForObject(buildUri("users/{userId}").toASCIIString(), InstagramProfile.class, userId);
    }

    @Override
    public PagedList<Media> getRecentMedia(String tag, PagingParameters pagedListParameters) {
        // TODO implemented
        throw new UnsupportedOperationException("[instagram][getRecentMedia is not supported yet]");
    }
}
