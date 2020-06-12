package com.github.cc3002.citricjuice.model.boardTest;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.ICharacterFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractPanelTest implements IPanelTest {
    /**
     * Creates a Panel.
     * @param key int.
     * @return a new Panel.
     */
    public abstract IPanel makePanel(int key);

    /**
     * Tests next panels method.
     */
    public void abstractNextPanelsTest() {
        IPanel panel = makePanel(1);
        IPanel panel1 = makePanel(3);
        IPanel panel2 = makePanel(5);
        IPanel panel3 = makePanel(7);
        // Simple size test.
        assertEquals(0, panel.getNextPanels().size());
        assertEquals(0, panel1.getNextPanels().size());
        assertEquals(0, panel2.getNextPanels().size());
        // Tests adding one panel.
        panel.addNextPanel(panel1);
        assertEquals(1, panel.getNextPanels().size());
        assertTrue(panel.getNextPanels().contains(panel1));
        // Tests adding the same panel twice.
        panel.addNextPanel(panel1);
        panel.addNextPanel(panel1);
        assertEquals(1, panel.getNextPanels().size());
        // Tests adding more than one panels.
        panel.addNextPanel(panel2);
        assertEquals(2, panel.getNextPanels().size());
        assertTrue(panel.getNextPanels().contains(panel2));
        panel.addNextPanel(panel3);
        assertEquals(3, panel.getNextPanels().size());
        assertTrue(panel.getNextPanels().contains(panel3));
    }

    /**
     * Tests the getType method.
     */
    public abstract void getTypeTest();

    /**
     * Tests getKey method.
     */
    public void abstractGetKeyTest() {
        int key = new Random().nextInt();
        IPanel panel = makePanel(key);
        assertEquals(key, panel.getKey());
    }

    /**
     * Tests add player method.
     */
    public void abstractAddPlayerTest() {
        ICharacterFactory factory = new PlayerFactory();
        IPanel panel = makePanel(0);
        for (int i = 0; i < 10; i++) {
            Player player = (Player) factory.create("Name" + i, i, i, i, i);
            panel.addPlayer(player);
            assertEquals(i + 1, panel.getPlayers().size());
            assertTrue(panel.getPlayers().contains(player));
        }
    }
}
