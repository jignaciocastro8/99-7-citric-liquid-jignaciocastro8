package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;

public class BossPanel extends Panel {
    /**
     * Creates a Encounter panel.
     */
    public BossPanel(int[] coordinates) {
        super(PanelType.BOSS, coordinates);
    }

    /**
     * Boss panel version of activatedBy: NOT COMPLETED, THERE'S NOT BATTLES'S CLASSES YET.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedBy(Player player) {

    }
}
