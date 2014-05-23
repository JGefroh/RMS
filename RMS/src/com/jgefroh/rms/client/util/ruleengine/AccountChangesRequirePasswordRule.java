package com.jgefroh.rms.client.util.ruleengine;

import java.util.Map;

import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.Result.Code;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.RuleID;

/**
 * Defines the following business rules:
 * A current password is required when the email address has changed for an account.
 * A current password is required when the new password is entered for an account.
 * @author Joseph Gefroh
 */
public class AccountChangesRequirePasswordRule implements BusinessRule<AccountDTO>{

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    public enum BusinessRuleID implements RuleID {
        ID;
    }
    
    public enum BusinessRuleContextID implements ContextID {
        CURRENT_EMAIL
    }
    public enum ReasonCode implements Code {
        MISSING_CURRENT_PASSWORD;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    @Override
    public boolean isApplicable(final AccountDTO target, final Map<ContextID, Object> context) {
        String email = getCurrentEmailFromContext(context);
        boolean emailChanged = email != null && !email.equals(target.getEmail());
        boolean passwordChanged = target.getNewPassword() != null || target.getRepeatPassword() != null;
        return emailChanged || passwordChanged;
    }

    @Override
    public BusinessRuleResult execute(final AccountDTO target) {
        if (target.getCurrentPassword() == null) {
            return BusinessRuleResult.createFail(BusinessRuleID.ID, ReasonCode.MISSING_CURRENT_PASSWORD, "Current password was not provided.");
        }
        return BusinessRuleResult.createPass(BusinessRuleID.ID);
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////


    private String getCurrentEmailFromContext(Map<com.jgefroh.rms.client.util.ruleengine.BusinessRule.ContextID, Object> context) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public RuleID getID() {
        return BusinessRuleID.ID;
    }
}
