package com.github.cc3002.citricjuice.model.gameCharacters;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractCharacter implements ICharacter {
    protected final String name;
    protected final int maxHp;
    protected int atk;
    protected int def;
    protected int evd;
    protected final Random random;
    protected int stars;
    protected int currentHP;
    protected int wins;
    private int roll;


    /**
     * Creates a general character.
     * @param name: name of the character.
     * @param hp: initial and maximum amount of hit points of the character.
     * @param atk: the base damage the character does.
     * @param def: the base defense if the character.
     * @param evd: the base evasion of the character.
     */
    public AbstractCharacter(String name, int hp, int atk, int def, int evd) {
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
     * @return wins.
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
        this.roll = this.random.nextInt(6) + 1;
        return this.roll;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCharacter that = (AbstractCharacter) o;
        return maxHp == that.maxHp &&
                atk == that.atk &&
                def == that.def &&
                evd == that.evd &&
                stars == that.stars &&
                currentHP == that.currentHP &&
                wins == that.wins &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxHp, atk, def, evd, random, stars, currentHP, wins);
    }


    // Battle implementation.

    /**
     * Execute the defend strategy.
     * @param attack: net attack over this character.
     */
    public void defend(int attack) {
        int defendRoll = this.roll();
        int netDef = defendRoll + this.def;
        this.setCurrentHP(this.getCurrentHP() - Math.max(1, attack - netDef));
    }

    /**
     * Execute the evade strategy.
     * @param attack: net attack over this character.
     */
    public void evade(int attack) {
        int evdRoll = this.roll();
        int netEvd = evdRoll + this.getEvd();
        if (netEvd <= attack) {
            this.setCurrentHP(this.getCurrentHP() - attack);
        }
    }

    /**
     * Execute attack over a character.
     * @param character AbstractCharacter.
     */
    public void attack(AbstractCharacter character) {
        int atkRoll = this.roll();
        int netAtk = atkRoll + this.atk;
        character.receiveAtk(netAtk);
    }

    /**
     * Getter of the characters information.
     *
     * @return String.
     */
    @Override
    public String getInfo() {
        return "current hp : " + currentHP + ", " +
                "atk: " + atk + ", " +
                "def: " + def + ", " +
                "evd: " + evd + ", " +
                "stars: " + stars + ", " +
                "wins: " + wins + ", " +
                "roll: " + roll;
    }

    /**
     * Abstract method. Everyone must be able to receive an attack.
     * @param netAtk int.
     */
    public abstract void receiveAtk(int netAtk);
}
