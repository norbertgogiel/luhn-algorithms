package com.norbertgogiel;

/**
 * This class {@code LuhnAlgorithms} contains methods for performing
 * mathematical operations around Luhn number, such as:
 * <ul>
 *
 * <li>Luhn number validation as parameter is form of either
 * a {@code String} or {@code long}.
 *
 * <li>Luhn number generation of any length up 18.
 * </ul>
 *
 * <p>The number validation relies on mod10 algorithm. A number as
 * {@code long} or {@code String} can be validated.
 *
 * <p>Luhn number generation can be only up to 18 digits long due
 * to {@link Long#MAX_VALUE} limitations. The advantage over most
 * algorithms is that this algorithm does NOT circularly use random
 * number generation until a match is found. It is only using number
 * generation once to find a random in the range provided. It then
 * calculates the final number to pass mod-10 validation making
 * this a much faster algorithm than some of the alternatives.
 *
 * @author      Norbert Gogiel
 */
public final class LuhnAlgorithms {

    /**
     * Private constructor.
     */
    private LuhnAlgorithms() {}

    /**
     * Accepts any number as {@code String} and checks if it is
     * valid Luhn number.
     *
     * <p>The number has to be equal or greater than zero and be
     * equal to or smaller than {@link Long#MAX_VALUE}.
     *
     * <p>The method parses {@code String} to {@code long} and
     * passes the result to {@link #calculateLuhnSum(long, int)}.
     *
     * <p>An exception of type {@code NumberFormatException} is
     * thrown if any of the following situations occurs:
     * <ul>
     *
     * <li>The first argument is {@code null} or is a {@code String}
     * of length zero.
     *
     * <li>The String contains any other ASCII character than
     * numbers.
     *
     * <li>The number is greater than {@link Long#MAX_VALUE}.
     * </ul>
     *
     * @param       number a {@code String} containing a
     *                     representation of the number to be
     *                     parsed and validated
     * @throws      NumberFormatException if the string does not
     *              contain a parsable {@code long}.
     * @return      a {@code boolean} indicator whether the number
     *              is valid Luhn number
     */
    public static boolean isValid(String number) {
        return isValid(Long.parseLong(number));
    }

    /**
     * Accepts an input as {@code long} that is to be validated
     * as Luhn number.
     *
     * <p>The number has to be equal to or greater than zero
     * and be equal to or smaller than {@link Long#MAX_VALUE}.
     *
     * @param       number a {@code long} as a parameter to be
     *                     validated
     * @return      a {@code boolean} indicator whether the
     *              number is valid Luhn number
     */
    public static boolean isValid(long number) {
        return calculateLuhnSum(number, 1)%10==0;
    }

    /**
     * Generates valid Luhn number within the range provided by
     * lowerBound and upperBound to the length defined by the
     * {@code finalLength}.
     *
     * @param       lowerBound a {@code long} to be used as a lower
     *                         bound for the calculation
     * @param       upperBound a {@code long} to be used as an upper
     *                         bound for the calculation
     * @param       finalLength an {@code int} to be used as
     *                          a final length of the result
     * @return      random Luhn valid number of
     *              {@code length = finalLength}
     */
    public static long generateLuhnFromRange(long lowerBound, long upperBound, int finalLength) {
        return generateLuhn(lowerBound, upperBound, finalLength);
    }

    /**
     * Generates a random Luhn number to the length defined by the
     * {@code finalLength}.
     *
     * @param       finalLength an {@code int} to be used as a
     *                          final length of the result
     * @return      random Luhn valid number of
     *              {@code length = finalLength}
     */
    public static long generateRandomLuhn(int finalLength) {
        return generateLuhn(0, 9, finalLength);
    }

    /**
     * Generates valid Luhn number within the range provided by
     * lowerBound and upperBound.
     *
     * <p>The advantage over most algorithms is that this algorithm
     * does NOT circularly use random number generation until a
     * match is found. It is only using number generation once to
     * find a random in the range provided. It then calculates
     * the final number to pass mod-10 validation making this a much
     * faster algorithm than some of the alternatives.
     *
     * <p>If the required length is 1 the algorithm returns 0 by
     * default as this is the only valid digit that passes mod10
     * validation.
     *
     * <p>If the required length is larger than 18, i.e. larger
     * than length of {@link Long#MAX_VALUE} number, then the default
     * value for the length is taken as 18. This is to return valid
     * long and valid Luhn number.
     *
     * <p>The user will have to provide the final length as
     * {@code int} to return the final result of that length.
     *
     * @param       lowerBound a {@code long} to be used as a lower
     *                         bound for the calculation
     * @param       upperBound a {@code long} to be used as an upper
     *                         bound for the calculation
     * @param       finalLength an {@code int} to be used as
     *                          a final length of the result
     * @return      random Luhn valid number of
     *              {@code length = finalLength}
     */
    private static long generateLuhn(long lowerBound, long upperBound, int finalLength) {
        if (finalLength == 1) return 0;
        if (finalLength > 18) finalLength = 18;
        return luhnFullNumber(randomWithinRange(lowerBound, upperBound, finalLength));
    }

