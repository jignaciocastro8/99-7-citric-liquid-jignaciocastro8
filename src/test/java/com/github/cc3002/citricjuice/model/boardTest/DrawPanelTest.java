package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.DrawPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.DrawPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import com.github.cc3002.citricjuice.model.board.PanelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawPanelTest extends AbstractPanelTest {
    DrawPanel testDrawPanel;
    IPanelFactory factory = new DrawPanelFactory();
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testDrawPanel = new DrawPanel(0);
    }
    @Test
    public void constructorTest() {
        DrawPanel expected = new DrawPanel(0);
        assertEquals(expected, testDrawPanel);
    }
    @Override
    public IPanel makePanel(int key) {
        return factory.createWithKey(key);
    }

    @Override
    @Test
    public void getTypeTest() {
        IPanel panel = factory.createWithKey(0);
        assertEquals(PanelType.DRAW, panel.getType());
    }

    @Test
    @Override
    public void nextPanelsTest() {
        abstractNextPanelsTest();
    }

    @Override
    @RepeatedTest(100)
    public void getKeyTest() {
        abstractGetKeyTest();
    }

    @Override
    @Test
    public void addPlayerTest() {
        abstractAddPlayerTest();
    }
}
