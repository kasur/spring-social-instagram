package org.springframework.social.api.impl.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.api.InstagramProfile;
import org.springframework.social.api.Media;

/**
 * @author erusak.
 */
public class InstagramModule extends SimpleModule {

    public InstagramModule() {
        super("InstagramModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Media.class, MediaMixin.class);
        context.setMixInAnnotations(InstagramProfile.class, InstagramProfileMixin.class);
    }
}
