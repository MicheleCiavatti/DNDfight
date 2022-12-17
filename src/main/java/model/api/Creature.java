package model.api;

/**Models any creature.
 * @see Hero
 * @see Monster
 */
public interface Creature {

    /**Returns the initiative of the creature (roll + modifier). 
     * @return initative roll of the creature
    */
    public int getInitiative();

    /**Returns the armor class of the creature.
     * @return AC of the creature
     */
    public int getAC();

    /**Returns the passive perception of the creature.
     * @return passive perception of the creature
     */
    public int getPassivePerception();

    /**Returns the name of the creature.
     * @return a string containing the name of the creature
    */
    public String getName();
}