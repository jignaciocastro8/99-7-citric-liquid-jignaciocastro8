package com.github.cc3002.citricjuice.model.gameCharacters;

public interface ICharacter {
    void setCurrentHP(final int currentHP);
    void increaseStarsBy(final int amount);
    void reduceStarsBy(final int amount);
    void increaseWinsBy(final int amount);
    void reduceWinsBy(final int amount);
    void setSeed(long seed);
    int roll();
    int getCurrentHP();
    int getMaxHP();
    int getStars();
    int getWins();

    /*
    // Esto podría estar en una BattleInterface común a PLayer y AbstractUnit.
    public void defend(int attack);
    public void evade(int attack);
    public void attack(AbstractCharacter character);
    //public void receiveAtk(int netAtk);
    */
}
