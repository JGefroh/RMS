package com.jgefroh.rms.client.util.ruleengine;

import java.util.Map;

import com.jgefroh.rms.client.util.ruleengine.BusinessRule.ContextID;
import com.jgefroh.rms.client.util.ruleengine.BusinessRule.RuleID;

/**
 * Interface for a business rule engine.
 * @author Joseph Gefroh
 * @param <T>   the type of object that the rule is being evaluated
 * @param <S>   the type of context that surrounds the object
 */
public interface BusinessRuleEngine<T> {
    Map<RuleID, BusinessRuleResult> evaluate(T object);
}
