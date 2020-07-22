package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.controller.IBoardObserver;
import com.github.cc3002.citricliquid.controller.IPlayerObserver;

import java.util.ArrayList;
import java.util.HashSet;

public class NullPanel implements IPanel {
    /**
     * Getter of the panel's key.
     *
     * @return Int.
     */
    @Override
    public int getKey() {
        return 0;
    }

    /**
     * Getter of the panel's type.
     *
     * @return PanelType.
     */
    @Override
    public PanelType getType() {
        return null;
    }

    /**
     * Getter of the panel's next panels.
     *
     * @return ArrayList with the panels.
     */
    @Override
    public ArrayList<IPanel> getNextPanels() {
        return null;
    }

    /**
     * Adds next panels.
     *
     * @param panels IPanel[].
     */
    @Override
    public void addNextPanel(IPanel... panels) {

    }

    /**
     * Add a player to the panel.
     *
     * @param player IPlayer.
     */
    @Override
    public void addPlayer(IPlayer player) {

    }

    /**
     * Activate the panel.
     *
     * @param player IPlayer.
     */
    @Override
    public void activatedBy(IPlayer player) {

    }

    /**
     * Getter o the players in the panel.
     *
     * @return ArrayList with the players.
     */
    @Override
    public ArrayList<IPlayer> getPlayers() {
        return new ArrayList<>();
    }

    /**
     * Tells if player is on this panel.
     *
     * @param player IPlayer.
     * @return boolean.
     */
    @Override
    public boolean containsCharacter(IPlayer player) {
        return false;
    }

    /**
     * Removes the player of the panel.
     *
     * @param player IPlayer.
     */
    @Override
    public void removePlayer(IPlayer player) {

    }

    /**
     * Returns the number of next panels of this panel.
     *
     * @return int.
     */
    @Override
    public int numberOfNextPanels() {
        return 0;
    }

    /**
     * Getter of the number of players on the panel.
     *
     * @return Int.
     */
    @Override
    public int numberOfPLayers() {
        return 0;
    }

    /**
     * True if this is a home panel, false if not.
     *
     * @return boolean.
     */
    @Override
    public boolean isHomePanel() {
        return false;
    }

    /**
     * Attaches the panel to a player observer.
     *
     * @param observer IPlayerObserver.
     */
    @Override
    public void attach(IPlayerObserver observer) {

    }

    /**
     * Attaches the panel to an observer.
     *
     * @param observer
     */
    @Override
    public void attach(IBoardObserver observer) {

    }

    /**
     * Notifies the observer that the player must stop because of the panel information.
     *
     * @param player IPlayer, the player that enters the panel.
     */
    @Override
    public void notifyStopPlayer(IPlayer player) {

    }

    /**
     * Notifies the observer that the turn is over.
     */
    @Override
    public void notifyTurnIsOver(IPlayer player) {

    }


}
