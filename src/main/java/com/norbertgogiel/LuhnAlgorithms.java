package com.norbertgogiel;

public class LuhnAlgorithms {

    /**
     * A private constructor.
     */
    private LuhnAlgorithms() {}

    /**
     * This method accepts a number as String and checks if it
     * is valid Luhn number.
     *
     * The number has to be numeric and be equal to or smaller
     * than {@link Long#MAX_VALUE}.
     *
     * The method parses the String to long and passes the
     * value to {@link #calculateLuhnCheck(long)}
     *
     * @param number as String
     * @throws NumberFormatException if the String contains
     * any other ASCII characters than numbers or if the number
     * is greater than {@link Long#MAX_VALUE}
     * @return a boolean indicating if the number is a valid Luhn number
     */
    public static boolean isValid(String number) {
        return isValid(Long.parseLong(number));
    }

    /**
     * This method accepts a number as long checks if it
     * is valid Luhn number.
     *
     * The number has to be numeric and be equal to or smaller
     * than {@link Long#MAX_VALUE}.
     *
     * The method passes the value to {@link #calculateLuhnCheck(long)}
     *
     * @param number as long
     * @return a boolean indicating if the number is a valid Luhn number
     */
    public static boolean isValid(long number) {
        return calculateLuhnCheck(number) % 10 == 0;
    }

    private static long calculateLuhnCheck(long number) {
        long sum = 0;
        long multiplier = 2;
        do {
            long lastDigit = number % 10;
            number /= 10;
            long product = lastDigit * multiplier;
            sum += product > 9 ? product - 9 : product;
            multiplier = 3 - multiplier;
        } while (number > 0);
        return sum;
    }
}
