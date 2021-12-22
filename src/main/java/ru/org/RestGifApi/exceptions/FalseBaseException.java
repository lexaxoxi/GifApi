package ru.org.RestGifApi.exceptions;

public class FalseBaseException extends RuntimeException {
    public FalseBaseException(String message) {
        super(message);
    }

    public FalseBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public FalseBaseException(Throwable cause) {
        super(cause);
    }

    public FalseBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
