package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.BonusPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.EncounterPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.HomePanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.IPlayerFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;
import com.github.cc3002.citricliquid.controller.gameFlux.GameFlux;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameFluxTest {

    private GameFlux gameFlux;

    private IPlayerFactory playerFactory;

    private IPanelFactory homePanelFactory;
    private IPanelFactory bonusPanelFactory;
    private IPanelFactory encounterPanelFactory;

    public void createTriangleBoard() {
        homePanelFactory = new HomePanelFactory();
        bonusPanelFactory = new BonusPanelFactory();
        encounterPanelFactory = new EncounterPanelFactory();
        IPanel homePanel = homePanelFactory.createWithKey(0);
        IPanel bonusPanel = bonusPanelFactory.createWithKey(1);
        IPanel encounterPanel = encounterPanelFactory.createWithKey(2);
        // Create the triangle.
        homePanel.addNextPanel(bonusPanel);
        bonusPanel.addNextPanel(encounterPanel);
        encounterPanel.addNextPanel(homePanel);
    }


    @BeforeEach
    public void setUp () {
        gameFlux = new GameFlux();
        playerFactory = new PlayerFactory();
    }
    @Test
    public void inititateTurnTest() {
        IPlayer suguri = playerFactory.createSuguri();
        // No KO case.
        int chapter = 3;
        int expectedStars = suguri.getStars() +  Math.floorDiv(chapter, 5) + 1;
        gameFlux.initiateTurn(suguri, chapter);
        assertEquals(expectedStars, suguri.getStars());
        // KO case.
        suguri.setCurrentHP(0);
        gameFlux.initiateTurn(suguri, 1);
        assertTrue(suguri.isRecovering());


    }

    @Test
    public void rollAndSimpleMoveTest() {
        long seed = 1;
        Random ran = new Random(seed);
        // Create a player and set the seed.
        IPlayer suguri = playerFactory.createSuguri();
        suguri.setSeed(seed);
        //
    }
}
