package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.characters.Player;

/**
 * Class that represents a NeutralPanel
 */
public class NeutralPanel extends Panel {

    /**
     * Create a Neutral Panel.
     */
    public NeutralPanel(int[] coordinates) {
        super(PanelType.NEUTRAL, coordinates);
    }

    /**
     * Neutral panel version of activatedBy.
     * @param player
     */
    @Override
    public void activatedBy(Player player) { }
}
