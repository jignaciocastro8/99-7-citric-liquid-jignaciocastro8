package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

public interface IBoardObserver {
    /**
     * Updates the game state in order of a panel data.
     */
    void updateStopPlayer(IPlayer player);

    /**
     * Update meaning that a battle might start.
     * @param player IPlayer, the player to ask.
     * @param enemy IPlayer, the enemy.
     */
    void playersMeetUpdate(IPlayer player, IPlayer enemy);

    /**
     * Update meaning that the panel has more than one next panel.
     * @param player IPlayer.
     */
    void multipleNextPanelsUpdate(IPlayer player);
}
