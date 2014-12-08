package org.springframework.social.instagram.api;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author erusak.
 */
public class PagedCollection<T> {

    private final Collection<T> collection;

    private final PagingParameters pagingParams;

    public PagedCollection(LinkedList<T> collection, PagingParameters pagingParams) {
        this.collection = collection == null ? Collections.<T>emptyList() : collection ;
        this.pagingParams = pagingParams;
    }

    public Collection<T> getCollection() {
        return collection;
    }

    public PagingParameters getPagingParams() {
        return pagingParams;
    }
}
