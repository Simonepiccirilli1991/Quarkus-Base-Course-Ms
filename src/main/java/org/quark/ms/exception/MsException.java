package org.quark.ms.exception;

import lombok.Data;

@Data
public class MsException extends RuntimeException{

    private String code;

    public MsException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}
