package com.example.SimplestCRUDExample.Exception;

public class CustomServiceError {
    private final int code;
    private final String message;

    private CustomServiceError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Builder create(int code) {
        return new Builder(code);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "{code=" + this.code + ", message='" + this.message + '\'' + '}';
    }

    public static final class Builder {
        private final int code;
        private String message;

        public Builder(int code) {
            this.code = code;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public CustomServiceError build() {
            return new CustomServiceError(this.code, this.message);
        }
    }
}
