package com.libraryapi.exceptions.authorExceptions;

public class ExistingAuthorException extends RuntimeException {
    public ExistingAuthorException(String message) {
        super(message);
    }
}
