package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;

/**
 * Class that represents a Drop panel. It doesn't have a random object.
 */
public class DropPanel extends Panel {

    /**
     * Creates a Drop panel.
     */
    public DropPanel(int[] coordinates) {
        super(PanelType.DROP, coordinates);
    }

    /**
     * Drop panel version of activated by: decreases the player's stars depending of his/hers norma.
     * The randomness comes from the player.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedBy(Player player) {
        int roll = player.roll();
        player.reduceStarsBy(roll * player.getNormaLevel());
    }
}
