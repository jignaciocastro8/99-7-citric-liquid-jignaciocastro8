package com.github.cc3002.citricliquid.gameFlux;



public class StopOrNotOnHomePanelState extends TurnState implements ITurnState {

    public StopOrNotOnHomePanelState() {
        super("Stop on home panel?");
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
        return true;
    }

    /**
     * Handles the state action.
     */
    @Override
    public void handle() {

    }

    /**
     * Setter of the answer to the question: stop on home panel?.
     * @param answer boolean.
     */
    public void setAnswer(boolean answer) {
        super.tryToContinueFlag = answer;
    }
}
