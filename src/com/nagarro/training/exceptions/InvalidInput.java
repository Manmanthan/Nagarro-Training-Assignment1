package com.nagarro.training.exceptions;

public class InvalidInput extends RuntimeException {
    public InvalidInput(String message) {
        super(message);
    }

    public InvalidInput() {
    }
}
