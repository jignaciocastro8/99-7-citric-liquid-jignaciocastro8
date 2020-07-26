package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.controller.GameController;

import java.util.ArrayList;

public class NextPanelState extends TurnState implements ITurnState {

    private IPlayer player;


    public NextPanelState(IPlayer player) {
        super("Choose next panel");
        this.player = player;
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
     * Setter of the controller (context) of the state.
     *
     * @param gameController GameController.
     */
    @Override
    public void setController(GameController gameController) {
        this.controller = gameController;
    }
}
