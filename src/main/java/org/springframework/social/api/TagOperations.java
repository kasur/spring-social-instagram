package org.springframework.social.api;

/**
 * Defines operations for working with Instagram tags
 *
 * @author erusak.
 */
public interface TagOperations {

    /**
     * Get a list of recently tagged media.
     * Note that this media is ordered by when the media was tagged with this tag, rather than the order it was posted
     * @param tag tag name of interest
     * @param pagingParameters the parameters defining the bounds of the list to return.
     * @return a list of recent {@link Media}s for the specified tag
     */
    PagedCollection<Media> getRecentMedia(String tag, PagingParameters pagingParameters);

}
