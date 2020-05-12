package com.github.cc3002.citricjuice.model.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawPanelTest {
    DrawPanel testDrawPanel;
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testDrawPanel = new DrawPanel(new int[]{0, 0});
    }
    @Test
    public void constructorTest() {
        DrawPanel expected = new DrawPanel(new int[]{0, 0});
        assertEquals(expected, testDrawPanel);
    }
}
