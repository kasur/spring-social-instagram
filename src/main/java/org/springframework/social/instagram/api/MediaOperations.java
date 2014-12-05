package org.springframework.social.instagram.api;

/**
 *
 * Defines operations for working with Instagram media
 *
 * @author erusak.
 */
public interface MediaOperations {

    /**
     * Retrieves the media for the specified media id.
     * @return the media information.
     * @throws org.springframework.social.ApiException if there is an error while communicating with Instagram.
     */
    Media getMedia(String mediaId);

}
