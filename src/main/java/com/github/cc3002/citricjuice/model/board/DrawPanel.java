package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;

/**
 * Class that represents a Draw panel.
 */
public class DrawPanel extends Panel {
    /**
     * Creates a Draw panel.
     */
    public DrawPanel(int key) {
        super(PanelType.DRAW, key);
    }

    /**
     * Draw panel version of activatedBy: NOT COMPLETED, THERE'S NOT CARDS'S CLASSES YET.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedByParticular(IPlayer player) {

    }

    /**
     * True if this is a home panel, false if not.
     *
     * @return boolean.
     */
    @Override
    public boolean isHomePanel() {
        return false;
    }
}
