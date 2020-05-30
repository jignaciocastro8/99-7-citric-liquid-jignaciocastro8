package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePanelTest {
    private final static String PLAYER_NAME = "NAME";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private Player suguri;
    private HomePanel testHomePanel;

    @BeforeEach
    public void setUp() {
        testHomePanel = new HomePanel(new int[]{0, 0});
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        int[] coord = new int[]{0, 0};
        HomePanel expected = new HomePanel(coord);
        assertEquals(expected, testHomePanel);
    }

    @Test
    public void ownerTest() {
        // We set the player owner to suguri.
        testHomePanel.setPlayerOwner(suguri);
        // Checks that the current player owner is still suguri.
        assertEquals(suguri, testHomePanel.getPlayerOwner());
        // Suguri's home panel test.
        suguri.setHomePanel(testHomePanel);
        assertEquals(testHomePanel, suguri.getHomePanel());
    }
    @RepeatedTest(100)
    public void activatedByTest() {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        // Creates the Random object with the previous seed.
        Random  ran = new Random(testSeed);
        int[] stars = new int[]{10, 30, 70, 120, 200, 250};
        int[] wins = new int[]{0, 2, 5, 9, 14, 20};
        // Test the norma levels and hp:
        for (int i=2; i<=6; i++) {
            int testStars = stars[i - 2] + ran.nextInt(stars[i - 1] - stars[i - 2]);
            int testWins = wins[i - 2] + ran.nextInt(wins[i - 1] - wins[i - 2]);
            int currentHp = suguri.getCurrentHP();
            suguri.increaseStarsBy(testStars);
            suguri.increaseWinsBy(testWins);
            testHomePanel.activatedBy(suguri);
            assertEquals(Math.min(suguri.getMaxHP(), currentHp + 1), suguri.getCurrentHP());
            assertEquals(i, suguri.getNormaLevel());
            suguri.reduceStarsBy(suguri.getStars());
            suguri.reduceWinsBy(suguri.getWins());
        }
    }
}
