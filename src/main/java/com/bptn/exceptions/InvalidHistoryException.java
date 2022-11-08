package com.bptn.exceptions;

@SuppressWarnings("all")
public class InvalidHistoryException extends Exception {

    public InvalidHistoryException() {
        super();
      }
    
      public InvalidHistoryException(String msg) {
        super(msg);
      }
    
      public InvalidHistoryException(String msg, Throwable cause) {
        super(msg, cause);
      }
      
      public InvalidHistoryException(Throwable cause) {
        super(cause);
      }
    
}
