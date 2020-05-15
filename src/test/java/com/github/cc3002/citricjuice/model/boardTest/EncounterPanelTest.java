package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.EncounterPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncounterPanelTest {
    EncounterPanel testEncounterPanel;
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testEncounterPanel = new EncounterPanel(new int[]{0, 0});
    }
    @Test
    public void constructorTest() {
        EncounterPanel expected = new EncounterPanel(new int[]{0, 0});
        assertEquals(expected, testEncounterPanel);
    }
}
