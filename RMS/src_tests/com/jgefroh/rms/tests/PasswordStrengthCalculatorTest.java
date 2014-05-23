package com.jgefroh.rms.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jgefroh.rms.client.util.PasswordStrengthCalculator;
import com.jgefroh.rms.client.util.PasswordStrengthCalculator.PasswordStrength;

/**
 * @author Joseph Gefroh
 */
public class PasswordStrengthCalculatorTest {

    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    private PasswordStrengthCalculator calc;

    
    //////////////////////////////////////////////////
    // Setup
    //////////////////////////////////////////////////
    
    @Before
    public void setup() {
        calc = new PasswordStrengthCalculator();
    }
    
    
    //////////////////////////////////////////////////
    // Tests - Sanity
    //////////////////////////////////////////////////
    
    @Test
    public void test_numbers() {
        int strength = calc.calculateStrength("123");
        assertTrue(strength == PasswordStrengthCalculator.HAS_DIGIT_STRENGTH);
    }
    
    @Test
    public void test_uppercase() {
        int strength = calc.calculateStrength("ABC");
        assertTrue(strength == PasswordStrengthCalculator.HAS_UPPERCASE_STRENGTH);
    }
    
    @Test
    public void test_lowercase() {
        int strength = calc.calculateStrength("abc");
        assertTrue(strength == PasswordStrengthCalculator.HAS_LOWERCASE_STRENGTH);
    }
    
    @Test
    public void test_symbols() {
        int strength = calc.calculateStrength("!@#");
        assertTrue(strength == PasswordStrengthCalculator.HAS_SYMBOL_STRENGTH);
    }

    @Test
    public void test_lengthminwithdigits() {
        int strength = calc.calculateStrength("00000000");
        assertTrue(strength == PasswordStrengthCalculator.HAS_MIN_LENGTH_STRENGTH + PasswordStrengthCalculator.HAS_DIGIT_STRENGTH);
    }
    
    
    //////////////////////////////////////////////////
    // Tests - Password Strength
    //////////////////////////////////////////////////
    
    @Test
    public void test_smallLowercaseWord_expect_combinedStrength() {
        int strength = calc.calculateStrength("hello");
        assertTrue(strength == PasswordStrengthCalculator.HAS_LOWERCASE_STRENGTH);
    }
    
    @Test
    public void test_largeLowercaseWord_expect_combinedStrength() {
        int strength = calc.calculateStrength("alphabetical");
        assertTrue(strength == PasswordStrengthCalculator.HAS_LOWERCASE_STRENGTH + PasswordStrengthCalculator.HAS_MIN_LENGTH_STRENGTH);
    }
    
    @Test
    public void test_largeMixedcaseWord_expect_combinedStrength() {
        int strength = calc.calculateStrength("ALPHAbetical");
        assertTrue(strength == PasswordStrengthCalculator.HAS_LOWERCASE_STRENGTH + PasswordStrengthCalculator.HAS_UPPERCASE_STRENGTH + PasswordStrengthCalculator.HAS_MIN_LENGTH_STRENGTH);
    }
    
    @Test
    public void test_smallMixedcaseWord_expect_combinedStrength() {
        int strength = calc.calculateStrength("alPHA");
        assertTrue(strength == PasswordStrengthCalculator.HAS_LOWERCASE_STRENGTH + PasswordStrengthCalculator.HAS_UPPERCASE_STRENGTH);
    }
    
    @Test
    public void test_smallNumbers_expect_combinedStrength() {
        int strength = calc.calculateStrength("9494");
        assertTrue(strength == PasswordStrengthCalculator.HAS_DIGIT_STRENGTH);
    }
    
    @Test
    public void test_largeNumbers_expect_combinedStrength() {
        int strength = calc.calculateStrength("94912521324");
        assertTrue(strength == PasswordStrengthCalculator.HAS_DIGIT_STRENGTH + PasswordStrengthCalculator.HAS_MIN_LENGTH_STRENGTH);
    }
    
