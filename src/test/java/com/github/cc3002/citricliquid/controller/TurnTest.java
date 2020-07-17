package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.*;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.IPlayerFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;
import com.github.cc3002.citricliquid.gameFlux.Turn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TurnTest {

    private Turn turn;

    private IPlayerFactory playerFactory;

    /**
     * Creates a panel with multiple next panels.
     */
    private IPanel createPanelWithNextPanels() {

        // Create factories.
        IPanelFactory homePanelFactory = new HomePanelFactory();
        IPanelFactory bonusPanelFactory = new BonusPanelFactory();
        IPanelFactory encounterPanelFactory = new EncounterPanelFactory();
        IPanelFactory neutralPanelFactory = new NeutralPanelFactory();
        // Create panels.
        IPanel panel0 = homePanelFactory.createWithKey(0);
        IPanel panel1 = bonusPanelFactory.createWithKey(1);
        IPanel panel2 = encounterPanelFactory.createWithKey(2);
        IPanel panel3 = neutralPanelFactory.createWithKey(3);
        // Connect the panels.
        panel0.addNextPanel(panel1, panel2, panel3);
        return panel0;
    }


    @BeforeEach
    public void setUp () {
        turn = new Turn();
        playerFactory = new PlayerFactory();
    }
    @Test
    public void initiateTurnTest() {
        IPlayer suguri = playerFactory.createSuguri();
        // No KO case.
        int chapter = 3;
        int expectedStars = suguri.getStars() +  Math.floorDiv(chapter, 5) + 1;
        turn.initiateTurn(suguri, chapter);
        assertEquals(expectedStars, suguri.getStars());
        // KO case.
        suguri.setCurrentHP(0);
        turn.initiateTurn(suguri, 1);
        assertTrue(suguri.isRecovering());


    }


    @Test
    public void askPlayerForCardTest() {
        IPlayer suguri = playerFactory.createSuguri();
        suguri.setAnswerForPlayCard(true);
        assertTrue(turn.askForPlayCard(suguri));
        suguri.setAnswerForPlayCard(false);
        assertFalse(turn.askForPlayCard(suguri));
    }

    @Test
    public void meetAnotherPlayerAndAskTest() {
        IPlayer suguri = playerFactory.createSuguri();
        IPlayer marc = playerFactory.createMarc();
        // NO waiting sate.
        assertFalse(turn.isWaiting());
        // Set suguri's answer for battle. This will be done by ask() method.
        suguri.setAnswerForBattle(false);
        // Check answer and state of the turn.
        assertFalse(turn.askForBattle(suguri, marc));
        assertTrue(turn.isWaiting());
        // Set suguri's answer for battle. This will be done by ask() method.
        suguri.setAnswerForBattle(true);
        // Check answer.
        assertTrue(turn.askForBattle(suguri, marc));
        assertTrue(turn.isWaiting());
    }

    @Test
    public void edvOrDef() {
        IPlayer suguri = playerFactory.createSuguri();
        // Set answer. True: Evd, False: Def.
        suguri.setEvdOrDefAnswer(true);
        assertTrue(turn.askEvdOrDef(suguri));
        // Set answer. True: Evd, False: Def.
        suguri.setEvdOrDefAnswer(false);
        assertFalse(turn.askEvdOrDef(suguri));
    }
    @Test
    public void nextPanelDecisionTest() {
        IPlayer suguri = playerFactory.createSuguri();
        IPanel panel = createPanelWithNextPanels();
        // Set decision.
        suguri.setNextPanelDecision(panel.getNextPanels().get(0));
        // Ask suguri to choose a panel.
        turn.askForNextPanel(suguri, panel.getNextPanels());
        // Test
        assertTrue(turn.isWaiting());
        assertEquals(panel.getNextPanels().get(0), suguri.getNextPanelDecision());

    }

}
