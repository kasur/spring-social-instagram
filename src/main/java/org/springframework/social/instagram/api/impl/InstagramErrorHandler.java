package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.ApiException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.instagram.api.InstagramApiException;
import org.springframework.social.instagram.api.impl.json.InstagramModule;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Subclass of {@link DefaultResponseErrorHandler} that handles errors from Instagram APIs
 * interpreting them into appropriate exceptions.
 * @author erusak
 */
public class InstagramErrorHandler extends DefaultResponseErrorHandler {

    private final static Log logger = LogFactory.getLog(InstagramErrorHandler.class);

    private final static String INSTAGRAM = "instagram";


    private static final ObjectMapper exceptionsMapper;

    static {
        exceptionsMapper = new ObjectMapper();
        exceptionsMapper.registerModule(new InstagramModule());
    }


    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw extractException(response);
    }


    private ApiException extractException(final ClientHttpResponse response) {
        try {
            InputStream rawStream = response.getBody();

            Map<String,InputStream> map = exceptionsMapper.readValue(rawStream, new TypeReference<Map<String, InputStream>>(){});

            return exceptionsMapper.readValue(map.get("meta"), InstagramApiException.class);

        } catch (Throwable any) {
            logger.warn("[Exception occurred while deserializing response]", any);
            return new UncategorizedApiException(INSTAGRAM, "[Cannot categorize exception from response]", any);
        }
    }

}
