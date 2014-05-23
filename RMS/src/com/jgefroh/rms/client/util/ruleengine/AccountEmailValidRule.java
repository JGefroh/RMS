package com.jgefroh.rms.client.util.ruleengine;

import java.util.Map;

import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.util.models.EmailAddress;
import com.jgefroh.rms.client.util.models.EmailAddress.EmailValidationFailure;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.ContextID;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.Result.Code;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.RuleID;
import com.jgefroh.rms.client.util.validation.interfaces.ValidationResult;
import com.jgefroh.rms.client.util.validation.interfaces.ValidationFailure;

/**
 * Defines the following business rules:
 * An account's email must be formatted as follows: account@domain
 * @author Joseph Gefroh
 */
public class AccountEmailValidRule implements BusinessRule<AccountDTO>{
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    public enum BusinessRuleID implements RuleID {
        ID;
    }
    
    public enum ReasonCode implements Code {
        TOO_SHORT,
        BAD_FORMAT;
    }

    @Override
    public boolean isApplicable(final AccountDTO target, final Map<ContextID, Object> context) {
        if (target != null) {
            return true;
        }
        return false;
    }

    @Override
    public BusinessRuleResult execute(final AccountDTO target) {
        EmailAddress email = new EmailAddress(target.getEmail());
        ValidationResult validationResult = email.validate();
        if (validationResult.isInvalid()) {
            ValidationFailure validationFailure = validationResult.getFailure();
            if (EmailValidationFailure.TOO_SHORT.equals(validationFailure)) {
                return BusinessRuleResult.createFail(BusinessRuleID.ID, ReasonCode.TOO_SHORT, "The email address was too short.");
            }
            else if (EmailValidationFailure.BAD_FORMAT.equals(validationFailure)) {
                return BusinessRuleResult.createFail(BusinessRuleID.ID, ReasonCode.BAD_FORMAT, "The email address was formatted improperly.");
            }
            return BusinessRuleResult.createFail(BusinessRuleID.ID, null, null);
        }
        else {
            return BusinessRuleResult.createPass(BusinessRuleID.ID);
        }
    }

    @Override
    public RuleID getID() {
        return BusinessRuleID.ID;
    }
}
