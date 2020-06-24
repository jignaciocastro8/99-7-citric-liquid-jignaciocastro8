package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;

import java.util.ArrayList;
import java.util.HashSet;

public interface IPanel {
    /**
     * Getter of the panel's key.
     * @return Int.
     */
    int getKey();

    /**
     * Getter of the panel's type.
     * @return PanelType.
     */
    PanelType getType();

    /**
     * Getter of the panel's next panels.
     * @return HashSet with the panels.
     */
    HashSet<IPanel> getNextPanels();

    /**
     * Adds next panels.
     * @param panels IPanel[].
     */
    void addNextPanel(final IPanel ...panels);

    /**
     * Add a player to the panel.
     * @param player IPlayer.
     */
    void addPlayer(IPlayer player);

    /**
     * Activate the panel.
     * @param player IPlayer.
     */
    void activatedBy(IPlayer player);

    /**
     * Getter o the players in the panel.
     * @return ArrayList with the players.
     */
    ArrayList<IPlayer> getPlayers();

    /**
     * Tells if player is on this panel.
     * @param player IPlayer.
     * @return boolean.
     */
    boolean containsCharacter(IPlayer player);

    /**
     * Removes the player of the panel.
     * @param player IPlayer.
     */
    void removePlayer(IPlayer player);
}

