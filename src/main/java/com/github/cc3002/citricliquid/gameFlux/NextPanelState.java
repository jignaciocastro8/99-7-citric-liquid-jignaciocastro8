package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

import java.util.ArrayList;

public class NextPanelState implements IWaitTurnState {

    private IPlayer player;

    private ArrayList<IPanel> nextPanels;

    public NextPanelState(IPlayer player, ArrayList<IPanel> nextPanels) {
        this.nextPanels = nextPanels;
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
}
