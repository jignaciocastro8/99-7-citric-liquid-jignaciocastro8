package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ObserverTest {
    GameController controller;

    IPlayer suguri;
    IPlayer marc;

    Random random;
    @BeforeEach
    public void setUp() {
        controller = new GameController();

        suguri = controller.createSuguri();
        marc = controller.createMarc();

        random = new Random(6);
    }

    @Test
    public void activateEffectEndsTurnTest() {
        HomePanel panel = (HomePanel) controller.createHomePanel(0);
        controller.setHomePanel(suguri, panel);
        controller.movePlayerTo(suguri, 0);
        controller.getPanelWithKey(0).activatedBy(suguri);
        assertNotEquals(suguri, controller.getTurnOwner());
        assertEquals(marc, controller.getTurnOwner());
    }

    @Test
    public void aPlayerWinsTest() {
        for (int i = 0; i < 5; i++) {
            suguri.normaClear();
        }
        assertEquals(suguri, controller.getWinner());
        assertTrue(controller.checkForWinner());
        assertEquals(suguri, controller.getWinner());
    }

    @Test
    public void encounterAnotherPlayerTest() {
        // Create a panel.
        controller.createNeutralPanel(0);
        // Put marc on the panel.
        controller.movePlayerTo(marc, 0);
        // Move suguri to the same panel.
        controller.movePlayerTo(suguri, 0);
        // suguri must be waiting.
        assertFalse(suguri.isMoving());
        assertTrue(suguri.isWaitingOnPanel());
    }


    @Test
    public void passOverHomePanelTest() {
        // Create a home panel.
        HomePanel panel = (HomePanel) controller.createHomePanel(0);
        // Set as suguri home panel.
        controller.setHomePanel(suguri, panel);
        // Move suguri to the home panel.
        controller.movePlayerTo(suguri, 0);
        // suguri must be waiting and not moving.
        assertFalse(suguri.isMoving());
        assertTrue(suguri.isWaitingOnPanel());
    }

    @Test
    public void moreThanOneNextPanelTest() {
        // Create panels.
        IPanel panel = controller.createHomePanel(0);
        controller.createNeutralPanel(1);
        controller.createNeutralPanel(2);
        // Assign home panel to suguri (It is necessary)
        controller.setHomePanel(suguri, (HomePanel) panel);
        // Connect panels.
        controller.assignNextPanelsWithKey(0,1,2);
        // Move suguri to the panel 0.
        controller.movePlayerTo(suguri, 0);
        // suguri must be waiting and not moving.
        assertFalse(suguri.isMoving());
        assertTrue(suguri.isWaitingOnPanel());
    }


    @Test
    public void stopsWhenThePanelHasPlayersTest() throws Exception {
        controller.createNeutralPanel(0);
        controller.createDrawPanel(1);
        IPanel expectedPanel = controller.getPanelWithKey(1);
        controller.movePlayerTo(suguri, 0);
        controller.movePlayerTo(marc, 1);
        // Connect the panels.
        controller.assignNextPanelsWithKey(0, 1);
        //Initiate the game.
        controller.initiateGame();
        controller.movePlayer(suguri, 1);
        assertTrue(suguri.isWaitingOnPanel());
        assertEquals(expectedPanel, suguri.getCurrentPanel());
    }
    /*
    @Test
    public void movePlayerToExceptionTest() {
        PlayerController.NoSuchPlayerOnTheGameException ex = assertThrows(PlayerController.NoSuchPlayerOnTheGameException.class, () -> {
            controller.movePlayerTo(controller.createSuguri(), 12);
        });
        String expectedErrMsg = "There's not such player in the game";
        String actualErrMsg = ex.getMessage();
        System.out.println(actualErrMsg);
        assertTrue(actualErrMsg.contains(expectedErrMsg));
    }

     */




    @RepeatedTest(100)
    public void movePlayerToTest() throws PlayerController.NoSuchPlayerOnTheGameException {
        controller.createPlayer("Suguri", 4, 1, -1, 2);
        suguri = controller.getPlayers().get(0);
        // Some panels
        controller.createBonusPanel(0);
        controller.createBossPanel(1);
        controller.createNeutralPanel(2);
        controller.createDrawPanel(3);
        controller.createEncounterPanel(4);
        // Moving to the current panel.
        controller.movePlayerTo(suguri, 0);
        assertTrue(controller.getPanelWithKey(0).containsCharacter(suguri));
        controller.movePlayerTo(suguri, 0);
        assertTrue(controller.getPanelWithKey(0).containsCharacter(suguri));
        // Random amount of steps
        int steps = random.nextInt(50);
        //Suguri performs a random walk.
        for (int i=0; i<steps; i++) {
            int previousKey = suguri.getCurrentPanel().getKey();
            int key = new Random().nextInt(5);
            controller.movePlayerTo(suguri, key);
            // We check that the player actually leaves the panel only when the new panel is not the same as the original.
            if (previousKey != key) {
                assertFalse(controller.getPanelWithKey(previousKey).containsCharacter(suguri));
            }
            assertTrue(controller.getPanelWithKey(key).containsCharacter(suguri));
        }

        controller.movePlayerTo(suguri, 2);
        assertFalse(controller.getPanelWithKey(0).containsCharacter(suguri));
        assertFalse(controller.getPanelWithKey(1).containsCharacter(suguri));
        assertTrue(controller.getPanelWithKey(2).containsCharacter(suguri));
    }


    @Test
    public void completeMotionTest() {
        // Test panels.
        IPanel panel0 = controller.createNeutralPanel(0);
        IPanel panel1 = controller.createNeutralPanel(1);
        IPanel panel2 = controller.createNeutralPanel(2);
        IPanel panel3 = controller.createNeutralPanel(3);
        // Connect panels.
        controller.assignNextPanelsWithKey(0,1);
        controller.assignNextPanelsWithKey(1, 2, 3);
        // Put suguri on the first panel.
        controller.movePlayerTo(suguri, 0);
        // Realisation of a complete motion of 3 steps.
        int steps = 3;
        controller.movePlayer(suguri, steps);
        // Suguri must be waiting on the panel 1.
        assertTrue(suguri.isWaitingOnPanel());
        assertEquals(panel1, suguri.getCurrentPanel());
    }
}
