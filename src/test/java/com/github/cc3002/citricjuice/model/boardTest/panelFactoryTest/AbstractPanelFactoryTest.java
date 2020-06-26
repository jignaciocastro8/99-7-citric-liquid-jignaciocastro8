package com.github.cc3002.citricjuice.model.boardTest.panelFactoryTest;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class  AbstractPanelFactoryTest implements IPanelFactoryTest {
    /**
     * Creates an IPanelFactory.
     * @return IPanelFactory.
     */
    public abstract IPanelFactory makePanelFactory();

    /**
     * Creates a Panel in the classical way (without factory).
     * @return IPanel.
     */
    public abstract IPanel makePanel(int key);

    public void abstractCreateWithKeyTest() {
        IPanelFactory factory = makePanelFactory();
        int key = new Random().nextInt();
        IPanel expectedPanel = makePanel(key);
        assertEquals(expectedPanel, factory.createWithKey(key));
    }
}
