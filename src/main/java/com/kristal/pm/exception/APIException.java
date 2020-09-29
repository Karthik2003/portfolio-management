package com.kristal.pm.exception;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Set;
import java.util.stream.Collectors;


@Getter
public class APIException extends RuntimeException{
    private final HttpStatus httpStatusCode;
    private Set<APIErrors> errors;
    protected String message;

    public APIException(HttpStatus httpStatusCode, Set<APIErrors> errors){
        super();
        this.httpStatusCode = httpStatusCode;
        this.message = formatException(errors);
    }

    private String formatException(Set<APIErrors> errors){
        return errors.stream().map(error -> error.getCode() + " : " + error.getMessage()).collect(Collectors.joining(","));
    }

    public static APIException badRequest(String code, String message) {
        Set<APIErrors> errors = Sets.newHashSet();
        errors.add(new APIErrors(code, message));
        return new APIException(HttpStatus.BAD_REQUEST, errors);
    }

    public static APIException notFound(String code, String message) {
        Set<APIErrors> errors = Sets.newHashSet();
        errors.add(new APIErrors(code, message));
        return new APIException(HttpStatus.NOT_FOUND, errors);
    }

    public static APIException unAuthorizedRequest(String code, String message) {
        Set<APIErrors> errors = Sets.newHashSet();
        errors.add(new APIErrors(code, message));
        return new APIException(HttpStatus.UNAUTHORIZED, errors);
    }

    public static APIException internalError(String code, String message) {
        Set<APIErrors> errors = Sets.newHashSet();
        errors.add(new APIErrors(code, message));
        return new APIException(HttpStatus.INTERNAL_SERVER_ERROR, errors);
    }

}
