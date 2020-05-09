package com.github.cc3002.citricjuice.model.gameCharacters;

import java.util.Random;

public abstract class GameCharacter implements CharacterInterface {
    protected final String name;
    protected final int maxHp;
    protected final int atk;
    protected final int def;
    protected final int evd;
    protected final Random random;
    private int stars;
    protected int currentHP;
    private int wins;

    /**
     * Creates a general character.
     * @param name: name of the character.
     * @param hp: initial and maximum amount of hit points of the character.
     * @param atk: the base damage the character does.
     * @param def: the base defense if the character.
     * @param evd: the base evasion of the character.
     */
    public GameCharacter(String name, int hp, int atk, int def, int evd) {
        this.name = name;
        this.maxHp = hp;
        this.currentHP = hp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
        this.stars = 0;
        this.wins = 0;
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
    public int getMaxHP() {
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
     * Returns the number of victories of the character.
     * @return
     */
    public int getWins() {return this.wins;}
    /**
     * Returns the current hp of the character.
     * @return current hp.
     */
    public int getCurrentHP() {
        return this.currentHP;
    }
    /**
     * Sets the HP of the character.
     * @param newHP: the new hp.
     */
    public void setCurrentHP(final int newHP) {
        this.currentHP = Math.max(0, Math.min(newHP, this.maxHp));
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
    public void reduceStarsBy(final int amount) {
        this.stars = Math.max(0, this.stars - amount);
    }

    /**
     * Increases wins by an amount.
     * @param amount: the amount to be added.
     */
    public void increaseWinsBy(int amount) {this.wins += amount;}

    /**
     * Reduces wins by an amount.
     * @param amount: the amount to be reduce.
     */
    public void reduceWinsBy(int amount) {this.wins = Math.max(0, this.wins - amount);}
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
