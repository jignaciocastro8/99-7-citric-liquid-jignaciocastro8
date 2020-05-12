package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;

import java.util.Set;

public interface PanelInterface {
    PanelType getType();
    Set<Panel> getNextPanels();
    void addNextPanel(final Panel panel);
    void addPlayer(Player player);
    void activatedBy(final Player player);
}

