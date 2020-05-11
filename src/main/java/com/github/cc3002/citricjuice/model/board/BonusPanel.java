package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;

import java.util.Random;

/**
 * Class that represents a bonus panel. It doesn't have a random object.
 */
public class BonusPanel extends Panel {

    /**
     * Creates a bonus panel.
     */
    public BonusPanel(int[] coordinates) {
        super(PanelType.BONUS, coordinates);
    }
    /***
     * Bonus panel version of activatedBy: increases the player's stars depending of his/hers norma.
     * The randomness comes from the player.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedBy(Player player) {
        int roll = player.roll();
        player.increaseStarsBy(Math.min(roll * player.getNormaLevel(), 3 * roll));
    }
}
