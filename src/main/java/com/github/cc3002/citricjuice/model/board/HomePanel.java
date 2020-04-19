package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.characters.Player;

/**
 * Class that represents a HomePanel.
 */
public class HomePanel extends Panel {
    private Player playerOwner;

    /**
     * Creates a Home Panel.
     */
    public HomePanel() {
        super(PanelType.HOME);
    }

    /**
     * Set the player that owns this panel.
     * @param player the player that starts in this panel.
     */
    public void setPlayerOwner(Player player) {
        this.playerOwner = player;
    }

    /**
     * Return this panel owner.
     * @return a Player.
     */
    public Player getPlaterOwner() {
        return this.playerOwner;
    }

    /**
     * Home panel version of activatedBy: increase HP by one and does the normaCheck.
     * @param player
     */
    @Override
    public void activatedBy(Player player) {
        player.setCurrentHP(player.getCurrentHP() + 1);
        normaCheck(player);
    }

    /**
     * Executes the norma check event.
     * IT'S NOT COMPLETED
     * @param player the player that reaches the panel.
     */
    private void normaCheck(Player player) {
        int stars = player.getStars();
    }

}
