package org.springframework.social.instagram.api;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;

/**
 *
 * Defines operations for working with Instagram users
 *
 * @author erusak.
 */
public interface UserOperations {

    /**
     * Retrieves the profile for the authenticated user.
     * @return the user's profile information.
     * @throws ApiException if there is an error while communicating with Instagram.
     * @throws MissingAuthorizationException if InstagramTemplate was not created with an access token.
     */
    InstagramProfile getUserProfile();

    /**
     * Retrieves the profile for the specified user id.
     * @return the user's profile information.
     * @throws ApiException if there is an error while communicating with Instagram.
     * @throws MissingAuthorizationException if InstagramTemplate was not created with an access token.
     */
    InstagramProfile getUserProfile(String userId);

}
