package io.github.daviddeveloperbr.crudusers.exception;

public class EmailException extends RuntimeException {

    public EmailException(String message) {
        super("E-mail já está cadastrado.");
    }

}
