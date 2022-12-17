package model.api;

/**Factory pattern to produce any {@link model.api.Creature}. */
public interface FactoryCreature {

    /**Returns a {@link model.api.Monster}.
     * @return a monster
     */
    public Monster createMonster();

    /**Returns a {@link model.api.Hero}.
     * @return a hero
     */
    public Hero createHero();
}