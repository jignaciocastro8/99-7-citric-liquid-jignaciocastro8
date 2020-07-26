package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;

/**
 * Class that represents a bonus panel. It doesn't have a random object.
 */
public class BonusPanel extends Panel {

    /**
     * Creates a bonus panel.
     */
    public BonusPanel(int key) {
        super(PanelType.BONUS, key);
    }
    /***
     * Bonus panel version of activatedBy: increases the player's stars depending of his/hers norma.
     * The randomness comes from the player.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedByParticular(IPlayer player) {
        int roll = player.roll();
        player.increaseStarsBy(Math.min(roll * player.getNormaLevel(), 3 * roll));
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
