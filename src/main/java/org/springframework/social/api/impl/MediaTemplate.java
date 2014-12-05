package org.springframework.social.api.impl;

import org.springframework.social.api.Media;
import org.springframework.social.api.MediaOperations;
import org.springframework.social.api.impl.json.MediaContainer;

import java.util.Collections;

/**
 * @author erusak.
 */
public class MediaTemplate extends AbstractInstagramOperations implements MediaOperations {

    public MediaTemplate(InstagramTemplate instagramTemplate, boolean isAuthorizedForUser) {
        super(instagramTemplate, isAuthorizedForUser);
    }

    @Override
    public Media getMedia(String mediaId) {
        return get(buildUri("media/{media-id}"), MediaContainer.class, Collections.singletonMap("media-id", mediaId))
                .getPayload();
    }
}
