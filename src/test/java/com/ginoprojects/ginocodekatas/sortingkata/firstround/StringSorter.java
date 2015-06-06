package com.ginoprojects.ginocodekatas.sortingkata.firstround;

/**
 * Created by GinoGalotti on 04/06/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 */
public class StringSorter {

    public static String sortString(String stringToSort) {
        StringBuilder pendingToSort = new StringBuilder(stringToSort.toLowerCase());
        StringBuilder sortedString = new StringBuilder();

        while (pendingToSort.length() > 0) {
            char firstChar = pendingToSort.charAt(0);

            if (isBetweenAZ(firstChar)) {

                boolean lookingForPosition = true;
                int indexToCompare = 0;
                while (lookingForPosition && indexToCompare < sortedString.length()) {
                    char toCompare = sortedString.charAt(indexToCompare);
                    if (toCompare > firstChar) {

                        sortedString.insert(indexToCompare, charMultiplyNTimes(firstChar,
                            ocurrencesInTheSting(pendingToSort.toString(),
                                String.valueOf(firstChar))));
                        lookingForPosition = false;
                    }
                    indexToCompare++;

                }

                if (lookingForPosition)
                    sortedString.append(charMultiplyNTimes(firstChar,
                        ocurrencesInTheSting(pendingToSort.toString(), String.valueOf(firstChar))));

            }

            deleteAllOcurrences(pendingToSort, String.valueOf(firstChar));

        }

        return sortedString.toString();
    }

    public static void deleteAllOcurrences(StringBuilder sb, String toDelete) {
        int index;
        while ((index = sb.lastIndexOf(toDelete)) != -1) {
            sb.replace(index, index + toDelete.length(), "");
        }
    }

    private static String charMultiplyNTimes(char currentChar, int ocurrences) {
        return new String(new char[ocurrences]).replace('\0', currentChar);
    }

    private static int ocurrencesInTheSting(String stringToSort, String toLook) {
        return stringToSort.length() - stringToSort.replaceAll(toLook, "").length();
    }

    private static boolean isBetweenAZ(char currentChar) {
        return (currentChar >= 'a' && currentChar <= 'z');
    }

}
