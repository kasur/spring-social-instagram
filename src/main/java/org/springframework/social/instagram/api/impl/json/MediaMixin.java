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
            @JsonProperty("tags") List<String> tags,
            @JsonProperty("likes") @JsonDeserialize(using = LikesDeserializer.class) Long likes,
            @JsonProperty("link") String link,
            @JsonProperty("user") @JsonDeserialize(using = UserDeserializer.class) String userId
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

    private static final class LikesDeserializer extends JsonDeserializer<Long> {
        @Override
        public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(LikesWrapper.class).count;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static final class LikesWrapper {
            private final Long count;
            @JsonCreator
            private LikesWrapper(@JsonProperty("count") Long count) {
                this.count = count;
            }
        }

    }

    private static final class UserDeserializer extends JsonDeserializer<String> {
        @Override
        public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(UserWrapper.class).userId;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static final class UserWrapper {
            private final String userId;
            @JsonCreator
            private UserWrapper(@JsonProperty("id") String userId) {
                this.userId = userId;
            }
        }

    }

}
