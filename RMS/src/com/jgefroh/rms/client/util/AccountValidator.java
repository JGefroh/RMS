package com.jgefroh.rms.client.util;


import java.util.ArrayList;
import java.util.List;

import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.util.models.EmailAddress;
import com.jgefroh.rms.client.util.validation.interfaces.ValidationResult;

/**
 * @author Joseph Gefroh
 */
public class AccountValidator {


    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////    
    
    public AccountValidator() {
    }


    //////////////////////////////////////////////////
    // Methods - API
    //////////////////////////////////////////////////

    public boolean isValid(final AccountDTO account, final boolean validateFormatOnly) {
        ValidationResult emailValidationResult = validateEmail(account.getEmail());
        ValidationResult fullnameValidationResult = validateFullname(account.getFullname());
        ValidationResult nicknameValidationResult = validateNickname(account.getNickname());
        if (validateFormatOnly) {
            return emailValidationResult.isValid();
        }
        else {
            return emailValidationResult.isValid() && fullnameValidationResult.isValid() && nicknameValidationResult.isValid();
        }
    }
    
    public List<ValidationResult> getValidationResults(final AccountDTO account) {
        List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
        validationResults.add(validateEmail(account.getEmail()));
        validationResults.add(validateFullname(account.getFullname()));
        validationResults.add(validateNickname(account.getNickname()));
        return validationResults;
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Validators
    //////////////////////////////////////////////////

    public ValidationResult validateFullname(final String fullname) {
        return checkPresent(fullname);
    }
    
    public ValidationResult validateNickname(final String nickname) {
        return checkPresent(nickname);
    }
    
    public ValidationResult validateEmail(final String email) {
        EmailAddress address = new EmailAddress(email);
        return address.validate();
    }
    
    private ValidationResult checkPresent(final String value) {
        if (value == null || value.isEmpty()) {
            return ValidationResult.notPresent();
        }
        return ValidationResult.valid();
    }
}
