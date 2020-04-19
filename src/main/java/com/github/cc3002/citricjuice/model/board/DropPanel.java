package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.characters.Player;

import java.util.Random;

/**
 * Class that represents a Drop panel.
 */
public class DropPanel extends Panel {
    private final Random random;

    /**
     * Creates a Drop panel.
     */
    public DropPanel() {
        super(PanelType.DROP);
        random = new Random();
    }

    /**
     * Drop panel version of activated by: decreases the player's stars depending of his/hers norma.
     * @param player: the player that activates the panel.
     */
    @Override
    public void activatedBy(Player player) {
        int roll = random.nextInt(6) + 1;
        player.reduceStarsBy(roll * player.getNormaLevel());
    }
}
