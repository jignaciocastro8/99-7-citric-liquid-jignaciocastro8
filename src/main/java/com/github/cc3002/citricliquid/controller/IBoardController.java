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
     * Creates the panel with a key and returns it.
     * @param key Int
     */
    IPanel createHomePanel(int key);
    /**
     * Creates the panel with a key ans returns it.
     * @param key Int
     */
    IPanel createBonusPanel(int key);
    /**
     * Creates the panel with a key and returns it.
     * @param key Int
     */
    IPanel createBossPanel(int key);
    /**
     * Creates the panel with a key and returns it.
     * @param key Int
     */
    IPanel createDrawPanel(int key);
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    IPanel createDropPanel(int key);
    /**
     * Creates the panel with a key and returns it.
     * @param key Int
     */
    IPanel createEncounterPanel(int key);
    /**
     * Creates the panel with a key and returns it.
     * @param key Int
     */
    IPanel createNeutralPanel(int key);

    /**
     * Adds a panel to the game with out specifying the key.
     * @param panel IPanel to add.
     * @return IPanel.
     */
    IPanel addPanel(IPanel panel);

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

    /**
     * Assigns next panel with the panels keys.
     * key --> keys[0], ..., key --> keys[n]
     * @param key key of the a panel.
     * @param keys keys of the future next panels of the previous panel.
     */
    void assignNextPanelsWithKey(int key, int ...keys);

}
