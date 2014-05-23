package com.jgefroh.rms.client.util.ruleengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jgefroh.rms.client.util.ruleengine.BusinessRule.ContextID;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.RuleID;

/**
 * This rule engine provides default behaviour to execute business rules.
 * 
 * Subclasses are required to provide rules and the operation context by overriding getContext().
 * @author Joseph Gefroh
 * @param <T>   the type of object this rule targets
 */
public abstract class AbstractBusinessRuleEngine<T> implements BusinessRuleEngine<T> {

    private List<BusinessRule<T>> rules = new ArrayList<BusinessRule<T>>();
    
    @Override
    public Map<RuleID, BusinessRuleResult> evaluate(final T object) {
        Map<RuleID, BusinessRuleResult> results = new HashMap<RuleID, BusinessRuleResult>();
        for (BusinessRule<T> rule : rules) {
            BusinessRuleResult result = null;
            result = rule.isApplicable(object, getContext()) ? rule.execute(object) : BusinessRuleResult.createSkip(rule.getID());
            results.put(result.getRuleID(), result);
        }
        return results;
    }
    
    public void add(final BusinessRule<T> rule) {
        rules.add(rule);
    }
    
    public boolean hasBrokenRules(final Map<RuleID, BusinessRuleResult> results) {
        Set<RuleID> ids = results.keySet();
        for (RuleID id : ids) {
            if (results.get(id).isFail()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the context of this rule engine
     * @return  the values this engine's rules might need
     */
    public abstract Map<ContextID, Object> getContext();
    
    
}
