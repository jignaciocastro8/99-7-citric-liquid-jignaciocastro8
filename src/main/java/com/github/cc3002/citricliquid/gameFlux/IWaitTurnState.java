package com.github.cc3002.citricliquid.gameFlux;

public interface IWaitTurnState {
    /**
     * Ask the player. For now it does nothing.
     * It should set the players battle answer field.
     */
    void ask();

    /**
     * Tells if the state is waiting or not.
     * @return boolean.
     */
    boolean isWaiting();

    /**
     * Handles the state action.
     */
    void handle();

}
