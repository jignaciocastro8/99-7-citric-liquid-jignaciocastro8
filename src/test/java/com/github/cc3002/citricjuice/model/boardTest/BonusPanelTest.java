package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricjuice.model.board.panelFactory.BonusPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BonusPanelTest extends AbstractPanelTest {
    private final static String PLAYER_NAME = "NAME";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private Player suguri;
    private BonusPanel testBonusPanel;
    private IPanelFactory factory = new BonusPanelFactory();
    private long testSeed;



    @BeforeEach
    public void setUp() {
        // We fix the seed of the random object to control the stochastic behavior.
        testSeed = new Random().nextLong();
        testBonusPanel = new BonusPanel(0);
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        BonusPanel expected = new BonusPanel(0);
        assertEquals(expected, testBonusPanel);
    }
    @RepeatedTest(100)
    public void activatedByTest() {
        int expectedStars = 0;
        assertEquals(expectedStars, suguri.getStars());
        // The random object of the test.
        final var testRandom = new Random(testSeed);
        // Sets the Player's seed to the known seed.
        suguri.setSeed(testSeed);
        // We tests over the range of the norma level.
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            testBonusPanel.activatedBy(suguri);
            expectedStars += roll * Math.min(3, normaLvl);
            assertEquals(expectedStars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
    }

    @Override
    public IPanel makePanel(int key) {
        return factory.createWithKey(key);
    }

    @Override
    @Test
    public void getTypeTest() {
        IPanel panel = factory.createWithKey(0);
        assertEquals(PanelType.BONUS, panel.getType());
    }


    @Override
    @Test
    public void nextPanelsTest() {
        abstractNextPanelsTest();
    }

    @Override
    @RepeatedTest(100)
    public void getKeyTest() {
        abstractGetKeyTest();
    }

    @Override
    @Test
    public void addPlayerTest() {
        abstractNextPanelsTest();
    }
}
