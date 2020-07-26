package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

/**
 * Null observer implementation. The only goal of this class is make the test related
 * to the model objects pass.
 */
public class NullObserver implements IBoardObserver, IPlayerObserver {
    /**
     * Updates the game state in order of a panel data.
     *
     * @param player
     */
    @Override
    public void updateStopPlayer(IPlayer player) {

    }

    /**
     * Update meaning that a battle might start.
     *
     * @param player IPlayer, the player to ask.
     * @param enemy  IPlayer, the enemy.
     */
    @Override
    public void playersMeetUpdate(IPlayer player, IPlayer enemy) {

    }

    /**
     * Update meaning that the panel has more than one next panel.
     *
     * @param player IPlayer.
     */
    @Override
    public void multipleNextPanelsUpdate(IPlayer player) {

    }

    /**
     * Updates the observer winner data.
     *
     * @param player
     */
    @Override
    public void updateWinner(IPlayer player) {

    }

    /**
     * Update the observer that the current turn is over and player must be in neutral state.
     *
     * @param player
     */
    @Override
    public void updateTurnIsOver(IPlayer player) {

    }

    /**
     * Update meaning that the player is on his/hers home panel.
     *
     * @param player IPlayer.
     */
    @Override
    public void playerOnHomePanelUpdate(IPlayer player) {

    }


}
