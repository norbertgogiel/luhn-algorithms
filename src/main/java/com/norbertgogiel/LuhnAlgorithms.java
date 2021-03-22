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
     * value to {@link #calculateLuhnSum(long, int)}
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
     * The method passes the value to {@link #calculateLuhnSum(long, int)}
     *
     * @param number as long
     * @return a boolean indicating if the number is a valid Luhn number
     */
    public static boolean isValid(long number) {
        return calculateLuhnSum(number, 1) % 10 == 0;
    }

    public static long generateLuhnFromRange(long lowerBound, long upperBound, int finalLength) {
        int lowerBoundLength = countDigits(lowerBound);
        int upperBoundLength = countDigits(upperBound);
        lowerBound = normaliseBound(false, lowerBound, finalLength - lowerBoundLength - 1);
        upperBound = normaliseBound(true, upperBound, finalLength - upperBoundLength - 1);
        long randomLong = calculateRandom(lowerBound, upperBound);
        long luhnRemainder = calculateLuhnLastDigit(randomLong);
        return (randomLong * 10) + luhnRemainder;
    }

    private static int countDigits(long number) {
        int length = 0;
        long multiplier = 1;
        do {
            length++;
            multiplier *= 10;
        } while (multiplier <= number);
        return length;
    }

    private static long normaliseBound(boolean isUpperBound, long number, int power) {
        do {
            number *= 10;
            if (isUpperBound)
                number += 9;
            power--;
        } while (power > 0);
        return number;
    }

    private static long calculateRandom(long lowerBound, long upperBound) {
        return lowerBound + (long)(Math.random() * (upperBound - lowerBound));
    }

    private static long calculateLuhnLastDigit(long number) {
        long sum = calculateLuhnSum(number, 2);
        return (sum % 10 == 0) ? 0 : 10 - (sum % 10);
    }

    private static long calculateLuhnSum(long number, int multiplier) {
        long sum = 0;
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
