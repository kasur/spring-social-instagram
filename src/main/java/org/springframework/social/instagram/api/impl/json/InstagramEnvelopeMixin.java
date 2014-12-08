package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author erusak.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
/*@JsonSubTypes({
        @JsonSubTypes.Type(value=MediaContainer.class )
})*/
abstract class InstagramEnvelopeMixin<T> extends InstagramObjectMixin {

    @JsonCreator
    protected InstagramEnvelopeMixin(
            @JsonProperty("data") T payload
    ) {}
}
