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
        return getWithCompleteUri(pagedListParameters.getNextUrl(), MediaPagedCollectionContainer.class).getPayload();
    }

    @Override
    public PagedCollection<Media> getRecentMedia(String tag) {
        return get("tags/{tag-name}/media/recent", MediaPagedCollectionContainer.class,
                Collections.singletonMap("tag-name", tag)
        ).getPayload();
    }
}
