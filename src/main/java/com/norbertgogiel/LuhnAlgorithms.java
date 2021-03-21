package com.norbertgogiel;

public class LuhnAlgorithms {

    private LuhnAlgorithms() {}

    public static boolean isValid(String number) {
        return calculateLuhnCheck(Long.parseLong(number)) % 10 == 0;
    }

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
