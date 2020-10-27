package com.example.web_store;

public enum CustomErrors {
    USERNAME_IS_ENGAGED (new CustomException("CE-001", "user with such username already exists")),
    WRONG_USERNAME_OR_PASSWORD (new CustomException("CE-002", "wrong username or password")),
    SHORT_PASSWORD (new CustomException("CE-003", "password is too short")),
    CANNOT_CREATE_USER(new CustomException("CE-004", "can't create user"));

    private CustomException exception;

    CustomErrors(CustomException e) {
        exception = e;
    }


    public CustomException getException() {
        return exception;
    }

    public void setException(CustomException exception) {
        this.exception = exception;
    }
}
