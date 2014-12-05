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
abstract class InstagramApiExceptionMixin extends InstagramObjectMixin {

    @JsonCreator
    InstagramApiExceptionMixin(
            @JsonProperty("code") String code,
            @JsonProperty("error_type") String errorType,
            @JsonProperty("error_message") String errorMessage
    ){}

}
