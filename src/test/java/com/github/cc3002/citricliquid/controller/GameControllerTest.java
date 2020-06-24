package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.*;

import com.github.cc3002.citricjuice.model.board.panelFactory.*;
import com.github.cc3002.citricjuice.model.gameCharacters.BossUnit;
import com.github.cc3002.citricjuice.model.gameCharacters.*;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.*;
import com.github.cc3002.citricliquid.model.NormaGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {
    private Random random;

    private IPlayerFactory playerFactory =  new PlayerFactory();
    private ICharacterFactory wildFactory =  new WildFactory();
    private ICharacterFactory bossFactory =  new BossFactory();

    private IPanelFactory bonusPanelFactory = new BonusPanelFactory();
    private IPanelFactory bossPanelFactory = new BossPanelFactory();
    private IPanelFactory drawPanelFactory = new DrawPanelFactory();
    private IPanelFactory dropPanelFactory = new DropPanelFactory();
    private IPanelFactory encounterPanelFactory = new EncounterPanelFactory();
    private IPanelFactory homePanelFactory = new HomePanelFactory();
    private IPanelFactory neutralPanelFactory = new NeutralPanelFactory();

    private GameController gameController;

    private IPlayer suguri;
    private ICharacter shifuRobot;
    private ICharacter seagull;
    private Player marc;

    @BeforeEach
    public void setUp(){
        // Random Object for consistency tests.
        random = new Random();
        // Some characters.
        suguri = new Player("Suguri", 4, 1, -1, 2);
        shifuRobot = new BossUnit("Shifu Robot", 5, 1, 0, -1);
        seagull = new WildUnit("Seagull", 3, 1, -1, -1);
        // Game controller object.
        gameController = new GameController();
    }

    // The next region is for test all the createPanel methods.
    @Test
    public void createHomePanelTest(){
        HomePanel expectedHomePanel = new HomePanel(0);
        gameController.createHomePanel(0);
        assertEquals(expectedHomePanel, gameController.getPanelWithKey(0));
    }
    @Test
    public void createBonusPanelTest(){
        IPanel expectedBonusPanel = new BonusPanel(0);
        gameController.createBonusPanel(0);
        assertEquals(expectedBonusPanel, gameController.getPanelWithKey(0));
    }
    @Test
    public void createBossPanelTest(){
        BossPanel expectedBossPanel = new BossPanel(0);
        gameController.createBossPanel(0);
        assertEquals(expectedBossPanel, gameController.getPanelWithKey(0));
    }
    @Test
    public void createDrawPanelTest(){
        DrawPanel expectedDrawPanel = new DrawPanel(0);
        gameController.createDrawPanel(0);
        assertEquals(expectedDrawPanel, gameController.getPanelWithKey(0));
    }
    @Test
    public void createDropPanelTest(){
        DropPanel expectedDropPanel = new DropPanel(0);
        gameController.createDropPanel(0);
        assertEquals(expectedDropPanel, gameController.getPanelWithKey(0));
    }
    @Test
    public void createEncounterPanelTest(){
        EncounterPanel expectedEncounterPanel = new EncounterPanel(0);
        gameController.createEncounterPanel(0);
        assertEquals(expectedEncounterPanel, gameController.getPanelWithKey(0));
    }
    @Test
    public void createNeutralPanelTest(){
        NeutralPanel expectedNeutralPanel = new NeutralPanel(0);
        gameController.createNeutralPanel(0);
        assertEquals(expectedNeutralPanel, gameController.getPanelWithKey(0));
    }
    // end region.
    @Test
    public void createCharactersTest() {
        Player expectedSuguri = new Player("Suguri", 4, 1, -1, 2);
        BossUnit expectedShifuRobot = new BossUnit("Shifu Robot", 5, 1, 0, -1);
        WildUnit expectedSeagull = new WildUnit("Seagull", 3, 1, -1, -1);

        assertFalse(gameController.getPlayers().contains(expectedSuguri));
        assertFalse(gameController.getUnits().contains(expectedShifuRobot));
        assertFalse(gameController.getUnits().contains(expectedSeagull));

        gameController.createPlayer("Suguri", 4, 1, -1, 2);
        gameController.createBoss("Shifu Robot", 5, 1, 0, -1);
        gameController.createWild("Seagull", 3, 1, -1, -1);

        assertTrue(gameController.getPlayers().contains(expectedSuguri));
        assertTrue(gameController.getUnits().contains(expectedShifuRobot));
        assertTrue(gameController.getUnits().contains(expectedSeagull));
    }

    @Test
    public void assignNextPanelsTest() {
        IPanel panel = neutralPanelFactory.createWithKey(0);
        IPanel panel1 = homePanelFactory.createWithKey(1);
        IPanel panel2 = encounterPanelFactory.createWithKey(2);
        gameController.assignNextPanels(panel, panel1, panel2);
        assertTrue(panel.getNextPanels().contains(panel1));
        assertTrue(panel.getNextPanels().contains(panel2));
        // Adding the panel twice.
        gameController.assignNextPanels(panel, panel1);
        assertEquals(2, panel.getNextPanels().size());
        // Adding the same panel to next panels. No loop in the graph.
        gameController.assignNextPanels(panel, panel);
        assertFalse(panel.getNextPanels().contains(panel));
    }
    @Test
    public void setHomePanelTest() {
        IPlayer aPlayer = playerFactory.create("aPlayer", 4, 1, -1, 2);
        IPlayer suguri = playerFactory.create("Suguri", 4, 1, -1, 2);
        HomePanel panel = (HomePanel) homePanelFactory.createWithKey(1);
        suguri.setHomePanel(panel);
        gameController.setHomePanel(suguri, panel);
        assertEquals(panel, suguri.getHomePanel());
    }
    @Test
    public void thereIsWinnerTest() {
        //No players no winner.
        assertFalse(gameController.checkForWinner());
        gameController.createPlayer("Suguri", 4, 1, -1, 2);
        assertFalse(gameController.checkForWinner());
        for (int i=0; i<5; i++) {
            gameController.getPlayers().get(0).normaClear();
        }
        assertTrue(gameController.checkForWinner());
    }
    //@RepeatedTest(100)
    @Test
    public void movePlayerToTest() {
        // Some panels
        gameController.createBonusPanel(0);
        gameController.createBossPanel(1);
        gameController.createNeutralPanel(2);
        gameController.createDrawPanel(3);
        gameController.createEncounterPanel(4);
        // Moving to the current panel.
        gameController.movePlayerTo(suguri, 0);
        assertTrue(gameController.getPanelWithKey(0).containsCharacter(suguri));
        gameController.movePlayerTo(suguri, 0);
        assertTrue(gameController.getPanelWithKey(0).containsCharacter(suguri));
        // Random amount of steps
        int steps = random.nextInt(50);
        //Suguri performs a random walk.
        for (int i=0; i<steps; i++) {
            int previousKey = suguri.getCurrentPanel().getKey();
            int key = new Random().nextInt(5);
            gameController.movePlayerTo(suguri, key);
            // We check that the player actually leaves the panel only when the new panel is not the same as the original.
            if (previousKey!=key) {
                assertFalse(gameController.getPanelWithKey(previousKey).containsCharacter(suguri));
            }
            assertTrue(gameController.getPanelWithKey(key).containsCharacter(suguri));
        }

        gameController.movePlayerTo(suguri, 2);
        assertFalse(gameController.getPanelWithKey(0).containsCharacter(suguri));
        assertFalse(gameController.getPanelWithKey(1).containsCharacter(suguri));
        assertTrue(gameController.getPanelWithKey(2).containsCharacter(suguri));
    }
    @Test
    public void defineObjectiveTest() {
        gameController.createPlayer("Suguri", 4, 1, -1, 2);
        IPlayer suguri = gameController.getPlayers().get(0);
        gameController.setPLayerObjective(suguri, NormaGoal.STARS);
        assertEquals(NormaGoal.STARS, suguri.getObjective());
        gameController.setPLayerObjective(suguri, NormaGoal.WINS);
        assertEquals(NormaGoal.WINS, suguri.getObjective());
    }
    @Test
    public void normaClearTest() {
        // We create and get suguri.
        gameController.createPlayer("Suguri", 4, 1, -1, 2);
        IPlayer suguri = gameController.getPlayers().get(0);
        // We create, get and set the home panel.
        gameController.createHomePanel(0);
        gameController.setHomePanel(suguri, (HomePanel) gameController.getPanelWithKey(0));
        // suguri starts with norma 1.
        assertEquals(1, suguri.getNormaLevel());

        int[] stars = new int[]{10, 30, 70, 120, 200, 250};
        int[] wins = new int[]{0, 2, 5, 9, 14, 20};
        // Test the norma levels and hp:
        for (int i=0; i<5; i++) {
            int expectedNorma = i + 2;
            suguri.increaseStarsBy(stars[i]);
            suguri.increaseWinsBy(wins[i]);
            // Puts suguri on his home panel.
            gameController.movePlayerTo(suguri, 0);
            assertEquals(expectedNorma, suguri.getNormaLevel());
            //Reset stars and wins.
            suguri.reduceStarsBy(suguri.getStars());
            suguri.reduceWinsBy(suguri.getWins());
        }

    }

    /**
     * Auxiliar method to shaffle.
     * @param arrayList
     * @param seed
     * @return
     */
    private ArrayList<IPlayer> shuffle(ArrayList<IPlayer> arrayList, long seed) {
        Random random = new Random(seed);
        ArrayList<IPlayer> newArrayList = new ArrayList<>();
        final int len = arrayList.size();
        for (int i = 0; i<len; i++) {
            int ind = random.nextInt(arrayList.size());
            newArrayList.add(arrayList.get(ind));
            arrayList.remove(ind);
        }
        return newArrayList;
    }

    @RepeatedTest(100)
    public void turnOwnerTest() throws Exception {
        // We set the seed of the controller.
        gameController.setSeed(10);
        // Four players for the game.
        ArrayList<IPlayer> order = new ArrayList<>();
        gameController.createPlayer("Suguri", 4, 1, -1, 2);
        order.add(gameController.getPlayers().get(0));
        gameController.createPlayer("Marc", 4,1, 1, -1);
        order.add(gameController.getPlayers().get(1));
        gameController.createPlayer("Poppo", 7, -1, -1, -1);
        order.add(gameController.getPlayers().get(2));
        gameController.createPlayer("QP",5, 0, 0, 0);
        order.add(gameController.getPlayers().get(3));
        // Simulate the order.
        order = shuffle(order, 10);
        // Initiate the turns after adding the players.
        gameController.initiateTurns();
        // Random amount of iteration.
        int it = random.nextInt(50);
        for (int i = 0; i < it; i++) {
            assertEquals((i / 4) + 1, gameController.getChapter());
            assertEquals(order.get(i % 4), gameController.getTurnOwner());
            gameController.nextTurn();
        }
    }
    @Test
    public void stopPlayerTest() {
        /*
        for (int i = 0; i<10; i++) {
            suguri.movePlayer();
        }

         */
    }

}
