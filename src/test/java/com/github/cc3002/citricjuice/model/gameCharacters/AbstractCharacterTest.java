package com.github.cc3002.citricjuice.model.gameCharacters;

import org.junit.jupiter.api.Assertions;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractCharacterTest {

    abstract CharacterInterface makeCharacter(String name, int hp, int atk, int def, int evd);

    /**
     * Tests getter and setter of hp field.
     * @param gameCharacter CharacterInterface.
     */
    public void abstractHpTest(CharacterInterface gameCharacter) {
        int maxHp = gameCharacter.getCurrentHP();
        assertEquals(gameCharacter.getMaxHP(), gameCharacter.getCurrentHP());
        gameCharacter.setCurrentHP(2);
        assertEquals(2, gameCharacter.getCurrentHP());
        gameCharacter.setCurrentHP(-1);
        assertEquals(0, gameCharacter.getCurrentHP());
        gameCharacter.setCurrentHP(8);
        assertEquals(maxHp, gameCharacter.getCurrentHP());
        assertEquals(gameCharacter.getMaxHP(), gameCharacter.getCurrentHP());
    }

    /**
     * Tests increase methods.
     * @param gameCharacter CharacterInterface.
     */
    public void increaseConsistencyTest(CharacterInterface gameCharacter) {
        // Initial stars and wins.
        int expectedStars = gameCharacter.getStars();
        int expectedWins = gameCharacter.getWins();
        // We fix a seed for the every pseudo random tests.
        final long testSeed = new Random().nextLong();
        Random ran = new Random(testSeed);
        for (int i=0; i<10; i++) {
            int stars = ran.nextInt();
            int wins = ran.nextInt();
            expectedStars += stars;
            expectedWins += wins;
            gameCharacter.increaseStarsBy(stars);
            gameCharacter.increaseWinsBy(wins);
            Assertions.assertEquals(expectedStars, gameCharacter.getStars());
            Assertions.assertEquals(expectedWins, gameCharacter.getWins());
        }
    }

    /**
     * Tests reduce methods.
     * @param gameCharacter CharacterInterface.
     */
    public void reduceConsistencyTest(CharacterInterface gameCharacter) {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        Random ran = new Random(testSeed);
        // The 1 is because the bound in nextInt must be positive.
        int stars = ran.nextInt(200) + 1;
        int starsReduce = ran.nextInt(2 * stars) ;
        int wins = ran.nextInt(20) + 1;
        int winsReduce = ran.nextInt(2 * wins);
        gameCharacter.increaseStarsBy(stars);
        gameCharacter.reduceStarsBy(starsReduce);
        gameCharacter.increaseWinsBy(wins);
        gameCharacter.reduceWinsBy(winsReduce);
        // Tests the reduce methods.
        assertEquals(Math.max(0, stars - starsReduce), gameCharacter.getStars());
        assertEquals(Math.max(0, wins - winsReduce), gameCharacter.getWins());
    }

    /**
     * Test hp getter and setter consistency.
     * @param gameCharacter CharacterInterface.
     */
    public void hitPointsConsistencyTest(CharacterInterface gameCharacter) {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
        final int testHP = new Random(testSeed).nextInt(4 * gameCharacter.getMaxHP() + 1)
                - 2 * gameCharacter.getMaxHP();
        gameCharacter.setCurrentHP(testHP);
        assertTrue(0 <= gameCharacter.getCurrentHP()
                        && gameCharacter.getCurrentHP() <= gameCharacter.getMaxHP(),
                gameCharacter.getCurrentHP() + "is not a valid HP value"
                        + System.lineSeparator() + "Test failed with random seed: "
                        + testSeed);
    }

    /**
     * Tests roll method.
     * @param gameCharacter CharacterInterface.
     */
    public void rollConsistencyTest(CharacterInterface gameCharacter) {
        // We fix a seed for pseudo random test.
        final long testSeed = new Random().nextLong();
        // We pass this seed to Chicken's seed.
        gameCharacter.setSeed(testSeed);
        final int roll = gameCharacter.roll();
        // Checks that Chicken's roll are in the right range.
        assertTrue(roll >= 1 && roll <= 6,
                roll + "is not in [1, 6]" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }
}
