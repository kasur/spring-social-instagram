package org.springframework.social.instagram.api;

import java.util.Collection;

/**
 * @author erusak.
 */
public class PagedCollection<T> {

    private final Collection<T> data;

    private final PagingParameters pagingParams;

    public PagedCollection(Collection<T> data, PagingParameters pagingParams) {
        this.data = data;
        this.pagingParams = pagingParams;
    }

    public Collection<T> getData() {
        return data;
    }

    public PagingParameters getPagingParams() {
        return pagingParams;
    }
}
