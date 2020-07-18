package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

public interface IBoardObserver {
    /**
     * Updates the game state in order of a panel data.
     */
    void updateStopPlayer(IPlayer player);
}
