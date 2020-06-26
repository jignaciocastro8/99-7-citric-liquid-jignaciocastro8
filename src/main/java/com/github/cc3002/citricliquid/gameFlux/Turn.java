package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

import java.util.ArrayList;

public class Turn implements ITurn {

    private IWaitTurnState state;

    public Turn() {
        this.state = new NeutralWaitState();
    }



    /**
     * Starts the turn of the turn owner.
     * @param turnOwner IPlayer.
     * @param chapter Int.
     */
    @Override
    public void initiateTurn(IPlayer turnOwner, int chapter) {
        // KO case.
        if (turnOwner.getCurrentHP() == 0) {
            turnOwner.recoveryState();
        }
        turnOwner.increaseStarsBy(Math.floorDiv(chapter, 5) + 1);
    }

    /**
     * Aks the player if he/she wants to play a card.
     * @param player IPlayer, the player to be ask.
     * @return boolean.
     */
    @Override
    public boolean askForPlayCard(IPlayer player) {
        return player.askForPlayCard();
    }

    /**
     * Ask the player if she/he wants to battle.
     * @param player The player to be ask.
     * @param enemy The enemy.
     * @return The players answer to the question: Do you want to battle enemy?.
     */
    @Override
    public boolean askForBattle(IPlayer player, IPlayer enemy) {
        // Here we wait for an answer, set the turn state.
        IWaitTurnState state = new BattleOrNotState(player, enemy);
        this.state = state;
        // This method ask the player. For now it does nothing.
        state.ask();
        return player.getBattleAnswer();
    }

    /**
     * Tells if the turn state is waiting or not.
     * @return boolean.
     */
    @Override
    public boolean isWaiting() {
        return this.state.isWaiting();
    }

    /**
     * Ask the player if she/he wants to evade (true) or defend (false)
     * @param player IPlayer, player to be ask.
     * @return boolean, player answer.
     */
    @Override
    public boolean askEvdOrDef(IPlayer player) {
        // Wait for an answer, set the turn state.
        IWaitTurnState state = new EvdOrDefState(player);
        this.state = state;
        // This method ask the player. For now it does nothing.
        state.ask();
        return player.getDefOrEvdAnswer();
    }

    /**
     *  Ask for a next panel decision.
     * @param player IPlayer.
     * @param nextPanels ArrayList<IPanel>.
     */
    @Override
    public IPanel askForNextPanel(IPlayer player, ArrayList<IPanel> nextPanels) {
        // Set the turn state to wait for a next panel decision.
        IWaitTurnState state = new NextPanelState(player, nextPanels);
        this.state = state;
        // This method ask the player. For now it does nothing.
        state.ask();
        return player.getNextPanelDecision();
    }
}
