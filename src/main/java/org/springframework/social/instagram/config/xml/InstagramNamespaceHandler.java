package org.springframework.social.instagram.config.xml;

import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.AbstractProviderConfigNamespaceHandler;

/**
 * {@link NamespaceHandler} for Spring Social Instagram
 *
 * @author erusak
 */
public class InstagramNamespaceHandler extends AbstractProviderConfigNamespaceHandler {

    @Override
    protected AbstractProviderConfigBeanDefinitionParser getProviderConfigBeanDefinitionParser() {
        return new InstagramConfigBeanDefinitionParser();
    }

}
