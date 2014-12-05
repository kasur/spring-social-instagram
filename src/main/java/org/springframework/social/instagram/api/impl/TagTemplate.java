package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.PagedCollection;
import org.springframework.social.instagram.api.PagingParameters;
import org.springframework.social.instagram.api.TagOperations;

/**
 * @author erusak.
 */
public class TagTemplate extends AbstractInstagramOperations implements TagOperations {

    public TagTemplate(InstagramTemplate instagramTemplate, boolean isAuthorizedForUser) {
        super(instagramTemplate,isAuthorizedForUser);
    }

    @Override
    public PagedCollection<Media> getRecentMedia(String tag, PagingParameters pagedListParameters) {
        // TODO implemented
        throw new UnsupportedOperationException("[instagram][getRecentMedia is not supported yet]");
    }
}
