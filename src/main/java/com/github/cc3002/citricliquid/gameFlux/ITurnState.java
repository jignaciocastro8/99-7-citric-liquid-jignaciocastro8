package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricliquid.controller.GameController;

public interface ITurnState {
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

    /**
     * Setter of the controller (context) of the state.
     * @param gameController GameController.
     */
    void setController(GameController gameController);

    /**
     * Getter of the state name.
     * @return String.
     */
    String getName();

    /**
     * Tells if it is possible to continue with the game flux.
     * @return boolean.
     */
    boolean tryToContinue();

    /**
     * Setter of the try to continue flag.
     * @param flag boolean.
     */
    void setTryToContinue(boolean flag);
}
