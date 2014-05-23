package com.jgefroh.rms.client.util;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

/**
 * Calculates the strength of a password.
 * @author Joseph Gefroh
 */
public class PasswordStrengthCalculator {

    //////////////////////////////////////////////////
    // Classes
    //////////////////////////////////////////////////
    
    /**
     * @author Joseph Gefroh
     */
    public enum PasswordStrength {
        //////////////////////////////////////////////////
        // Fields
        //////////////////////////////////////////////////
        
        NONE(0),
        WEAK(1),
        MEDIUM(30),
        BETTER(60),
        STRONG(90);
        
        private int strengthThreshold;
        
        
        //////////////////////////////////////////////////
        // Constructors
        //////////////////////////////////////////////////
        
        private PasswordStrength(final int strengthThreshold) {
            this.strengthThreshold = strengthThreshold;
        }

        
        //////////////////////////////////////////////////
        // Methods - Getters
        //////////////////////////////////////////////////
        
        public int getStrengthThreshold() {
            return strengthThreshold;
        }
    }
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PASSWORD_REC_LENGTH = 15;
    
    public static final int HAS_MIN_LENGTH_STRENGTH = 30;
    public static final int HAS_REC_LENGTH_STRENGTH = 60;
    public static final int HAS_DIGIT_STRENGTH = 5;
    public static final int HAS_UPPERCASE_STRENGTH = 10;
    public static final int HAS_LOWERCASE_STRENGTH = 10;
    public static final int HAS_SYMBOL_STRENGTH = 5;
    
    private static final RegExp DIGIT_REGEX = RegExp.compile("[0-9]");
    private static final RegExp UPPERCASE_REGEX = RegExp.compile("[A-Z]");
    private static final RegExp LOWERCASE_REGEX = RegExp.compile("[a-z]");
    private static final RegExp SYMBOL_REGEX = RegExp.compile("[^a-zA-Z0-9]");

    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public PasswordStrengthCalculator() {
    }
    
    
    //////////////////////////////////////////////////
    // Methods - API
    //////////////////////////////////////////////////
    
    /**
     * Calculates and returns the strength of a password.
     * @param password  the password to check
     * @return  a strength rating from 0 to 100 inclusive, with 100 being the strongest
     */
    public int calculateStrength(final String password) {
        int strength = 0;
        if (password != null) {
            strength += getStrengthForLength(password);
            strength += getStrengthForDigit(password);
            strength += getStrengthForUppercase(password);
            strength += getStrengthForLowercase(password);
            strength += getStrengthForSymbols(password);
        }
        return strength;
    }

    public PasswordStrength convertStrengthToCategory(final int strength) {
        PasswordStrength[] categories = PasswordStrength.values();
        PasswordStrength highestMatchingCategory = PasswordStrength.NONE;
        for (PasswordStrength category : categories) {
            int categoryStrength = category.getStrengthThreshold();
            int currentCategoryStrength = highestMatchingCategory.getStrengthThreshold();
            if (strength >= categoryStrength && categoryStrength > currentCategoryStrength) {
                highestMatchingCategory = category;
            }
        }
        
        return highestMatchingCategory;
    }
    
    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////

    private boolean hasMatch(final String value, final RegExp regex) {
        MatchResult matcher = regex.exec(value);
        return matcher != null;
    }
    
    private int getStrengthForSymbols(final String password) {
        return hasMatch(password, SYMBOL_REGEX) ? HAS_SYMBOL_STRENGTH : 0;
    }
    
    private int getStrengthForLowercase(final String password) {
        return hasMatch(password, LOWERCASE_REGEX) ? HAS_LOWERCASE_STRENGTH : 0;
    }
    
    private int getStrengthForUppercase(final String password) {
        return hasMatch(password, UPPERCASE_REGEX) ? HAS_UPPERCASE_STRENGTH : 0;
    }
    
    private int getStrengthForDigit(final String password) {
        return hasMatch(password, DIGIT_REGEX) ? HAS_DIGIT_STRENGTH : 0;
    }

    private int getStrengthForLength(final String password) {
        if (password.length() >= PASSWORD_REC_LENGTH) { 
            return HAS_REC_LENGTH_STRENGTH;
        }
        else if (password.length() >= PASSWORD_MIN_LENGTH) {
            return HAS_MIN_LENGTH_STRENGTH;
        }
        else {
            return 0;
        }
    }
}