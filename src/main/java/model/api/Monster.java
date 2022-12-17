package model.api;

import control.api.Stat;

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

    /**Returns the result of a roll in the specified {@link control.api.Stat}.
     * @param statistic the stat used as modifier for the saving throw
     * @return the result of the saving throw
    */
    public int savingThrow(final Stat statistic);

    /**Heals the monster by the amount specified.
     * @param gained healing of the monster
     */
    public void gainHP(final int gained);

    /**The monster takes damage based on the amount specified, applying the modifier based on his resistances.
     * @param lost damage taken
     * @param resistance modifier based on monster resistances
     */
    public void loseHP(final int lost, final double resistance);

    /*TODO
     *  public String getSpells();
     */
   
}