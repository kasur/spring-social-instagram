package org.springframework.social.api.impl.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.social.api.Media;
import org.springframework.social.api.impl.InstagramEnvelope;

/**
 *
 * @author erusak.
 */
@JsonDeserialize(using = MediaContainer.MediaContainerDeserializer.class)
public class MediaContainer extends InstagramEnvelope<Media> {

    MediaContainer(Media media) {
        super(media);
    }

    public static final class MediaContainerDeserializer extends AbstractInstagramDeserializer<MediaContainer> {
        @Override
        JavaType constructType(TypeFactory typeFactory) {
            return typeFactory.constructParametricType(Class.class, Media.class);
        }
    }

}
