package org.springframework.social.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;

/**
 * @author erusak.
 */
public class PagingParameters implements Serializable {

    private final Integer limit;

    private final Integer offset;

    private final Long since;

    private final Long until;

    /**
     * Constructs a PagedListParameters.
     * @param limit The number of items to limit the list to.
     * @param offset The offset into the full result list to start this list at.
     * @param since The beginning timestamp bound for time-sensitive content (e.g., posts, comments, etc).
     * @param until The ending timestamp bound for time-sensitive content (e.g., posts, comments, etc).
     */
    public PagingParameters(Integer limit, Integer offset, Long since, Long until) {
        this.limit = limit;
        this.offset = offset;
        this.since = since;
        this.until = until;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public Long getSince() {
        return since;
    }

    public Long getUntil() {
        return until;
    }

    public MultiValueMap<String, String> toMap() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        if (limit != null) { map.set("limit", String.valueOf(limit)); }
        if (offset != null) { map.set("offset", String.valueOf(offset)); }
        if (since != null) { map.set("since", String.valueOf(since)); }
        if (until != null) { map.set("until", String.valueOf(until)); }
        return map;
    }

}
