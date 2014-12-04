package org.springframework.social.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author erusak.
 */
public abstract class InstagramObject {

    private final Map<String,Object> extraData;

    public InstagramObject() {
        this.extraData = new HashMap<>();
    }

    /**
     * @return Any fields in response from Instagram that are otherwise not mapped to any properties.
     */
    public Map<String, Object> getExtraData() {
        return extraData;
    }

    /**
     * {@link com.fasterxml.jackson.annotation.JsonAnySetter} hook.
     * Called when an otherwise unmapped property is being processed during JSON deserialization.
     * @param key The property's key.
     * @param value The property's value.
     */
    protected void add(String key, Object value) {
        extraData.put(key, value);
    }

}
