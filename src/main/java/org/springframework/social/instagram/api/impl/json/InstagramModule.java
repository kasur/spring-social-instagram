package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.instagram.api.InstagramApiException;
import org.springframework.social.instagram.api.InstagramObject;
import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.Media;

/**
 * @author erusak.
 */
public class InstagramModule extends SimpleModule {

    public InstagramModule() {
        super("InstagramModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(MediaContainer.class, MediaContainerMixin.class);
        context.setMixInAnnotations(InstagramObject.class, InstagramObjectMixin.class);
        context.setMixInAnnotations(Media.class, MediaMixin.class);
        context.setMixInAnnotations(InstagramProfile.class, InstagramProfileMixin.class);
        context.setMixInAnnotations(InstagramApiException.class, InstagramApiExceptionMixin.class);
    }
}
