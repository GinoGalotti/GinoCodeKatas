package com.ginoprojects.ginocodekatas.firstkata;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by GinoGalotti on 29/05/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 */
public class StringCalculatorTest {


    StringCalculator stringCalculator =
        new StringCalculator();

    @Test public void testAddWithEmpty() {
        int result = -1;
        try {
            result = stringCalculator.add("");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 0);
    }

    @Test public void testAddWithOneValue() {
        int result = -1;
        try {
            result = stringCalculator.add("3");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 3);
    }

    @Test public void testAddWithMoreThanOneValue() {
        String values = "3,2,1";

        int result = -1;
        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 6);
    }

    @Test public void testAddWithMoreThanOneValueAndVariosDigits() {
        String values = "3,2555,1";

        int result = -1;
        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 2559);
    }

    @Test public void testAddWithMoreThanOneValueAndEmptyFinal() {
        String values = "3,2,1,";

        int result = -1;
        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 6);
    }

    @Test public void testAddWithMoreThanOneAndLineBreak() {
        String values = "2,4\n5";

        int result = -1;
        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 11);
    }

    @Test public void testAddWithSpecificDelimiter() {
        String customDelimiter = "//;\n";
        String values = customDelimiter + "2;4;5";

        int result = -1;
        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 11);
    }

    @Test public void testAddWithSpecificKeywordDelimiter() {
        String customDelimiter = "//?\n";
        String values = customDelimiter + "2?4? 5";

        int result = -1;
        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 11);
    }

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test public void testNegativeThrowException() throws NegativeNumberException {
        String values = "2,-4\n5";

        thrown.expect(NegativeNumberException.class);
        thrown.expectMessage("-4");

        stringCalculator.add(values);

    }

    @Test public void testMultipleNegativeThrowException() throws NegativeNumberException {
        String values = "2,-4\n-55";

        thrown.expect(NegativeNumberException.class);
        thrown.expectMessage("-4");
        thrown.expectMessage("-5");

        stringCalculator.add(values);
    }


    @Test public void testAddBigNumber() {
        String values = "2,4\n100000";

        int result = -1;

        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 6);
    }

    @Test public void testAddBigDelimiter() {
        String values = "//[***]\n2***4***5";

        int result = -1;

        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 11);
    }

    @Test public void testAddMultipleDelimiters() {
        String values = "//[*][$]\n2$4*5";

        int result = -1;

        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 11);
    }

    @Test public void testAddMultipleDelimitersWithMultipleCharacters() {
        String values = "//[*][$$$]\n2$$$4*5";

        int result = -1;

        try {
            result = stringCalculator.add(values);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result == 11);
    }


}
