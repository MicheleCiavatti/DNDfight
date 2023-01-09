package control.impl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dice {

    public static final int ADVANTAGE_DISADVANTAGE = 2;

    private static Stream<Integer> rollMany(final Die d, final int quantity) {
        return Stream.generate(() -> d.roll()).limit(quantity);
    }
    
    public static int rollAdvantage(final Die d) {
        return rollMany(d, ADVANTAGE_DISADVANTAGE).max(Integer::compareTo).get();
    }

    public static int rollDisadvantage(final Die d) {
        return rollMany(d, ADVANTAGE_DISADVANTAGE).min(Integer::compareTo).get();
    }

    public static int sumRolls(final Die d, final int quantity) {
        return rollMany(d, quantity).collect(Collectors.summingInt(i -> i));
    }
}
