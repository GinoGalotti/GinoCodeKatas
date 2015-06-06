package com.ginoprojects.ginocodekatas.stringcalculatorkata.firstround;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by GinoGalotti on 30/05/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 */
public class DelimiterHandler {
    private static final String DEFAULT_DELIMITER_CHARACTERS = ",|\n";
    private static final String USER_DELIMITER_REGEX_PATTERN = "^//((.)|(\\[(.+?)\\])+)\n(.*)";
    private static final int REGEX_GROUP_CUSTOM_SINGLE_CHARACTER_DELIMITER = 2;
    private static final int REGEX_GROUP_VALUES = 5;
    public static final String MULTIPLE_DELIMTER_REGEX = "\\[(.+?)\\]";
    public static final String OR_REGEX_CHARACTER = "|";
    public static final int REGEX_CUSTOM_PARAMETERS_GROUP = 1;
    public static final int REGEX_MEMBER_CUSTOM_PARAMETER_GROUP = 1;

    public static String[] getNumberString(String values)
    {
        Matcher match = Pattern.compile(USER_DELIMITER_REGEX_PATTERN).matcher(values);

        String delimiter = getCustomDelimiterOrDefault(match);
        values = getValuesWithoutCustomDelimiter(match.reset(), values);

        return splitValues(values, delimiter);
    }

    private static String getValuesWithoutCustomDelimiter(Matcher match, String values) {
        if (match.find())
            return match.group(REGEX_GROUP_VALUES);
        else
            return values;
    }

    private static String getCustomDelimiterOrDefault(Matcher match) {
        if (match.find())
            return getDelimiter(match);
        else
            return DEFAULT_DELIMITER_CHARACTERS;

    }

    private static String getDelimiter(Matcher match) {
        if (userDefinedSingleDelimiter(match))
            return getCustomSingleDelimiter(match);
        else
            return getCustomMultipleDelimiter(match);
    }

    private static String getCustomMultipleDelimiter(Matcher match) {
        String delimiters = match.group(REGEX_CUSTOM_PARAMETERS_GROUP);
        Matcher delimiterMatcher = Pattern.compile(MULTIPLE_DELIMTER_REGEX).matcher(delimiters);

        StringBuffer everyCustomDelimiter = new StringBuffer();

        while (delimiterMatcher.find())
        {
            addUserDefinedDelimiter(everyCustomDelimiter,
                delimiterMatcher.group(REGEX_MEMBER_CUSTOM_PARAMETER_GROUP));
        }

        return everyCustomDelimiter.toString();
    }

    private static void addUserDefinedDelimiter(StringBuffer everyCustomDelimiter, String delimiter) {
        if (everyCustomDelimiter.length() == 0)
            everyCustomDelimiter.append(Pattern.quote(delimiter));
        else
            everyCustomDelimiter.append(OR_REGEX_CHARACTER).append(Pattern.quote(delimiter));
    }

    private static String getCustomSingleDelimiter(Matcher match) {
        return Pattern.quote(match.group(REGEX_GROUP_CUSTOM_SINGLE_CHARACTER_DELIMITER));
    }

    private static boolean userDefinedSingleDelimiter(Matcher match) {
        return match.group(REGEX_GROUP_CUSTOM_SINGLE_CHARACTER_DELIMITER) != null;
    }

    private static String[] splitValues(String values, String delimiters) {
        if (values.isEmpty())
            return new String[0];
        else
            return values.split(delimiters);
    }
}
