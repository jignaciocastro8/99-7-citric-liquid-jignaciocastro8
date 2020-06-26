package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

public class BattleOrNotState implements IWaitTurnState {

    IPlayer playerToAsk;
    IPlayer enemy;

    /**
     * This class represents the waiting for a battle answer state.
     * @param player IPlayer, player to be ask.
     * @param enemy IPlayer, the enemy.
     */
    public BattleOrNotState(IPlayer player, IPlayer enemy) {
        this.playerToAsk = player;
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
}
