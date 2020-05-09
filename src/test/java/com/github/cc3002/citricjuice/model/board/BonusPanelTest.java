package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusPanelTest {
    private final static String PLAYER_NAME = "NAME";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private Player suguri;
    private BonusPanel testBonusPanel;

    @BeforeEach
    public void setUp() {
        testBonusPanel = new BonusPanel(new int[]{0, 0});
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        BonusPanel expected = new BonusPanel(new int[]{0, 0});
        assertEquals(expected, testBonusPanel);
    }
    @Test
    public void activatedByTest() {

    }
}
