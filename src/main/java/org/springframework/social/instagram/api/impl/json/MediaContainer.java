package org.springframework.social.instagram.api.impl.json;

import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.impl.InstagramEnvelope;

/**
 *
 * @author erusak.
 */
public class MediaContainer extends InstagramEnvelope<Media> {

    protected MediaContainer(Media payload) {
        super(payload);
    }
}
