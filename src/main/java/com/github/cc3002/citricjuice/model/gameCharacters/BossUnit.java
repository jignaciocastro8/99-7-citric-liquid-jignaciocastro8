package com.github.cc3002.citricjuice.model.gameCharacters;

public class BossUnit extends GameCharacter {
    public BossUnit(String name, int maxHp, int atk, int def, int evd) {
        super(name, maxHp, atk, def, evd);
    }

    /**
     * Implements the effects of lose a battle.
     * @param character: a character.
     */
    @Override
    public void defeatedBy(GameCharacter character) {
        character.increaseStarsBy(this.getStars());
        character.increaseWinsBy(1);
        this.reduceStarsBy(this.getStars());
    }
}
