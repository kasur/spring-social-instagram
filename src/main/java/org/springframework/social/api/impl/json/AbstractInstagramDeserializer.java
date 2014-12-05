package org.springframework.social.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.social.api.impl.InstagramEnvelope;

import java.io.IOException;

/**
 *
 * @author erusak.
 */
abstract class AbstractInstagramDeserializer<T> extends JsonDeserializer<T> {

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new InstagramModule());

        TypeFactory typeFactory = deserializationContext.getTypeFactory();

        JavaType javaType = typeFactory.constructParametricType(InstagramEnvelope.class, constructType(typeFactory));

        return mapper.readValue(jsonParser, javaType);
    }

    abstract JavaType constructType(TypeFactory typeFactory);

}
