package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.NeutralPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeutralPanelTest {
    NeutralPanel testNeutralPanel;
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testNeutralPanel = new NeutralPanel(new int[]{0, 0});
    }
    @Test
    public void constructorTest() {
        NeutralPanel expected = new NeutralPanel(new int[]{0, 0});
        assertEquals(expected, testNeutralPanel);
    }
}
