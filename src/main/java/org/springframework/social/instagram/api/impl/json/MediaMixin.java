package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.List;

import static org.springframework.social.instagram.api.Media.Type;
import static org.springframework.social.instagram.api.Media.Type.UNKNOWN;

/**
 *
 * Annotated mixin to add Jackson annotations to Media
 *
 * @author erusak.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class MediaMixin extends InstagramObjectMixin {

    @JsonCreator
    public MediaMixin(
            @JsonProperty("id") String id,
            @JsonProperty("created_time") long createdTime,
            @JsonProperty("type") @JsonDeserialize(using = TypeDeserializer.class) Type type,
            @JsonProperty("tags") List<String> tags
    ){}

    private static final class TypeDeserializer extends JsonDeserializer<Type> {
        @Override
        public Type deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            try {
                return Type.valueOf(jsonParser.getText().toUpperCase());
            }  catch (IllegalArgumentException iae) {
                return UNKNOWN;
            }

        }
    }

}
