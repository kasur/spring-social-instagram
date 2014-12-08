package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.instagram.api.InstagramObject;
import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.PagingParameters;

import java.util.LinkedList;

/**
 * @author erusak.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class MediaPagedCollectionContainerMixin extends InstagramObject {

    @JsonCreator
    MediaPagedCollectionContainerMixin(
            @JsonProperty("data") LinkedList<Media> collection,
            @JsonProperty("pagination") PagingParameters pagingParams
    ){}

}
