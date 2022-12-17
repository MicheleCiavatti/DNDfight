package model.api;

/**Models any monster.
 * @see Creature
 */
public interface Monster extends Creature {

    /**Returns the monster's current HP.
     * @return current HP of the monster
     */
    public int getHP();

    /**Returns a string displaying all the languages the monster can speak/comprehend.
     * @return sequence of monster's languages
     */
    public String getLanguages();

    /**Returns information about the monster's senses.
     * @return info about monster's senses
     */
    public String getSenses();

    /**Returns general informations about monster's passives and abilities.
     * @return info about the monster
     */
    public String getInfo();

    /**Returns the result of a roll */
    public int savingThrow(final Stat statistic);
}