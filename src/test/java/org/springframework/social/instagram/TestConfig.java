package org.springframework.social.instagram;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.UserIdSource;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.impl.InstagramTemplate;
import org.springframework.social.security.AuthenticationNameUserIdSource;

/**
 * @author erusak.
 */
@Configuration
public class TestConfig {

    @Bean(name = "no-auth-template")
    Instagram defaultInstagramTemplate() {
        return new InstagramTemplate("d3f9bd756a52411c836b4346c7ba948d", "0e11301a4a524ca08fa1040dbe2e335c");
    }

    @Bean(name = "usersConnectionRepository")
    UsersConnectionRepository connectionRepo(ConnectionFactoryLocator locator) {
        return new InMemoryUsersConnectionRepository(locator);
    }

    @Bean
    UserIdSource userIdSource() {
        return new AuthenticationNameUserIdSource();
    }
}
