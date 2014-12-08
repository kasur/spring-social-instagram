package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.social.instagram.api.impl.InstagramEnvelope;

import java.io.IOException;

/**
 *
 * @author erusak.
 */
abstract class AbstractInstagramDeserializer<T> extends JsonDeserializer<T> {

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new InstagramModule());

        JavaType javaType = TypeFactory.defaultInstance().constructParametricType(InstagramEnvelope.class, constructType());

        return mapper.readValue(jsonParser, javaType);
    }

    abstract JavaType constructType();

}
