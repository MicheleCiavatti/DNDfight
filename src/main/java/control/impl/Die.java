package control.impl;

import java.util.Random;

public enum Die {
    D100(100),
    D20(20),
    D12(12),
    D8(8),
    D6(6),
    D4(4),
    D2(2);

    private final int bound;
    private final Random rand = new Random();

    private Die(final int bound) {
        this.bound = bound;
    }

    public int roll() {
        return this.rand.nextInt(bound) + 1;
    }
}
