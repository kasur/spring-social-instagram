package org.springframework.social.instagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.Media;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author erusak.
 */
@ContextConfiguration(locations = {"classpath:spring/instagram-test-config.xml"})
public class MediaOperationsTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("no-auth-template")
    private Instagram instagram;

    @Test
    public void getMediaById() {
        Media media = instagram.mediaOperations().getMedia("862208752007727029_232107512");
        System.out.println("Hura!");
    }

}
