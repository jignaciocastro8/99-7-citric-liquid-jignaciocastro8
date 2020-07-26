package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.IPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardControllerTest {

    private BoardController boardController;

    @BeforeEach
    public void setUp() {
        boardController = new BoardController();
    }

    @Test
    public void getHomePanelsTest() {
        // Create 4 home panels.
        ArrayList<IPanel> panels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            panels.add(boardController.createHomePanel(i));
        }
        // Test
        ArrayList<IPanel> homePanels = boardController.getHomePanels();
        assertEquals(4, homePanels.size());
        for (IPanel panel : panels) {
            assertTrue(homePanels.contains(panel));
        }

    }
}
