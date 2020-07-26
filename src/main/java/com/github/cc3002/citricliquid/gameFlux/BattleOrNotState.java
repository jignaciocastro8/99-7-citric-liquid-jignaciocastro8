package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

public class BattleOrNotState extends TurnState implements ITurnState {

    private boolean answer;
    private IPlayer player;
    private IPlayer enemy;
    /**
     * This class represents the waiting for a battle answer state.
     */
    public BattleOrNotState(IPlayer player, IPlayer enemy) {
        super("Want to battle?");
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Ask the player.
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


}
