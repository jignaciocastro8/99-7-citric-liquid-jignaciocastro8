package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.characters.Player;

import java.util.Random;

/**
 * Class that represents a bonus panel.
 */
public class BonusPanel extends Panel {
    private final Random random;

    /**
     * Creates a bonus panel.
     */
    public BonusPanel() {
        super(PanelType.BONUS);
        random = new Random();
    }

    /***
     * Bonus panel version of activatedBy: increases the player's stars depending of his/hers norma.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedBy(Player player) {
        int roll = random.nextInt(6) + 1;
        player.increaseStarsBy(Math.min(roll * player.getNormaLevel(), 3 * roll));
    }
}
