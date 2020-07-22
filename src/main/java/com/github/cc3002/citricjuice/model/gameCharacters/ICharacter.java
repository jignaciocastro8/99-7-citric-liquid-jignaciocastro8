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

    /**
     * Getter of the name.
     * @return String.
     */
    String getName();

    /**
     * Getter of the atk stat.
     * @return int.
     */
    int getAtk();

    /**
     * Getter of the def stat.
     * @return Int.
     */
    int getDef();

    /**
     * Getter of the evd stat.
     * @return Int.
     */
    int getEvd();

    /**
     * Getter of the characters information.
     * @return String.
     */
    String getInfo();



    /*
    // Esto podría estar en una BattleInterface común a PLayer y AbstractUnit.
    public void defend(int attack);
    public void evade(int attack);
    public void attack(AbstractCharacter character);
    //public void receiveAtk(int netAtk);
    */
}
