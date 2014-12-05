package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.impl.InstagramEnvelope;

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
