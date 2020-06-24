package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

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
     * @return HashSet with the panels.
     */
    @Override
    public HashSet<IPanel> getNextPanels() {
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
     * @return HashSet with the players.
     */
    @Override
    public HashSet<IPlayer> getPlayers() {
        return new HashSet<>();
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
}
