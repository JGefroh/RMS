package com.jgefroh.rms.client.util.ruleengine;

import java.util.Map;


/**
 * Encapsulates business rules.
 * @author Joseph Gefroh
 * @param <T>   the type of target object the business rule evaluates against
 */
public interface BusinessRule<T> {

    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    
    /**
     * The result of a business rule execution.
     * @author Joseph Gefroh
     */
    public enum Result {
        /**The target passed the rule evaluation.*/
        PASS,
        
        /**The target failed the rule evaluation.*/
        FAIL,
        
        /**The target was not evaluated.*/
        SKIP;

        
        /**
         * A marker interface that identifies specific failure/success reasons.
         * @author Joseph Gefroh
         */
        public interface Code {
        }
    }

    /**
     * A marker interface that identifies a specific rule.
     * @author Joseph Gefroh
     */
    public interface RuleID {
    }
    
    public interface ContextID {
    }

    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    /**
     * Checks to see if the rule is applicable to the target given the context.
     * @param target    the target object
     * @param context   the context
     * @return  true if applicable; false otherwise
     */
    boolean isApplicable(T target, Map<ContextID, Object> context);
    
    /**
     * Executes the rule against the passed object.
     * @param target    the object to evaluate
     * @return  an evaluation result 
     */
    BusinessRuleResult execute(T target);

    /**
     * Gets the rule ID.
     * @return  the rule ID
     */
    RuleID getID();

}
