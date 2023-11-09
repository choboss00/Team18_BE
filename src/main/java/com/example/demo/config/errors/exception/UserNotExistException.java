package com.example.demo.config.errors.exception;

import com.example.demo.config.errors.ErrorCode;
import lombok.Getter;

@Getter
public class UserNotExistException extends RuntimeException {
    public final ErrorCode errorCode;

    public UserNotExistException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
