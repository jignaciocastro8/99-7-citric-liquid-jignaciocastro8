package com.github.cc3002.citricjuice.model.character;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the players of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class PlayerTest {
    private final static String PLAYER_NAME = "NAME";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private Player suguri;

    @BeforeEach
    public void setUp() {
        suguri = new Player("NAME", BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }

    @Test
    public void constructorTest() {
        Player expectedSuguri = new Player("NAME", 4, 1, -1, 2);
        assertEquals(expectedSuguri, suguri);
    }

    @Test
    public void testEquals() {
        final var o = new Object();
        assertNotEquals(suguri, o);
        assertEquals(suguri, suguri);
        final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
        assertEquals(expectedSuguri, suguri);
    }
    @Test
    public void hitPointsTest() {
        assertEquals(suguri.getMaxHP(), suguri.getCurrentHP());
        suguri.setCurrentHP(2);
        assertEquals(2, suguri.getCurrentHP());
        suguri.setCurrentHP(-1);
        assertEquals(0, suguri.getCurrentHP());
        suguri.setCurrentHP(8);
        assertEquals(4, suguri.getCurrentHP());
        assertEquals(suguri.getMaxHP(), suguri.getCurrentHP());
    }
    @Test
    public void normaTest() {
        assertFalse(-1 == suguri.getNormaLevel());
        assertEquals(1, suguri.getNormaLevel());
    }
    @Test
    public void normaClearTest() {
        suguri.normaClear();
        assertEquals(2, suguri.getNormaLevel());
        int currentNorma = suguri.getNormaLevel();
        suguri.normaClear();
        assertEquals(currentNorma + 1, suguri.getNormaLevel());
    }
    @Test
    public void homePanelPlayerTest() {
        HomePanel testHomePanel = new HomePanel(new int[]{0, 0});
        suguri.setHomePanel(testHomePanel);
        assertEquals(testHomePanel, suguri.getHomePanel());
    }
    @Test
    public void copyTest() {
        final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
        final var actualSuguri = suguri.copy();
        // Checks that the copied player have the same parameters as the original
        assertEquals(expectedSuguri, actualSuguri);
        // Checks that the copied player doesn't reference the same object
        assertNotSame(expectedSuguri, actualSuguri);
    }

    // region : consistency tests
    @RepeatedTest(100)
    public void increaseConsistencyTest() {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        Random ran = new Random(testSeed);
        int stars = ran.nextInt();
        int wins = ran.nextInt();
        suguri.increaseStarsBy(stars);
        suguri.increaseWinsBy(wins);
        assertEquals(stars, suguri.getStars());
        assertEquals(wins, suguri.getWins());
    }
    @RepeatedTest(100)
    public void reduceConsistencyTest() {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        Random ran = new Random(testSeed);
        // The 1 is because the bound in nextInt must be positive.
        int stars = ran.nextInt(200) + 1;
        int starsReduce = ran.nextInt(2 * stars) ;
        int wins = ran.nextInt(20) + 1;
        int winsReduce = ran.nextInt(2 * wins);
        suguri.increaseStarsBy(stars);
        suguri.reduceStarsBy(starsReduce);
        suguri.increaseWinsBy(wins);
        suguri.reduceWinsBy(winsReduce);
        // Tests the reduce methods.
        assertEquals(Math.max(0, stars - starsReduce), suguri.getStars());
        assertEquals(Math.max(0, wins - winsReduce), suguri.getWins());
    }
    @RepeatedTest(100)
    public void hitPointsConsistencyTest() {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
        final int testHP = new Random(testSeed).nextInt(4 * suguri.getMaxHP() + 1)
                - 2 * suguri.getMaxHP();
        suguri.setCurrentHP(testHP);
        assertTrue(0 <= suguri.getCurrentHP()
                        && suguri.getCurrentHP() <= suguri.getMaxHP(),
                suguri.getCurrentHP() + "is not a valid HP value"
                        + System.lineSeparator() + "Test failed with random seed: "
                        + testSeed);
    }

    @RepeatedTest(100)
    public void normaClearConsistencyTest() {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        // We fix a random number of iteration.
        final int iterations = Math.abs(new Random(testSeed).nextInt(6));
        // Norma will be augmented iterations times.
        final int expectedNorma = suguri.getNormaLevel() + iterations;
        for (int it = 0; it < iterations; it++) {
            suguri.normaClear();
        }
        assertEquals(expectedNorma, suguri.getNormaLevel(),
                "Test failed with random seed: " + testSeed);
    }

    @RepeatedTest(100)
    public void rollConsistencyTest() {
        // We fix a seed for pseudo random test.
        final long testSeed = new Random().nextLong();
        // We pass this seed to suguri's seed.
        suguri.setSeed(testSeed);
        final int roll = suguri.roll();
        // checks that suguri's roll are in the right range.
        assertTrue(roll >= 1 && roll <= 6,
                roll + "is not in [1, 6]" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }
    // endregion


}
