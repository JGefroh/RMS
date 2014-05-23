package com.jgefroh.rms.client.util.validation.interfaces;

import java.io.Serializable;


/**
 * Wraps the result of a validation.
 * @author Joseph Gefroh
 */
public class ValidationResult implements Serializable {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    public enum ValidationResultCode {
        VALID,
        INVALID,
        NOT_PRESENT;
    }

    private ValidationResultCode result;
    private ValidationFailure reason;

    private static final long serialVersionUID = -6660773619091338863L;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    private ValidationResult(ValidationResultCode result) {
        this.result = result;
    }
    
    private ValidationResult (ValidationResultCode result, ValidationFailure validationFailure) {
        this.result = result;
        this.reason = validationFailure;
    }
    
    /**
     * Creates an INVALID result with the given reason.
     * @param validationFailure    the reason the result is invalid
     * @return  the result
     */
    public static ValidationResult invalid(final ValidationFailure validationFailure) {
        return new ValidationResult(ValidationResultCode.INVALID, validationFailure);
    }
    
    /**
     * Creates a VALID result.
     * @return  the result
     */
    public static ValidationResult valid() {
        return new ValidationResult(ValidationResultCode.VALID);
    }
    
    /**
     * Creates a NOT_PRESENT result.
     * @return  the result
     */
    public static ValidationResult notPresent() {
        return new ValidationResult(ValidationResultCode.NOT_PRESENT);
    }
    
    
    //////////////////////////////////////////////////
    // Getters
    //////////////////////////////////////////////////
    
    /**
     * Gets the result of a validation. This is guaranteed to not be null.
     * @return  the result of a validation
     */
    public ValidationResultCode getCode() {
        return this.result;
    }
    
    /**
     * Gets the reason for a validation. Only INVALID results can have a reason.
     * @return  the reason
     */
    public ValidationFailure getFailure() {
        return this.reason;
    }

    public boolean isInvalid() {
       return ValidationResultCode.INVALID.equals(this.result);
    }

    public boolean isPresent() {
       return !ValidationResultCode.NOT_PRESENT.equals(this.result);
    }
    
    public boolean isValid() {
       return ValidationResultCode.VALID.equals(this.result);
    }
}
