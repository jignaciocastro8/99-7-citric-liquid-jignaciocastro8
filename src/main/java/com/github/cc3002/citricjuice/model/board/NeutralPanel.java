package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;

/**
 * Class that represents a NeutralPanel
 */
public class NeutralPanel extends Panel {

    /**
     * Create a Neutral Panel.
     */
    public NeutralPanel(int key) {
        super(PanelType.NEUTRAL, key);
    }

    /**
     * Neutral panel version of activatedBy.
     * @param player IPlayer.
     */
    @Override
    public void activatedByParticular(IPlayer player) { }

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
