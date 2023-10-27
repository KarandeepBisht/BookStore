package com.example.SimplestCRUDExample.Exception;


import java.text.MessageFormat;

public final class CustomServiceException  extends RuntimeException {
    private final CustomServiceError customServiceError;

    public CustomServiceException(CustomServiceError customServiceError) {
        super(customServiceError.getMessage());
        this.customServiceError = customServiceError;
    }

    public static CustomServiceException badRequest(String message, Object... args) {
        return new CustomServiceException(CustomServiceError.create(400).message(MessageFormat.format(message, args)).build());
    }

    public static CustomServiceException notFound(String message, Object... args) {
        return new CustomServiceException(CustomServiceError.create(404).message(MessageFormat.format(message, args)).build());
    }

    public static CustomServiceException conflict(String message, Object... args) {
        return new CustomServiceException(CustomServiceError.create(409).message(MessageFormat.format(message, args)).build());
    }

    public static CustomServiceException internalError(String message, Object... args) {
        return new CustomServiceException(CustomServiceError.create(500).message(MessageFormat.format(message, args)).build());
    }

    public static CustomServiceException customErrorCodeAndMsg(Integer errorCode, String message, Object... args) {
        return new CustomServiceException(CustomServiceError.create(errorCode).message(MessageFormat.format(message, args)).build());
    }

    public static CustomServiceException recordNotFoundError(String message, Object... args) {
        return new CustomServiceException(CustomServiceError.create(1003).message(MessageFormat.format(message, args)).build());
    }


    public CustomServiceError customServiceError() {
        return this.customServiceError;
    }

    public String toString() {
        return "" + this.customServiceError + "";
    }
}
