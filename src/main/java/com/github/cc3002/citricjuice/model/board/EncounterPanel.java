package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.characters.Player;

/**
 * Class that represents a Encounter panel.
 */
public class EncounterPanel extends Panel {
    /**
     * Creates a Encounter panel.
     */
    public EncounterPanel() {
        super(PanelType.ENCOUNTER);
    }

    /**
     * Encounter panel version of activatedBy: NOT COMPLETED, THERE'S NOT BATTLES'S CLASSES YET.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedBy(Player player) {

    }
}
