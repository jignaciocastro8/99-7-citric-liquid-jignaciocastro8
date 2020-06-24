package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import java.util.ArrayList;

public interface IBoardController {
    /**
     * Assigns next panel
     * @param panel IPanel.
     * @param panels IPanel.
     */
    void assignNextPanels(IPanel panel, IPanel ...panels);

    /**
     * Creates the panel with a key.
     * @param key Int
     */
    void createHomePanel(int key);
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    void createBonusPanel(int key);
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    void createBossPanel(int key);
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    void createDrawPanel(int key);
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    void createDropPanel(int key);
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    void createEncounterPanel(int key);
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    void createNeutralPanel(int key);

    /**
     * Getter of all the panels.
     * @return ArrayList with the panels.
     */
    ArrayList<IPanel> getAllPanels();



    /**
     * Getter of panel with key.
     * @param key Int.
     * @return IPanel.
     */
    IPanel getPanelWithKey(int key);
}
