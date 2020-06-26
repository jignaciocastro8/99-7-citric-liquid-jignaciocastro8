package com.github.cc3002.citricliquid.gameFlux;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

import java.util.ArrayList;

public interface ITurn {
    /**
     * Starts the turn of the turn owner.
     * @param turnOwner IPlayer.
     * @param chapter Int.
     */
    void initiateTurn(IPlayer turnOwner, int chapter);

    /**
     * Aks the player if he/she wants to play a card.
     * @param player IPlayer, the player to be ask.
     * @return boolean.
     */
    boolean askForPlayCard(IPlayer player);

    /**
     * Ask the player if she/he wants to battle.
     * @param player The player to be ask.
     * @param enemy The enemy.
     * @return The players answer to the question: Do you want to battle enemy?.
     */
    boolean askForBattle(IPlayer player, IPlayer enemy);

    /**
     * Tells if the turn state is waiting or not.
     * @return boolean.
     */
    boolean isWaiting();

    /**
     * Ask the player if she/he wants to evade (true) or defend (false)
     * @param player IPlayer, player to be ask.
     * @return boolean, player answer.
     */
    boolean askEvdOrDef(IPlayer player);

    /**
     *  Ask for a next panel decision.
     * @param player IPlayer.
     * @param nextPanels ArrayList<IPanel>.
     */
    IPanel askForNextPanel(IPlayer player, ArrayList<IPanel> nextPanels);
}
