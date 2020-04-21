package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.characters.Player;

import java.util.Set;

public interface PanelInterface {
    public PanelType getType();
    public Set<Panel> getNextPanels();
    public void addNextPanel(final Panel panel);
    public void addPlayer(Player player);
    public abstract void activatedBy(final Player player);
}
