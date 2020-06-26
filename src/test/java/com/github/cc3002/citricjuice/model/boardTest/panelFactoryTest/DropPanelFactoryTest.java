package com.github.cc3002.citricjuice.model.boardTest.panelFactoryTest;

import com.github.cc3002.citricjuice.model.board.DropPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.DropPanelFactory;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import org.junit.jupiter.api.RepeatedTest;

public class DropPanelFactoryTest extends AbstractPanelFactoryTest {
    /**
     * Creates an IPanelFactory.
     * @return IPanelFactory.
     */
    @Override
    public IPanelFactory makePanelFactory() {
        return new DropPanelFactory();
    }

    /**
     * Creates a Panel in the classical way (without factory).
     * @param key int.
     * @return IPanel.
     */
    @Override
    public IPanel makePanel(int key) {
        return new DropPanel(key);
    }

    @Override
    @RepeatedTest(100)
    public void createWithKeyTest() {
        abstractCreateWithKeyTest();
    }
}
