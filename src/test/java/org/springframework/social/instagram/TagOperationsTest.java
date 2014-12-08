package org.springframework.social.instagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.PagedCollection;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author erusak.
 */
@ContextConfiguration(locations = {"classpath:spring/instagram-test-config.xml"})
public class TagOperationsTest extends AbstractTestNGSpringContextTests {

    private static final String TAG_NAME = "minsk";

    @Autowired
    @Qualifier("no-auth-template")
    private Instagram instagram;

    @Test
    public void getRecentMediaByTagName() {
        PagedCollection<Media> medias = instagram.tagOperations().getRecentMedia(TAG_NAME);
        Assert.assertNotNull(medias);
    }

}
