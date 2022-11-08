package com.bptn.exceptions;

@SuppressWarnings("all")
public class InvalidRequestException extends Exception {

  public InvalidRequestException() {
    super();
  }

  public InvalidRequestException(String msg) {
    super(msg);
  }

  public InvalidRequestException(String msg, Throwable cause) {
    super(msg, cause);
  }
  
  public InvalidRequestException(Throwable cause) {
    super(cause);
  }
}
