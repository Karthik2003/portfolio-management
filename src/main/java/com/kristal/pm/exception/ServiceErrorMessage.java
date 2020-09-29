package com.kristal.pm.exception;

import lombok.Getter;

@Getter
public enum ServiceErrorMessage {
    ACCOUNT_ID_NOT_FOUND("ACC0001", "Account ID Not Found"),
    USER_NOT_FOUND("USR0001", "User Not Found"),
    UNEXPECTED_ERROR("ERR0001", "%s");

    private final String errorCode;
    private final String errorDesc;

    ServiceErrorMessage(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
}
