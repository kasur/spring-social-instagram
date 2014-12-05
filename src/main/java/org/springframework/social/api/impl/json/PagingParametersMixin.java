package org.springframework.social.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to PagingParameters
 *
 * @author erusak.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PagingParametersMixin extends InstagramObjectMixin {

    @JsonCreator
    PagingParametersMixin(
            @JsonProperty("next_url") String nextUrl,
            @JsonProperty("next_min_id") String nextMinId,
            @JsonProperty("next_max_id") String nextMaxId
    ){}

}
