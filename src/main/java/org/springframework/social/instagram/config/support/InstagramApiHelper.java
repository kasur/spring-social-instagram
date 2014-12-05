package org.springframework.social.instagram.config.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.instagram.api.Instagram;

/**
 * Support class for JavaConfig and XML configuration support.
 * Creates an API binding instance for the current user's connection.
 *
 * @author erusak
 */
public class InstagramApiHelper implements ApiHelper<Instagram> {

    private final UsersConnectionRepository usersConnectionRepository;

    private final UserIdSource userIdSource;

    private InstagramApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
        this.usersConnectionRepository = usersConnectionRepository;
        this.userIdSource = userIdSource;
    }

    public Instagram getApi() {
        if (logger.isDebugEnabled()) {
            logger.debug("Getting API binding instance for Instagram");
        }

        Connection<Instagram> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId())
                .findPrimaryConnection(Instagram.class);

        if (logger.isDebugEnabled() && connection == null) {
            logger.debug("No current connection; Returning default InstagramTemplate instance.");
        }
        if (connection == null) {
            throw new IllegalArgumentException("[Instagram template without client id is not supported. As there is no user connection return null]");
        }
        return connection.getApi();
    }

    private final static Log logger = LogFactory.getLog(InstagramApiHelper.class);
}
