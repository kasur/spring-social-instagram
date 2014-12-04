package org.springframework.social.api;

import org.springframework.social.ApiBinding;

/**
 *
 * Defines a set of operations available for Instagram interaction
 *
 * @author erusak.
 */
public interface Instagram extends ApiBinding {

    /**
     * API for performing operations on Instagram tags
     * @return {@link TagOperations}
     */
    TagOperations tagOperations();

    /**
     * API for performing operations on Instagram user profiles.
     * @return {@link UserOperations}
     */
    UserOperations userOperations();

}
