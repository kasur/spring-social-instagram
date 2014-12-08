package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.PagedCollection;
import org.springframework.social.instagram.api.PagingParameters;

import java.util.LinkedList;

/**
 * @author erusak.
 */
public class MediaPagedCollectionContainer extends InstagramEnvelope<PagedCollection<Media>> {

    protected MediaPagedCollectionContainer(LinkedList<Media> collection, PagingParameters pagingParams) {
        super(new PagedCollection<>(collection, pagingParams));
    }
}
