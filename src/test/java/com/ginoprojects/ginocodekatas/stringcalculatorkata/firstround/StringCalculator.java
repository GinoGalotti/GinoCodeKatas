package com.ginoprojects.ginocodekatas.stringcalculatorkata.firstround;

import java.util.ArrayList;

/**
 * Created by GinoGalotti on 29/05/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 */
public class StringCalculator {

    private static final int MAXIMUM_VALUE = 10000;

    public class ErrorMessage {
        public static final String ERROR_STARTING_PHRASE = "Negative numbers not supported:";
        private ArrayList<Integer> negativeValues = new ArrayList<Integer>();

        public boolean hasErrors() {
            return !negativeValues.isEmpty();
        }

        public void addNegativeNumber(int negativeValue) {
            negativeValues.add(negativeValue);
        }

        public String getErrorMessage() {
            return hasErrors() ? ERROR_STARTING_PHRASE + negativeValues.toString() : "";
        }
    }

    public int add(String values) throws NegativeNumberException {
        return getAddition(DelimiterHandler.getNumberString(values));
    }

    private int getAddition(String[] values) throws NegativeNumberException {
        int result = 0;
        ErrorMessage errorMessage = new ErrorMessage();

        for (String currentValue : values) {
            if (!currentValue.isEmpty()) {
                int numericalValue = Integer.valueOf(currentValue.trim());
                if (numericalValue > 0) {
                    if (numericalValue <= MAXIMUM_VALUE)
                        result += numericalValue;
                } else
                    errorMessage.addNegativeNumber(numericalValue);
            }
        }

        if (errorMessage.hasErrors())
            throw new NegativeNumberException(errorMessage.getErrorMessage());

        return result;
    }


}
