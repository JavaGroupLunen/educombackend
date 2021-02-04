package com.educom.server.exception;

public class EducomAuthException extends RuntimeException {
    public EducomAuthException(String exMessage, Exception exception) {
            super(exMessage, exception);
        }

    public EducomAuthException(String exMessage) {
            super(exMessage);
        }
}
