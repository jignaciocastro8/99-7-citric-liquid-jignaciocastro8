package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.EncounterPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.EncounterPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import com.github.cc3002.citricjuice.model.board.PanelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncounterPanelTest extends AbstractPanelTest {
    EncounterPanel testEncounterPanel;
    IPanelFactory factory = new EncounterPanelFactory();
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testEncounterPanel = new EncounterPanel(0);
    }
    @Test
    public void constructorTest() {
        EncounterPanel expected = new EncounterPanel(0);
        assertEquals(expected, testEncounterPanel);
    }
    @Override
    public IPanel makePanel(int key) {
        return factory.createWithKey(key);
    }

    @Override
    @Test
    public void getTypeTest() {
        IPanel panel = factory.createWithKey(0);
        assertEquals(PanelType.ENCOUNTER, panel.getType());
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
