package control.impl;

import control.api.Die;
import java.util.Random;
import java.util.stream.IntStream;
/**Implementation of {@link control.api.Die} */
public class DieImpl implements Die {

    private static final int ADVANTAGE_DISADVANTAGE_DICE = 2;

    private final int upperBound;
    private final Random randomGenerator;

    /**Constructor of a die
     * @param upperBound the number of faces of the die
     */
    public DieImpl (final int upperBound) {
        this.upperBound = upperBound;
        this.randomGenerator = new Random();
    }

    /**{@inheritDoc} */
    public int roll() {
        return 1 + this.randomGenerator.nextInt(this.upperBound);
    }

    /**{@inheritDoc} */
    public int rollAdvantage() {
        return this.rollTwoPickOne(true);
    }

    /**{@inheritDoc} */
    public int rollDisadvantage() {
        return this.rollTwoPickOne(false);
    }

    private int rollTwoPickOne(final boolean greater) {
        IntStream stream = this.randomGenerator.ints(ADVANTAGE_DISADVANTAGE_DICE, 0, this.upperBound);
        return 1 + (greater ? stream.max() : stream.min()).getAsInt();
    }

}