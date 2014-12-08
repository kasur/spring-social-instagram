package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.InstagramObject;

/**
 * @author erusak.
 */
public abstract class InstagramEnvelope<T> extends InstagramObject {

    private final T payload;

    protected InstagramEnvelope(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }
}
