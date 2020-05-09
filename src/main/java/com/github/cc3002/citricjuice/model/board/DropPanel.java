package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;

import java.util.Random;

/**
 * Class that represents a Drop panel.
 */
public class DropPanel extends Panel {
    private final Random random;

    /**
     * Creates a Drop panel.
     */
    public DropPanel(int[] coordinates) {
        super(PanelType.DROP, coordinates);
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
