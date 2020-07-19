package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

public interface IPlayerObserver {
    /**
     * Updates the observer winner data.
     */
    void updateWinner(IPlayer player);

    /**
     * Update the observer that the current turn is over and player must be in neutral state.
     */
    void updateTurnIsOver(IPlayer player);

}
