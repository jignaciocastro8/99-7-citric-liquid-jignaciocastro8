package com.github.cc3002.citricjuice.model.boardTest.panelFactoryTest;

import com.github.cc3002.citricjuice.model.board.EncounterPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.EncounterPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import org.junit.jupiter.api.RepeatedTest;

public class EncounterPanelFactoryTest extends AbstractPanelFactoryTest {
    /**
     * Creates an IPanelFactory.
     * @return IPanelFactory.
     */
    @Override
    public IPanelFactory makePanelFactory() {
        return new EncounterPanelFactory();
    }

    /**
     * Creates a Panel in the classical way (without factory).
     * @param key int.
     * @return IPanel.
     */
    @Override
    public IPanel makePanel(int key) {
        return new EncounterPanel(key);
    }

    @Override
    @RepeatedTest(100)
    public void createWithKeyTest() {
        abstractCreateWithKeyTest();
    }
}
