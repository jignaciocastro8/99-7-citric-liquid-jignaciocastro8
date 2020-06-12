package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.BossPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.BossPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import com.github.cc3002.citricjuice.model.board.PanelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BossPanelTest extends AbstractPanelTest {
    BossPanel testBossPanel;
    IPanelFactory factory = new BossPanelFactory();
    @BeforeEach
    public void setUp() {
        // We are not interested in the coordinate parameter, could be anything.
        testBossPanel = new BossPanel(0);
    }
    @Test
    public void constructorTest() {
        BossPanel expected = new BossPanel(0);
        assertEquals(expected, testBossPanel);
    }

    @Override
    public IPanel makePanel(int key) {
        return factory.createWithKey(key);
    }

    @Override
    @Test
    public void getTypeTest() {
        IPanel panel = factory.createWithKey(0);
        assertEquals(PanelType.BOSS, panel.getType());
    }

    @Test
    @Override
    public void nextPanelsTest() {
        abstractNextPanelsTest();
    }

    @Override
    @RepeatedTest(100)
    public void getKeyTest() {
        int key = new Random().nextInt();
        abstractGetKeyTest();
    }

    @Override
    public void addPlayerTest() {
        abstractAddPlayerTest();
    }

}
