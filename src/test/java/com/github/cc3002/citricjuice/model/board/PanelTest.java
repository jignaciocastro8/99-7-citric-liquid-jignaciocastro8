package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
class PanelTest {
  private final static String PLAYER_NAME = "NAME";
  private final static int BASE_HP = 4;
  private final static int BASE_ATK = 1;
  private final static int BASE_DEF = -1;
  private final static int BASE_EVD = 2;
  private Panel[][] panels = new Panel[1][2];
  private Board board;
  private Player testPlayer;
  private long testSeed;

  @BeforeEach
  public void setUp() {
    panels[0][0] = new HomePanel(new int[]{0, 0});
    panels[0][1] = new NeutralPanel(new int[]{0, 1});
    board = new Board(panels);
    testPlayer = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
  }

  @Test
  public void nextPanelTest() {
    assertTrue(panels[0][0].getNextPanels().isEmpty());
    panels[0][0].addNextPanel(panels[0][1]);
    panels[0][1].addNextPanel(panels[0][0]);
    HashSet<Panel> expected = new HashSet<Panel>();
    expected.add(panels[0][1]);
    assertEquals(expected, panels[0][0].getNextPanels());
    HashSet<Panel> expected1 = new HashSet<Panel>();
    expected1.add(panels[0][0]);
    assertEquals(expected1, panels[0][1].getNextPanels());
  }
}