package org.springframework.social.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to InstagramProfile
 *
 * @author erusak.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class InstagramProfileMixin extends InstagramObjectMixin {

    @JsonCreator
    InstagramProfileMixin (
            @JsonProperty("id") String id,
            @JsonProperty("username") String userName,
            @JsonProperty("full_name") String fullName,
            @JsonProperty("profile_picture") String profilePicture,
            @JsonProperty("bio") String bio,
            @JsonProperty("website") String website
    ){}

}
