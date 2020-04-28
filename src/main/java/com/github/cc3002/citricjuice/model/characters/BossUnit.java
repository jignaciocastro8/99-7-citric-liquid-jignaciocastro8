package com.github.cc3002.citricjuice.model.characters;

public class BossUnit extends Character{
    public BossUnit(String name, int maxHp, int atk, int def, int evd) {
        super(name, maxHp, atk, def, evd);
    }

    /**
     * Implements the effects of lose a battle.
     * @param character: a character.
     */
    @Override
    public void defeatedBy(Character character) {
        character.increaseStarsBy(this.getStars());
        character.increaseVictoriesBy(1);
        this.reduceStarsBy(this.getStars());
    }
}
