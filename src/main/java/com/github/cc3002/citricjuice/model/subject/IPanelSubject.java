package com.github.cc3002.citricjuice.model.subject;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.controller.IBoardObserver;
import com.github.cc3002.citricliquid.controller.IPlayerObserver;
import com.github.cc3002.citricliquid.controller.PlayerController;

public interface IPanelSubject {
    /**
     * Attaches the panel to a player observer.
     * @param observer IPlayerObserver.
     */
    void attach(IPlayerObserver observer);
    /**
     * Attaches the panel to a board observer.
     * * @param observer IBoardObserver.
     */
    void attach(IBoardObserver observer);

    /**
     * Notifies that a player meets another player on this panel.
     *
     * @param player IPlayer, the player that enters the panel.
     * @param enemy IPlayer, the enemy.
     */
    void notifyPlayersMeet(IPlayer player, IPlayer enemy);

    /**
     * Notifies the observer that the turn is over.
     * @param player IPlayer that ends his/her turn.
     */
    void notifyTurnIsOver(IPlayer player);

    /**
     * Notifies that the player is on his/hers home panel.
     * @param player IPlayer.
     */
    void notifyPlayerOnHomePanel(IPlayer player);

    /**
     * Notifies that this panel has more than one next panel.
     * @param player IPlayer.
     */
    void notifyMultipleNextPanels(IPlayer player);

}
