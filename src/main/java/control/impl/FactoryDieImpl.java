package control.impl;

import control.api.Die;
import control.api.FactoryDie;

/**Implementation of {@link control.api.FactoryDie} that creates {@link control.impl.DieImpl} */
public class FactoryDieImpl implements FactoryDie {

    /**{@inheritDoc} */
    @Override
    public Die createD100() {
        return new DieImpl(100);
    }

    /**{@inheritDoc} */
    @Override
    public Die createD20() {
        return new DieImpl(20);
    }

    /**{@inheritDoc} */
    @Override
    public Die createD12() {
        return new DieImpl(12);
    }

    /**{@inheritDoc} */
    @Override
    public Die createD10() {
        return new DieImpl(10);
    }

    /**{@inheritDoc} */
    @Override
    public Die createD8() {
        return new DieImpl(8);
    }

    /**{@inheritDoc} */
    @Override
    public Die createD6() {
        return new DieImpl(6);
    }

    /**{@inheritDoc} */
    @Override
    public Die createD4() {
        return new DieImpl(4);
    }
    
}