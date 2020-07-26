package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricliquid.controller.GameController;

public class StartTurnState extends TurnState implements ITurnState {


    public StartTurnState() {
        super("New Turn");
    }
    /**
     * Ask the player. For now it does nothing.
     * It should set the players battle answer field.
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
        controller.getTurnOwner().increaseStarsBy(Math.floorDiv(controller.getChapter(), 5) + 1);
        controller.moveTurnOwner();
    }


}
