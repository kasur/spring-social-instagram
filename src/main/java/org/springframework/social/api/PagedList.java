package org.springframework.social.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erusak.
 */
public class PagedList<T> extends ArrayList<T> {

    private final PagingParameters previousPage;

    private final PagingParameters nextPage;

    public PagedList(List<T> unpagedList, PagingParameters previousPage, PagingParameters nextPage) {
        super(unpagedList);
        this.previousPage = previousPage;
        this.nextPage = nextPage;
    }

    public PagingParameters getPreviousPage() {
        return previousPage;
    }

    public PagingParameters getNextPage() {
        return nextPage;
    }
}
