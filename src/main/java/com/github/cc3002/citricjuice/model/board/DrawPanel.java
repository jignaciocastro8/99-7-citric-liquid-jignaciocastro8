package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.characters.Player;

/**
 * Class that represents a Draw panel.
 */
public class DrawPanel extends Panel{
    /**
     * Creates a Draw panel.
     */
    public DrawPanel() {
        super(PanelType.DRAW);
    }

    /**
     * Draw panel version of activatedBy: NOT COMPLETED, THERE'S NOT CARDS'S CLASSES YET.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedBy(Player player) {

    }
}
