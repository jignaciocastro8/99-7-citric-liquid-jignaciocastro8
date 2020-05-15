package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.DropPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropPanelTest {
    private final static String PLAYER_NAME = "NAME";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    Player suguri;
    long testSeed;
    DropPanel testDropPanel;
    @BeforeEach
    public void setUp(){
        // We fix the seed of the random object to control the stochastic behavior.
        testSeed = new Random().nextLong();
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
        testDropPanel = new DropPanel(new int[]{0, 0});
    }
    @RepeatedTest(100)
    public void dropPanelConsistencyTest() {
        // Generate a random amount of stars.
        int expectedStars = new Random().nextInt(500);
        suguri.increaseStarsBy(expectedStars);
        assertEquals(expectedStars, suguri.getStars());
        // Sets the random object's seed.
        final var testRandom = new Random(testSeed);
        // Sets the players's random object's seed to the same seed.
        suguri.setSeed(testSeed);
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            testDropPanel.activatedBy(suguri);
            expectedStars = Math.max(expectedStars - roll * normaLvl, 0);
            assertEquals(expectedStars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
    }
}
