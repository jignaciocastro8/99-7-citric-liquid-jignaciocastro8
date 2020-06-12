package com.github.cc3002.citricjuice.model.board;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Objects;

public class Board implements IBoard{

    private Hashtable<Integer, IPanel> panels;

    public Board() {
        panels = new Hashtable();
    }

    public IPanel getPanel(int key) {
        return this.panels.get(key);
    }

    /**
     * Adds the panel to the board.
     * @param panel IPanel.
     */
    @Override
    public void addPanel(IPanel panel) {
        int key = panel.getKey();
        if (this.panels.containsKey(key)) {
            throw new AssertionError("Key already used");
        }
        this.panels.put(key, panel);
    }

    /**
     * Returns the number of panels in the board.
     * @return Int.
     */
    @Override
    public int numberOfPanels() {
        return this.panels.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(panels, board.panels);
    }

}
