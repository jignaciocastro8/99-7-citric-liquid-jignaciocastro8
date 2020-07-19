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
     * Notifies the observer that the player must stop because of the panel information.
     *
     * @param player IPlayer, the player that enters the panel.
     */
    void notifyStopPlayer(IPlayer player);

    /**
     * Notifies the observer that the turn is over.
     * @param player IPlayer that ends his/her turn.
     */
    void notifyTurnIsOver(IPlayer player);

}