    @Test
    public void test_smallNumbersSymbols_expect_combinedStrength() {
        int strength = calc.calculateStrength("$!@(2521324");
        assertTrue(strength == PasswordStrengthCalculator.HAS_DIGIT_STRENGTH + PasswordStrengthCalculator.HAS_MIN_LENGTH_STRENGTH + PasswordStrengthCalculator.HAS_SYMBOL_STRENGTH);
    }
    
    @Test
    public void test_largeMixedcaseNumbersSymbols_expect_combinedStrength() {
        int strength = calc.calculateStrength("Password1!");
        assertTrue(strength == PasswordStrengthCalculator.HAS_DIGIT_STRENGTH + PasswordStrengthCalculator.HAS_MIN_LENGTH_STRENGTH + PasswordStrengthCalculator.HAS_SYMBOL_STRENGTH + PasswordStrengthCalculator.HAS_LOWERCASE_STRENGTH + PasswordStrengthCalculator.HAS_UPPERCASE_STRENGTH);
    }
    
    
    //////////////////////////////////////////////////
    // Tests - Password Strength Conversion
    //////////////////////////////////////////////////

    //Test None
    @Test
    public void test_strengthConversionWithNone_expect_none() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.NONE.getStrengthThreshold());
        assertEquals(PasswordStrength.NONE, strength);
    }
    
    @Test
    public void test_strengthConversionWithNoneMinus1_expect_none() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.NONE.getStrengthThreshold() - 1);
        assertEquals(PasswordStrength.NONE, strength);
    }
    
    @Test
    public void test_strengthConversionWithNonePlus1_expect_weak() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.NONE.getStrengthThreshold() + 1);
        assertEquals(PasswordStrength.WEAK, strength);
    }
    
    //Test weak
    @Test
    public void test_strengthConversionWithWeak_expect_weak() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.WEAK.getStrengthThreshold());
        assertEquals(PasswordStrength.WEAK, strength);
    }
    
    @Test
    public void test_strengthConversionWithWeakMinus1_expect_none() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.WEAK.getStrengthThreshold() - 1);
        assertEquals(PasswordStrength.NONE, strength);
    }
    
    @Test
    public void test_strengthConversionWithWeakPlus1_expect_weak() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.WEAK.getStrengthThreshold() + 1);
        assertEquals(PasswordStrength.WEAK, strength);
    }
    
    
    //Test Medium
    @Test
    public void test_strengthConversionWithMedium_expect_Medium() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.MEDIUM.getStrengthThreshold());
        assertEquals(PasswordStrength.MEDIUM, strength);
    }

    @Test
    public void test_strengthConversionWithMediumMinus1_expect_weak() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.MEDIUM.getStrengthThreshold() - 1);
        assertEquals(PasswordStrength.WEAK, strength);
    }
    
    @Test
    public void test_strengthConversionWithMediumPlus1_expect_medium() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.MEDIUM.getStrengthThreshold() + 1);
        assertEquals(PasswordStrength.MEDIUM, strength);
    }
    
    //Test Better
    @Test
    public void test_strengthConversionWithBetter_expect_better() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.BETTER.getStrengthThreshold());
        assertEquals(PasswordStrength.BETTER, strength);
    }

    @Test
    public void test_strengthConversionWithBetterMinus1_expect_medium() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.BETTER.getStrengthThreshold() - 1);
        assertEquals(PasswordStrength.MEDIUM, strength);
    }
    
    @Test
    public void test_strengthConversionWithBetterPlus1_expect_better() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.BETTER.getStrengthThreshold() + 1);
        assertEquals(PasswordStrength.BETTER, strength);
    }

    //Test Strong
    @Test
    public void test_strengthConversionWithStrong_expect_strong() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.STRONG.getStrengthThreshold());
        assertEquals(PasswordStrength.STRONG, strength);
    }
    
    @Test
    public void test_strengthConversionWithStrongMinus1_expect_better() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.STRONG.getStrengthThreshold() - 1);
        assertEquals(PasswordStrength.BETTER, strength);
    }
    
    @Test
    public void test_strengthConversionWithStrongPlus1_expect_strong() {
        PasswordStrength strength = calc.convertStrengthToCategory(PasswordStrength.STRONG.getStrengthThreshold() + 1);
        assertEquals(PasswordStrength.STRONG, strength);
    }
    
    
}
