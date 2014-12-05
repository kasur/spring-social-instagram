package org.springframework.social.instagram.config.xml;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.instagram.config.support.InstagramApiHelper;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.instagram.connect.InstagramConnectionFactory;
import org.springframework.social.instagram.security.InstagramAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

import java.util.Map;

/**
 * Implementation of {@link org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser} that creates a {@link InstagramConnectionFactory}.
 * @author Craig Walls
 */
public class InstagramConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

    public InstagramConfigBeanDefinitionParser() {
        super(InstagramConnectionFactory.class, InstagramApiHelper.class);
    }

    @Override
    protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
        return InstagramAuthenticationService.class;
    }

    @Override
    protected BeanDefinition getConnectionFactoryBeanDefinition(String clientId, String clientSecret, Map<String, Object> allAttributes) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder
                .genericBeanDefinition(InstagramConnectionFactory.class)
                .addConstructorArgValue(clientId)
                .addConstructorArgValue(clientSecret);

        if (allAttributes.containsKey("app-scope")) {
            builder.addConstructorArgValue(allAttributes.get("app-scope"));
        }

        return builder.getBeanDefinition();
    }

}
