package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;

import java.util.Set;

public interface IPanel {
    int getKey();
    PanelType getType();
    Set<IPanel> getNextPanels();
    void addNextPanel(final IPanel panel);
    void addPlayer(Player player);
    void activatedBy(final Player player);
    Set<Player> getPlayers();
}

