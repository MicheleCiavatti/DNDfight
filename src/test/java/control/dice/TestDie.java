package control.dice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import control.api.Die;
import control.api.FactoryDie;
import control.impl.FactoryDieImpl;

public class TestDie {

    private static final int D100_UPPER_BOUND = 100;
    private static final int ATTEMPTS = 10000;
    private final FactoryDie factoryDie = new FactoryDieImpl();


    @Test
    public void testD100() {
        Die d100 = factoryDie.createD100();
        for (int i = 0; i < ATTEMPTS; i++) {
            assertTrue(() -> ValueRange.of(1, D100_UPPER_BOUND).isValidValue(d100.roll()));
            assertTrue(() -> ValueRange.of(1, D100_UPPER_BOUND).isValidValue(d100.rollAdvantage()));
            assertTrue(() -> ValueRange.of(1, D100_UPPER_BOUND).isValidValue(d100.rollDisadvantage()));
        }
    }

    @Test
    public void testAdvantageDisadvantageD20() {
        Die d20 = factoryDie.createD20();
        List<Integer> normal = new ArrayList<>();
        List<Integer> advantage = new ArrayList<>();
        List<Integer> disadvantage = new ArrayList<>();
        for (int i = 0; i < ATTEMPTS; i++) {
            normal.add(d20.roll());
            advantage.add(d20.rollAdvantage());
            disadvantage.add(d20.rollDisadvantage());
        }
        double normalRollsAverage = normal.stream().collect(Collectors.averagingInt(num -> num));
        assertTrue(normalRollsAverage <= advantage.stream().collect(Collectors.averagingInt(num -> num)));
        assertTrue(disadvantage.stream().collect(Collectors.averagingInt(num -> num)) <= normalRollsAverage);
        System.out.println(normalRollsAverage);
        System.out.println(advantage.stream().collect(Collectors.averagingInt(num -> num)));
        System.out.println(disadvantage.stream().collect(Collectors.averagingInt(num -> num)));
    }
}