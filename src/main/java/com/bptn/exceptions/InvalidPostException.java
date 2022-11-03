package com.bptn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidPostException extends Exception {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public InvalidPostException() {
        super();
    }

    public InvalidPostException(String errorMessage) {
        logger.debug(errorMessage);
    }
}
