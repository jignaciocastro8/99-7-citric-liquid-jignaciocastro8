package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;

/**
 * Class that represents a Encounter panel.
 */
public class EncounterPanel extends Panel {
    /**
     * Creates a Encounter panel.
     */
    public EncounterPanel(int key) {
        super(PanelType.ENCOUNTER, key);
    }

    /**
     * Encounter panel version of activatedBy: NOT COMPLETED, THERE'S NOT BATTLES'S CLASSES YET.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedByParticular(IPlayer player) {
        // AQUI DEBE EMPEZAR UNA BATALLA.
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