    /**
     * Generates a random between lowerBound and upperBound.
     *
     * <p>The method delegates both bounds to be prepared as full
     * mathematical range to be used to generate a random from.
     *
     * @param       lowerBound a {@code long} to be used as a lower
     *                         bound for the calculation
     * @param       upperBound a {@code long} to be used as an upper
     *                         bound for the calculation
     * @param       finalLength an {@code int} to be used as
     *                          a final length of the result
     * @return      a random {@code long} generated
     */
    private static long randomWithinRange(long lowerBound, long upperBound, int finalLength) {
        lowerBound = fillWithTrailingZeroes(lowerBound, finalLength);
        upperBound = fillWithTrailingNines(upperBound, finalLength);
        return lowerBound+(long)(Math.random()*(upperBound-lowerBound));
    }

    /**
     * Fills the given number with trailing zeroes till it meets
     * the desired length, {@code finalLength}.
     *
     * @param       number a {@code long} as a number to be normalised
     * @param       finalLength defining the length of the result
     * @return      the normalised bound as {@code long}
     */
    private static long fillWithTrailingZeroes(long number, int finalLength) {
        return fillWithTrailing(false, number, finalLength);
    }

    /**
     * Fills the given number with trailing nines till it meets
     * the desired length, {@code finalLength}.
     *
     * @param       number a {@code long} as a number to be normalised
     * @param       finalLength defining the length of the result
     * @return      the normalised bound as {@code long}
     */
    private static long fillWithTrailingNines(long number, int finalLength) {
        return fillWithTrailing(true, number, finalLength);
    }

    /**
     * Fills a number, as an upper or lower bound of a range,
     * with trailing digits. The number is filled with digits to
     * the provided length.
     *
     * <p>The two bounds could be different in length.
     *
     * <p>The lower bound will have trailing 0s added till its length
     * is of the desired {@code finalLength}.
     *
     * <p>The higher bound will have trailing 9s added till its length
     * is of the desired {@code finalLength}.
     *
     * @param       asUpperBound a {@code boolean} indicator to instruct
     *                           the method if 0s should be trailing or 9s.
     * @param       number a {@code long} as a number to be normalised
     * @param       finalLength defining the length of the result
     * @return      the normalised bound as {@code long}
     */
    private static long fillWithTrailing(boolean asUpperBound, long number, int finalLength) {
        int length = 0;
        long multiplier = 1;
        do {
            length++;
            multiplier *= 10;
        } while (multiplier <= number);
        int power = finalLength - length - 1;
        while (power > 0) {
            number *= 10;
            if (asUpperBound)
                number += 9;
            power--;
        }
        return number;
    }

    /**
     * Calculates the Luhn check digit.
     *
     * <p>Firstly, delegates the Luhn sum calculation to
     * {@link #calculateLuhnSum(long, int)}.
     *
     * <p>Secondly calculates the check digit required to meet
     * mod10 validation.
     *
     * @param       number a {@code long} to be used to calculate
     *                     the Luhn check digit
     * @return      the Luhn check digit as {@code long}
     */
    private static long luhnCheckDigit(long number) {
        long sum = calculateLuhnSum(number, 2);
        return (sum%10==0) ? 0 : (10-(sum%10));
    }

    /**
     * Generates a full mod10 valid number from a given number.
     *
     * <p>It delegates the Luhn check digit calculation to
     * {@link #luhnCheckDigit(long)}.
     *
     * <p>The check digit is then added as a trailing digit to
     * the number provided as a parameter.
     *
     * <p>As a result of this method, the {@code number} parameter
     * increases its length by 1.
     *
     * @param       number a {@code long} as number to be used
     *                     to generate mod10 valid number
     * @return      valid Luhn valid number as {@code long}
     */
    private static long luhnFullNumber(long number) {
        return (number * 10) + luhnCheckDigit(number);
    }

    /**
     * Calculates the Luhn sum based on mod10 algorithm.
     *
     * <p>The {@code multiplier} is required to be {@code 2} in order
     * to calculate a Luhn sum from a number. Alternatively, a multiplier
     * of {@code 1} could be used for other purposes if the algorithm
     * and the particular purpose are correctly understood.
     *
     * @param       number a {@code long} as a parameter to be used
     *                     for calculation of the sum
     * @param       multiplier an {@code int} to be used as a multiplier
     * @return      the check sum as {@code long}
     */
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
