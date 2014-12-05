package org.springframework.social.api.impl;

import org.springframework.social.api.InstagramProfile;
import org.springframework.social.api.UserOperations;

import java.util.Collections;

/**
 * @author erusak.
 */
public class UserTemplate extends AbstractInstagramOperations implements UserOperations {

    public UserTemplate(InstagramTemplate instagramTemplate, boolean isAuthorizedForUser) {
        super(instagramTemplate, isAuthorizedForUser);
    }

    @Override
    public InstagramProfile getUserProfile() {
        requireAuthorization();
        return getUserProfile("self");
    }

    @Override
    public InstagramProfile getUserProfile(String userId) {
        return get(buildUri("users/{userId}"), InstagramProfile.class, Collections.singletonMap("userId", userId));
    }
    
}
