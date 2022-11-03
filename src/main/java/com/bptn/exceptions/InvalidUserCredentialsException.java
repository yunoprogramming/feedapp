package com.bptn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidUserCredentialsException extends Exception {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public InvalidUserCredentialsException() {
        super();
    }

    public InvalidUserCredentialsException(String errorMessage) {
        logger.debug(errorMessage);
    }
}
