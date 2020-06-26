package com.github.cc3002.citricliquid.controller.gameFlux;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.controller.GameController;

public class GameFlux {

    public GameFlux() {

    }

    /**
     * Starts the turn of the turn owner.
     * @param turnOwner IPlayer.
     * @param chapter Int.
     */
    public void initiateTurn(IPlayer turnOwner, int chapter) {
        // KO case.
        if (turnOwner.getCurrentHP() == 0) {
            turnOwner.recoveryState();
        }
        turnOwner.increaseStarsBy(Math.floorDiv(chapter, 5) + 1);
    }

}
