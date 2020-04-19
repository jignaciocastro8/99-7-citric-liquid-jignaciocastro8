package com.github.cc3002.citricjuice.model.characters;

import java.util.Random;

public abstract class Character {
    protected final String name;
    protected final int maxHp;
    protected final int atk;
    protected final int def;
    protected final int evd;
    protected final Random random;
    protected int stars;
    protected int currentHP;

    /**
     * Creates a general character.
     * @param name: name of the character.
     * @param hp: initial and maximum amount of hit points of the character.
     * @param atk: the base damage the character does.
     * @param def: the base defense if the character.
     * @param evd: the base evasion of the character.
     */
    public Character(String name, int hp, int atk, int def, int evd) {
        this.name = name;
        this.maxHp = hp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
        this.stars = 0;
        this.random = new Random();
    }

    /**
     * Returns the character's name.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the character's max hp.
     * @return hp.
     */
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * Returns the base attack of the character.
     * @return atk.
     */
    public int getAtk() {
        return this.atk;
    }

    /**
     * Returns the base defense of the character.
     * @return def.
     */
    public int getDef() {
        return this.def;
    }

    /**
     * Returns the base evasion of the character.
     * @return evd.
     */
    public int getEvd() {
        return this.evd;
    }

    /**
     * Returns the character's stars.
     * @return stars.
     */
    public int getStars() {
        return this.stars;
    }
    /**
     * Return the current hp of the character.
     * @return current hp.
     */
    public int getCurrentHP() {
        return this.currentHP;
    }
    /**
     * Set the HP of the character.
     * @param currentHP: the new hp.
     */
    public void setCurrentHP(final int currentHP) {
        this.currentHP = currentHP;
    }

    /**
     * Increases the character's star count by an amount.
     * @param amount: the amount to be added.
     */
    public void increaseStarsBy(final int amount) {
        this.stars += amount;
    }

    /**
     * Decreases the character's star count by an amount. A character can't have a negative number of stars.
     * @param amount: the amount to be subtracted.
     */
    public void decreaseStarsBy(final int amount) {
        this.stars = Math.max(0, this.getStars() - amount);
    }

    /**
     * Rolls the character's own dices represented by his/hers Random object.
     * @return a number in {1,...,6}.
     */
    public int roll() {
        return this.random.nextInt(6) + 1;
    }
    /**
     * Set's the seed for this player's random number generator.
     * <p>
     * The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    public void setSeed(final long seed) {
        this.random.setSeed(seed);
    }

}
