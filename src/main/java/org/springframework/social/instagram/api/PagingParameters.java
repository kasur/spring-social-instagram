package org.springframework.social.instagram.api;

import java.util.Objects;

/**
 * @author erusak.
 */
public class PagingParameters extends InstagramObject {

    private final String nextUrl;
    private final String nextMaxId;
    private final String nextMinId;

    /**
     *
     * @param nextUrl next url that should be used when the object is passed along with request params
     * @param nextMaxId next_max_id in terms of Instagram definition
     * @param nextMinId next_min_id int terms of Instagram definition
     */
    public PagingParameters(String nextUrl, String nextMaxId, String nextMinId) {
        this.nextUrl = nextUrl;
        this.nextMaxId = nextMaxId;
        this.nextMinId = nextMinId;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }

    public String getNextMinId() {
        return nextMinId;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + toStringEntry("nextUrl", nextUrl)
                + toStringEntry("nextMaxId", nextMaxId)
                + toStringEntry("nextMinId", nextMinId);
    }


    private static String toStringEntry(String fieldName, Object fieldValue) {
        return "[" + fieldName + "=" + Objects.toString(fieldValue) + "]";
    }

}
