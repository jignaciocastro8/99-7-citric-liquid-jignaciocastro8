package com.github.cc3002.citricjuice.model.character;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.characters.Player;
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
    HomePanel testHomePanel = new HomePanel(new int[]{0, 0});
    private final static String PLAYER_NAME = "NAME";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private Player testPlayer;

    @BeforeEach
    public void setUp() {
        Player testPlayer = new Player("NAME", BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD, testHomePanel);
    }
    @Test
    public void constructorTest() {
        HomePanel newHomePanel = new HomePanel(new int[]{0, 0});
        Player val = new Player("NAME", 4, 1, -1, 2, newHomePanel);
        assertTrue(testPlayer.equals(val));
    }
    @Test
    public void copyTest() {
        Player newPlayer = testPlayer.copy();
        assertNotSame(testPlayer, newPlayer);
        assertEquals(testPlayer, testPlayer.copy());
    }
    @Test
    public void normaTest() {
        assertFalse(-1 == testPlayer.getNormaLevel());
        assertEquals(1, testPlayer.getNormaLevel());
    }
    @Test
    public void normaClearTest() {
        int currentNorma = testPlayer.getNormaLevel();
        testPlayer.normaClear();
        assertEquals(currentNorma + 1, testPlayer.getNormaLevel());
    }
}
