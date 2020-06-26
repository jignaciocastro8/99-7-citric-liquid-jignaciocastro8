package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import com.github.cc3002.citricliquid.model.NormaGoal;

/**
 * Class that represents a HomePanel.
 */
public class HomePanel extends Panel {
    private IPlayer playerOwner;

    /**
     * Creates a Home Panel.
     */
    public HomePanel(int key) {
        super(PanelType.HOME, key);
    }

    /**
     * Set the player that owns this panel.
     * @param player the player that starts in this panel.
     */
    public void setPlayerOwner(IPlayer player) {
        this.playerOwner = player;
    }

    /**
     * Return this panel owner.
     * @return a IPlayer.
     */
    public IPlayer getPlayerOwner() {
        return this.playerOwner;
    }

    /**
     * Home panel version of activatedBy: increase HP by one and does the normaCheck.
     * @param player: a Player.
     */
    @Override
    public void activatedBy(IPlayer player) {
        player.setCurrentHP(player.getCurrentHP() + 1);
        normaCheck(player);
    }

    /**
     * Executes the norma check event.
     * @param player the player that reaches the panel.
     */
    private void normaCheck(IPlayer player) {

        int stars = player.getStars();
        int wins = player.getWins();
        if (player.getObjective() == NormaGoal.STARS) {
            // Every player starts with norma 1.
            int requisitos = 1;
            // Norma 2:
            if ( 10 <= stars ) {
                requisitos++;
            }
            // Norma 3:
            if ( 30 <= stars ) {
                requisitos++;
            }
            // Norma 4.
            if ( 70 <= stars ) {
                requisitos++;
            }
            // Norma 5.
            if ( 120 <= stars ) {
                requisitos++;
            }
            // Norma 6.
            if ( 200 <= stars ) {
                requisitos++;
            }
            int it = requisitos - player.getNormaLevel();
            // Increases norma by the correct amount.
            for (int i = 0; i < it; i++) {
                player.normaClear();
            }
        }
        else {
            // Every player starts with norma 1.
            int requisitos = 1;
            // Norma 2:
            if ( 0 <= wins ) {
                requisitos++;
            }
            // Norma 3:
            if ( 2 <= wins ) {
                requisitos++;
            }
            // Norma 4.
            if ( 5 <= wins ) {
                requisitos++;
            }
            // Norma 5.
            if ( 9 <= wins ) {
                requisitos++;
            }
            // Norma 6.
            if ( 14 <= wins ) {
                requisitos++;
            }
            int it = requisitos - player.getNormaLevel();
            // Increases norma by the correct amount.
            for (int i = 0; i < it; i++) {
                player.normaClear();
            }
        }

    }

}
