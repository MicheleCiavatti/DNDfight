package control.api;

/**Models a die with various number of faces */
public interface Die {

    /**Returns the result of a roll of the specified die
     * @return the result of the roll
     */
    public int roll();

    /**Returns the result of a roll of the specified die made with advantage
     * @return the result of the roll with advantage
     */
    public int rollAdvantage();

    /**Returns the result of a roll of the specified die made with disadvantage
     * @return the result of the roll with disadvantage
     */
    public int rollDisadvantage();
}

