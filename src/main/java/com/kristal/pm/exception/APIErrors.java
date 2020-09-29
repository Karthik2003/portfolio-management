package com.kristal.pm.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class APIErrors {
    private String code;
    private String message;
    public APIErrors(String code, String message) {
        this.code = code;
        this.message = message;
    }
}