package org.springframework.social.instagram.api;

import java.io.Serializable;

/**
 * @author erusak.
 */
public class PagingParameters extends InstagramObject implements Serializable {

    private String nextUrl;
    private long nextMaxId;
    private long nextMinId;

    /**
     *
     * @param nextUrl next url that should be used when the object is passed along with request params
     * @param nextMaxId next_max_id in terms of Instagram definition
     * @param nextMinId next_min_id int terms of Instagram definition
     */
    public PagingParameters(String nextUrl, long nextMaxId, long nextMinId) {
        this.nextUrl = nextUrl;
        this.nextMaxId = nextMaxId;
        this.nextMinId = nextMinId;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public long getNextMaxId() {
        return nextMaxId;
    }

    public long getNextMinId() {
        return nextMinId;
    }

}
