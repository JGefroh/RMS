package com.jgefroh.rms.client.util.ruleengine;

import com.jgefroh.rms.client.util.ruleengine.BusinessRule.Result;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.Result.Code;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.RuleID;

/**
 * Wraps the result of a business rule evaluation.
 * Provides methods to identify a specific rule, its evaluation result, and an associated message/code.
 * @author Joseph Gefroh
 */
public class BusinessRuleResult {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private RuleID id;
    private Result result;
    private Code code;
    private String message;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    private BusinessRuleResult() {
    }
    
    private BusinessRuleResult(final RuleID id, final Result result, final Code code, final String message) {
        this.id = id;
        this.result = result;
        this.message = message;
    }
    
    public static BusinessRuleResult createPass(final RuleID id) {
        return new BusinessRuleResult(id, BusinessRule.Result.PASS, null, null);
    }
    
    public static BusinessRuleResult createFail(final RuleID id, final Code code, final String message) {
        return new BusinessRuleResult(id, BusinessRule.Result.FAIL, code, message);
    }
    
    public static BusinessRuleResult createSkip(final RuleID id) {
        return new BusinessRuleResult(id, BusinessRule.Result.SKIP, null, null);
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    
    public RuleID getRuleID() {
        return id;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Result getResult() {
        return result;
    }
    
    public Code getCode() {
        return code;
    }
    
    public boolean isPass() {
        return BusinessRule.Result.PASS.equals(this.result);
    }
    
    public boolean isFail() {
        return BusinessRule.Result.FAIL.equals(this.result);
    }
    
    public boolean isSkip() {
        return BusinessRule.Result.SKIP.equals(this.result);
    }
}
