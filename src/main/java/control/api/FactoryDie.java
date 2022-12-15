package control.api;

/**Factory pattern to produce {@link control.api.Die} */
public interface FactoryDie {

    /**Returns a {@link control.api.Die} with 100 faces
     * @return a D100
    */
    public Die createD100();

    /**Returns a {@link control.api.Die} with 20 faces
     * @return a D20
    */
    public Die createD20();

    /**Returns a {@link control.api.Die} with 12 faces
     * @return a D12
    */
    public Die createD12();

    /**Returns a {@link control.api.Die} with 10 faces
     * @return a D10
    */
    public Die createD10();

    /**Returns a {@link control.api.Die} with 8 faces
     * @return a D8
    */
    public Die createD8();

    /**Returns a {@link control.api.Die} with 6 faces
     * @return a D6
    */
    public Die createD6();

    /**Returns a {@link control.api.Die} with 4 faces
     * @return a D4
    */
    public Die createD4();
}