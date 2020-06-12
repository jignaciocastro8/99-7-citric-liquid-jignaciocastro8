package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.Board;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private IPanelFactory bonusPanelFactory = new BonusPanelFactory();
    private IPanelFactory bossPanelFactory = new BossPanelFactory();
    private IPanelFactory drawPanelFactory = new DrawPanelFactory();
    private IPanelFactory dropPanelFactory = new DropPanelFactory();
    private IPanelFactory encounterPanelFactory = new EncounterPanelFactory();
    private IPanelFactory homePanelFactory = new HomePanelFactory();
    private IPanelFactory neutralPanelFactory = new NeutralPanelFactory();
    private Board board = new Board();

    /**
     * Tests addPanel method.
     */
    @Test
    public void addPanelTest() throws Exception {
        IPanel panel1 = homePanelFactory.createWithKey(1);
        IPanel panel2 = neutralPanelFactory.createWithKey(2);
        IPanel panel3 = bossPanelFactory.createWithKey(3);
        board.addPanel(panel1);
        assertEquals(panel1, board.getPanel(1));
        assertEquals(1, board.numberOfPanels());
        board.addPanel(panel2);
        assertEquals(panel2, board.getPanel(2));
        assertEquals(2, board.numberOfPanels());
        board.addPanel(panel3);
        assertEquals(panel3, board.getPanel(3));
        assertEquals(3, board.numberOfPanels());
        // Here we test adding the same panel twice.
        //board.addPanel(panel1);
        //assertEquals(3, board.numberOfPanels());
    }
    @Test
    public void getPanelTest() {
        IPanel panel1 = homePanelFactory.createWithKey(1);
        IPanel panel2 = neutralPanelFactory.createWithKey(2);
        IPanel panel3 = bossPanelFactory.createWithKey(3);
        board.addPanel(panel1);
        board.addPanel(panel2);
        board.addPanel(panel3);
        assertEquals(panel1, board.getPanel(1));
        assertEquals(panel2, board.getPanel(2));
        assertEquals(panel3, board.getPanel(3));
    }
}
