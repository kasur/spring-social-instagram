package org.springframework.social.api;

import org.springframework.social.ApiException;

/**
 * @author erusak.
 */
public class InstagramApiException extends ApiException {

    private final String code;
    private final String errorType;
    private final String errorMessage;

    public InstagramApiException(String code, String errorType, String errorMessage) {
        super("instagram", String.format("[code: %s, type: %s, message: %s]", code, errorType, errorMessage));
        this.code = code;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
