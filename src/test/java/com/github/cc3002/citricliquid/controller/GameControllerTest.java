package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.*;

import com.github.cc3002.citricjuice.model.board.panelFactory.*;
import com.github.cc3002.citricjuice.model.gameCharacters.BossUnit;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import com.github.cc3002.citricjuice.model.gameCharacters.WildUnit;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.BossFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.ICharacterFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.WildFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {
    private ICharacterFactory playerFactory =  new PlayerFactory();
    private ICharacterFactory wildFactory =  new WildFactory();
    private ICharacterFactory bossFactory =  new BossFactory();

    private IPanelFactory bonusPanelFactory = new BonusPanelFactory();
    private IPanelFactory bossPanelFactory = new BossPanelFactory();
    private IPanelFactory drawPanelFactory = new DrawPanelFactory();
    private IPanelFactory dropPanelFactory = new DropPanelFactory();
    private IPanelFactory encounterPanelFactory = new EncounterPanelFactory();
    private IPanelFactory homePanelFactory = new HomePanelFactory();
    private IPanelFactory neutralPanelFactory = new NeutralPanelFactory();

    private IGameController gameController;
    private Player suguri;
    private Player marc;
    @BeforeEach
    public void setUp(){
        gameController = (IGameController) new GameController();
    }

    // The next region is for test all the createPanel methods.
    @Test
    public void createHomePanelTest(){
        HomePanel expectedHomePanel = new HomePanel(0);
        gameController.createHomePanel(0);
        assertEquals(expectedHomePanel, gameController.getBoardPanel(0));
    }
    @Test
    public void createBonusPanelTest(){
        IPanel expectedBonusPanel = new BonusPanel(0);
        gameController.createBonusPanel(0);
        assertEquals(expectedBonusPanel, gameController.getBoardPanel(0));
    }
    @Test
    public void createBossPanelTest(){
        BossPanel expectedBossPanel = new BossPanel(0);
        gameController.createBossPanel(0);
        assertEquals(expectedBossPanel, gameController.getBoardPanel(0));
    }
    @Test
    public void createDrawPanelTest(){
        DrawPanel expectedDrawPanel = new DrawPanel(0);
        gameController.createDrawPanel(0);
        assertEquals(expectedDrawPanel, gameController.getBoardPanel(0));
    }
    @Test
    public void createDropPanelTest(){
        DropPanel expectedDropPanel = new DropPanel(0);
        gameController.createDropPanel(0);
        assertEquals(expectedDropPanel, gameController.getBoardPanel(0));
    }
    @Test
    public void createEncounterPanelTest(){
        EncounterPanel expectedEncounterPanel = new EncounterPanel(0);
        gameController.createEncounterPanel(0);
        assertEquals(expectedEncounterPanel, gameController.getBoardPanel(0));
    }
    @Test
    public void createNeutralPanelTest(){
        NeutralPanel expectedNeutralPanel = new NeutralPanel(0);
        gameController.createNeutralPanel(0);
        assertEquals(expectedNeutralPanel, gameController.getBoardPanel(0));
    }
    // end region.
    @Test
    public void createPlayersTest() {
        Player expectedSuguri = new Player("Suguri", 4, 1, -1, 2);
        BossUnit expectedShifuRobot = new BossUnit("Shifu Robot", 5, 1, 0, -1);
        WildUnit expectedSeagull = new WildUnit("Seagull", 3, 1, -1, -1);

        assertFalse(gameController.getCharacters().contains(expectedSuguri));
        assertFalse(gameController.getCharacters().contains(expectedShifuRobot));
        assertFalse(gameController.getCharacters().contains(expectedSeagull));

        gameController.createPlayer("Suguri", 4, 1, -1, 2);
        gameController.createBoss("Shifu Robot", 5, 1, 0, -1);
        gameController.createWild("Seagull", 3, 1, -1, -1);

        assertTrue(gameController.getCharacters().contains(expectedSuguri));
        assertTrue(gameController.getCharacters().contains(expectedShifuRobot));
        assertTrue(gameController.getCharacters().contains(expectedSeagull));
    }

    public void assignPlayerToPanelTest() {
        /*
        ICharacter expectedSuguri = playerFactory.create("Suguri", 4, 1, -1, 2);
        IPanel panel = homePanelFactory.createWithKey(0);
        gameController.assignPlayerToPanel(suguri, panel);

         */
    }
}
