/**
 * Created by GinoGalotti on 30/05/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 *
 * SECOND ROUND:
 *
 * With this Kata I aim training:
 *      .TDD discipline, forcing myself to write always before the tests.
 *      .Regex good practices.
 *      .Refactoring code using IntellIJ shortcuts.
 *
 * Changes from the previous one:
 *      .Strictly following TDD principles. I can't write more than the neccesary in order to pass the test.
 *      .Improving regex.
 *
 * Time spent:
 * Improvements since the last one:
 *
 * In this package you can find a sample Kata that I use to keep in shape. I've took it from http://osherove.com/tdd-kata-1/, and here is the explanation:
 *
 * STRING CALCULATOR
 * 1. Create a simple String calculator with a method int Add(string numbers)\
 *      .The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
 *      .Start with the simplest test case of an empty string and move to 1 and two numbers
 *      .Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
 *      .Remember to refactor after each passing test
 * 2. Allow the Add method to handle an unknown amount of numbers
 * 3. Allow the Add method to handle new lines between numbers (instead of commas).
 *      .The following input is ok:  “1\n2,3”  (will equal 6)
 *      .The following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)
 * 4. Support custom Delimiters
 *      .To change a delimiter, the beginning of the string will contain a separate line that looks like this:
 *          “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
 *      .The first line is optional. all existing scenarios should still be supported
 * 5. Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.if there are multiple negatives,
 *  show all of them in the exception message
 * 6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2
 * 7. Delimiters can be of any length with the following format:  “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
 * 8. Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
 * 9. Make sure you can also handle multiple delimiters with length longer than one char
 */
package com.ginoprojects.ginocodekatas.stringcalculatorkata.secondround;
