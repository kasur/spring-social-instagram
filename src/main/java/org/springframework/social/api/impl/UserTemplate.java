package org.springframework.social.api.impl;

import org.springframework.social.api.InstagramProfile;
import org.springframework.social.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author erusak.
 */
public class UserTemplate extends AbstractInstagramOperations implements UserOperations {

    private final RestTemplate restTemplate;

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    @Override
    public InstagramProfile getUserProfile() {
        requireAuthorization();
        return getUserProfile("self");
    }

    public InstagramProfile getUserProfile(String userId) {
        return restTemplate.getForObject(buildUri("users/{userId}").toASCIIString(), InstagramProfile.class, userId);
    }
    
}
