package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.BossPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BossPanelTest {
    BossPanel testBossPanel;
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testBossPanel = new BossPanel(new int[]{0, 0});
    }
    @Test
    public void constructorTest() {
        BossPanel expected = new BossPanel(new int[]{0, 0});
        assertEquals(expected, testBossPanel);
    }
}
