package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.social.instagram.api.InstagramObject;
import org.springframework.social.instagram.api.Media;

/**
 * @author erusak.
 */
/*@JsonDeserialize(using = MediaContainerMixin.MediaContainerDeserializer.class)*/
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class MediaContainerMixin extends InstagramObject {

    @JsonCreator
    MediaContainerMixin (
            @JsonProperty("data") Media payload
    ){}

    public static final class MediaContainerDeserializer extends AbstractInstagramDeserializer<Media> {
        @Override
        JavaType constructType() {
            return TypeFactory.defaultInstance().constructType(Media.class);
        }
    }
}
