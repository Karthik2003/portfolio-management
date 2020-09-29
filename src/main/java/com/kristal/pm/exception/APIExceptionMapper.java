package com.kristal.pm.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class APIExceptionMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<Object> handleCustomException(APIException exception) {
        logStacktrace(exception);
        return new ResponseEntity<>(exception.getErrors(), exception.getHttpStatusCode());
    }

    private void logStacktrace(Exception exception) {
        log.error("Exception Message: {}", exception.getMessage(), exception);
    }
}
