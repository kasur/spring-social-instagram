package org.springframework.social.api.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.social.api.InstagramObject;

/**
 * @author erusak.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramEnvelope<T> extends InstagramObject {

    private final T payload;

    protected InstagramEnvelope(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }
}
