package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * Annotated mixin to add Jackson annotations to InstagramObject
 *
 * @author erusak.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class InstagramObjectMixin {
    @JsonAnySetter
    abstract void add(String key, Object value);
}
