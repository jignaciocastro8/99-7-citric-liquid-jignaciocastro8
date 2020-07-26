package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricliquid.controller.GameController;

public class NeutralState extends StartTurnState implements ITurnState {
    /**
     * Ask the player. For now it does nothing.
     */
    @Override
    public void ask() {

    }

    /**
     * Tells if the state is waiting or not.
     *
     * @return boolean.
     */
    @Override
    public boolean isWaiting() {
        return false;
    }

    /**
     * Handles the state action.
     */
    @Override
    public void handle() {

    }

    /**
     * Setter of the controller (context) of the state.
     *
     * @param gameController GameController.
     */
    @Override
    public void setController(GameController gameController) {

    }
}
