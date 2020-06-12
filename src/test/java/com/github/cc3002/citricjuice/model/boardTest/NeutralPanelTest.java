package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.NeutralPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.NeutralPanelFactory;
import com.github.cc3002.citricjuice.model.board.PanelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeutralPanelTest extends AbstractPanelTest {
    NeutralPanel testNeutralPanel;
    IPanelFactory factory = new NeutralPanelFactory();
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testNeutralPanel = new NeutralPanel(0);
    }
    @Test
    public void constructorTest() {
        NeutralPanel expected = new NeutralPanel(0);
        assertEquals(expected, testNeutralPanel);
    }
    @Override
    public IPanel makePanel(int key) {
        return factory.createWithKey(key);
    }

    /**
     * Tests the getType method.
     */
    @Override
    public void getTypeTest() {
        IPanel panel = factory.createWithKey(0);
        assertEquals(PanelType.NEUTRAL, panel.getType());
    }

    @Test
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
