package org.springframework.social.api.impl;

import org.springframework.social.api.*;
import org.springframework.web.client.RestTemplate;

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
        // TODO implemented
        throw new UnsupportedOperationException("[instagram][getRecentMedia is not supported yet]");
    }
}
