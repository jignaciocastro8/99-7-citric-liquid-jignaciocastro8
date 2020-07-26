package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricliquid.controller.GameController;

public abstract class TurnState implements ITurnState {

    protected boolean tryToContinueFlag;
    protected GameController controller;
    protected String stateName;

    public TurnState(String name) {
        this.stateName = name;
        this.tryToContinueFlag = false;
    }

    /**
     * Setter of the try to continue flag.
     *
     * @param flag boolean.
     */
    @Override
    public void setTryToContinue(boolean flag) {
        this.tryToContinueFlag = flag;
    }



    @Override
    public String getName() {
        return this.stateName;
    }

    /**
     * Setter of the controller (context) of the state.
     *
     * @param gameController GameController.
     */
    @Override
    public void setController(GameController gameController) {
        this.controller = gameController;
    }

    /**
     * Tells if it is possible to continue with the game flux.
     *
     * @return boolean.
     */
    @Override
    public boolean tryToContinue() {
        return tryToContinueFlag;
    }
}
