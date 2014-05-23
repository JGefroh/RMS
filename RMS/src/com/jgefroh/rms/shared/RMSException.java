package com.jgefroh.rms.shared;

/**
 * The application's base exception.
 * @author Joseph Gefroh
 */
public class RMSException extends Exception {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final long serialVersionUID = -7145931197413037074L;


    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    
    public RMSException() {
    }
    
    public RMSException(final String message) {
        super(message);
    }
    
}
