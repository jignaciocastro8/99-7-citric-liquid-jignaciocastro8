package com.github.cc3002.citricjuice.model.characters;

public interface CharacterInterface {
    public void setCurrentHP(final int currentHP);
    public void increaseStarsBy(final int amount);
    public void reduceStarsBy(final int amount);
    public int roll();
}
