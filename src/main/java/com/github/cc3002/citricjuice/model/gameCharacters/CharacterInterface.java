package com.github.cc3002.citricjuice.model.gameCharacters;

public interface CharacterInterface {
    public void setCurrentHP(final int currentHP);
    public void increaseStarsBy(final int amount);
    public void reduceStarsBy(final int amount);
    public void increaseWinsBy(final int amount);
    public void reduceWinsBy(final int amount);
    public void setSeed(long seed);
    public int roll();

    /*
    // Esto podría estar en una BattleInterface común a PLayer y AbstractUnit.
    public void defend(int attack);
    public void evade(int attack);
    public void attack(AbstractCharacter character);
    //public void receiveAtk(int netAtk);
    */
}
