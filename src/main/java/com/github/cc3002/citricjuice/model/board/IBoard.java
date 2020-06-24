package com.github.cc3002.citricjuice.model.board;

import java.util.ArrayList;

public interface IBoard {
    /**
     * Getter of the panel with its key.
     * @param key Int
     * @return IPanel.
     */
    IPanel getPanelWithKey(int key);

    /**
     * Adds the panel to the board.
     * @param panel IPanel.
     */
    void addPanel(IPanel panel);
    /**
     * Returns the number of panels in the board.
     * @return Int.
     */
    int numberOfPanels();

    /**
     * Getter of an ArrayList with all the panels of the board.
     * @return ArrayList with IPanels.
     */
    ArrayList<IPanel> getPanels();

    /**
     * Checks if panel is in the board.
     * @param panel IPanel.
     * @return boolean.
     */
    boolean containsPanel(IPanel panel);
}
