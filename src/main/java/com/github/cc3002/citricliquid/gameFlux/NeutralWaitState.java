package com.github.cc3002.citricliquid.gameFlux;

public class NeutralWaitState implements IWaitTurnState {
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
}
