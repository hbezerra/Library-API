package com.libraryapi.exceptions.categoryExceptions;

public class ExistingCategoryException extends RuntimeException {
    public ExistingCategoryException(String message) {
        super(message);
    }
}
