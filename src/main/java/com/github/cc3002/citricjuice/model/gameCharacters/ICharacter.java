package com.github.cc3002.citricjuice.model.gameCharacters;

public interface ICharacter {
    /**
     * Sets the HP.
     * @param currentHP Int.
     */
    void setCurrentHP(final int currentHP);

    /**
     * Increases stars by amount.
     * @param amount Int.
     */
    void increaseStarsBy(final int amount);

    /**
     * Reduces stars by amount.
     * @param amount Int.
     */
    void reduceStarsBy(final int amount);

    /**
     * Increases wins by amount.
     * @param amount Int.
     */
    void increaseWinsBy(final int amount);

    /**
     * Reduces wins by amount.
     * @param amount Int.
     */
    void reduceWinsBy(final int amount);

    /**
     * Sets the seed.
     * @param seed long.
     */
    void setSeed(long seed);

    /**
     * Roll the dice.
     * @return Int.
     */
    int roll();

    /**
     * Getter of the hp.
     * @return Int.
     */
    int getCurrentHP();

    /**
     * Getter of the max hp.
     * @return Int.
     */
    int getMaxHP();

    /**
     * Getter of the stars.
     * @return Int.
     */
    int getStars();

    /**
     * Getter of the wins.
     * @return Int.
     */
    int getWins();



    /*
    // Esto podría estar en una BattleInterface común a PLayer y AbstractUnit.
    public void defend(int attack);
    public void evade(int attack);
    public void attack(AbstractCharacter character);
    //public void receiveAtk(int netAtk);
    */
}
