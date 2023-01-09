package control.dice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.temporal.ValueRange;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import control.impl.Dice;
import control.impl.Die;

public class TestDice {

    private static final int TRIALS = 100;
    private static final int QUANTITY = 5;
    
    @Test
    public void testD20() {
        assertTrue(Stream.generate(() -> Die.D20.roll()).limit(TRIALS).allMatch(roll -> roll <= 20 && roll > 0));
    }

    @Test
    public void testAdvantage() {
        assertTrue(Stream.generate(() -> Dice.rollAdvantage(Die.D20)).limit(TRIALS).collect(Collectors.averagingInt(i -> i))
        >= Stream.generate(() -> Die.D20.roll()).limit(TRIALS).collect(Collectors.averagingInt(i -> i)));
    }

    @Test
    public void testSumRolls() {
        assertTrue(Stream.generate(() -> ValueRange.of(QUANTITY, QUANTITY * 6).isValidValue(Dice.sumRolls(Die.D6, QUANTITY))).limit(TRIALS)
        .allMatch(resultCondition -> resultCondition == true));
    }
}
