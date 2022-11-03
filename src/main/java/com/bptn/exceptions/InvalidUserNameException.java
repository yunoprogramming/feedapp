package com.bptn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidUserNameException extends Exception {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public InvalidUserNameException() {
        super();
    }

    public InvalidUserNameException(String errorMessage) {
        logger.debug(errorMessage);
    }
}
