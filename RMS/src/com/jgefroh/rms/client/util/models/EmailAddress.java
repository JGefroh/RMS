package com.jgefroh.rms.client.util.models;

import java.io.Serializable;

import com.jgefroh.rms.client.util.validation.interfaces.Validatable;
import com.jgefroh.rms.client.util.validation.interfaces.ValidationFailure;
import com.jgefroh.rms.client.util.validation.interfaces.ValidationResult;

/**
 * @author Joseph Gefroh
 */
public class EmailAddress implements Serializable, Validatable {
    
    public enum EmailValidationFailure implements ValidationFailure {
        TOO_SHORT("Emails must be at least 3 characters long."),
        BAD_FORMAT("Emails must be formatted as: 'account@domain'.");
        
        private String errorMessage;
        
        private EmailValidationFailure(final String errorMessage) {
            this.errorMessage = errorMessage;
        }
        
        @Override
        public String getErrorMessage() {
            return this.errorMessage;
        }
    }
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////

    private static final long serialVersionUID = -2390008761890172643L;
    private String emailAddress;


    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public EmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    
    //////////////////////////////////////////////////
    // Methods 
    //////////////////////////////////////////////////

    @Override
    public ValidationResult validate() {
        if (emailAddress == null) {
            return ValidationResult.notPresent();
        }
        
        if (!hasMinimumLength()) {
            return ValidationResult.invalid(EmailValidationFailure.TOO_SHORT);
        }
        
        if (!hasComponents()) {
            return ValidationResult.invalid(EmailValidationFailure.BAD_FORMAT);
        }
        
        return ValidationResult.valid();
    }


    //////////////////////////////////////////////////
    // Methods - Validation
    //////////////////////////////////////////////////

    private boolean hasMinimumLength() {
        return emailAddress != null && emailAddress.length() >= 3;
    }

    private boolean hasComponents() {
        if (emailAddress == null) {
            return false;
        }
        
        if (emailAddress.indexOf('@') != emailAddress.lastIndexOf('@')) {
            return false;
        }
        
        String[] parts = emailAddress.split("@");
        if (parts.length != 2) {
            return false;
        }
        return true;
    }
    
    public static String getErrorMessage(final ValidationResult result) {
        ValidationFailure failure = result.getFailure();
        return failure.getErrorMessage();
    }
    

    //////////////////////////////////////////////////
    // Methods - Getters 
    //////////////////////////////////////////////////

    public String getEmailAddress() {
        return this.emailAddress;
    }
}