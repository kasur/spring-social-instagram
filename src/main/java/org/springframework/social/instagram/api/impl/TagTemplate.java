package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.PagedCollection;
import org.springframework.social.instagram.api.PagingParameters;
import org.springframework.social.instagram.api.TagOperations;

import java.util.Collections;

/**
 * @author erusak.
 */
public class TagTemplate extends AbstractInstagramOperations implements TagOperations {

    public TagTemplate(InstagramTemplate instagramTemplate, boolean isAuthorizedForUser) {
        super(instagramTemplate,isAuthorizedForUser);
    }

    @Override
    public PagedCollection<Media> getRecentMedia(String tag, PagingParameters pagedListParameters) {
        return getRecentMedia(tag, pagedListParameters, -1);
    }

    @Override
    public PagedCollection<Media> getRecentMedia(String tag, PagingParameters pagingParameters, int count) {
        return getWithCompleteUri(pagingParameters.getNextUrl(), MediaPagedCollectionContainer.class, count).getPayload();
    }

    @Override
    public PagedCollection<Media> getRecentMedia(String tag, int count) {
        return get("tags/{tag-name}/media/recent", MediaPagedCollectionContainer.class,
                Collections.singletonMap("tag-name", tag),
                count
        ).getPayload();
    }

    @Override
    public PagedCollection<Media> getRecentMedia(String tag) {
        return getRecentMedia(tag, -1);
    }

}
