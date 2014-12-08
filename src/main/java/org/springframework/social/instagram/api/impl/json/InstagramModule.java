package org.springframework.social.instagram.api.impl.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.instagram.api.*;
import org.springframework.social.instagram.api.impl.MediaPagedCollectionContainer;

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
        context.setMixInAnnotations(MediaPagedCollectionContainer.class, MediaPagedCollectionContainerMixin.class);
        context.setMixInAnnotations(InstagramObject.class, InstagramObjectMixin.class);
        context.setMixInAnnotations(Media.class, MediaMixin.class);
        context.setMixInAnnotations(InstagramProfile.class, InstagramProfileMixin.class);
        context.setMixInAnnotations(InstagramApiException.class, InstagramApiExceptionMixin.class);
        context.setMixInAnnotations(PagingParameters.class, PagingParametersMixin.class);
    }
}
