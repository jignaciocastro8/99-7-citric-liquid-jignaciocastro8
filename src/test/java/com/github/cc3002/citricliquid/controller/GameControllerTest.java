package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.*;

import com.github.cc3002.citricjuice.model.gameCharacters.BossUnit;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import com.github.cc3002.citricjuice.model.gameCharacters.WildUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {
    private IGameController gameController;
    private Player suguri;
    private Player marc;
    @BeforeEach
    public void setUp(){
        gameController = (IGameController) new GameController();
    }
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
    @Test
    public void createBoardTest() {
        Board expectedBoard = new Board(3,3);
        gameController.createBoard(3, 3);
        assertEquals(expectedBoard, gameController.getBoard());
    }
}
