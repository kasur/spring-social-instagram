package org.springframework.social.config.xml;

import org.springframework.beans.factory.xml.NamespaceHandler;

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
