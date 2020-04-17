package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

/**
 * Class that represents a HomePanel.
 */
public class HomePanel extends Panel {
    private Player playerOwner;

    /**
     * Creates a Home Panel and adds the playerOwner to the panel set of players.
     * @param playerOwner: the player that starts in this panel.
     */
    public HomePanel(Player playerOwner) {
        super(PanelType.HOME);
        this.playerOwner = playerOwner;
        this.addPlayer(playerOwner);
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
     *
     * @param player
     */
    private void normaCheck(Player player){
        
    }

}
