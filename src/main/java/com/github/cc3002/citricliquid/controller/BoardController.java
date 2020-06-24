package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.*;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

import java.util.ArrayList;
import java.util.Hashtable;

public class BoardController implements IBoardController {

    private IPanelFactory bonusPanelFactory = new BonusPanelFactory();
    private IPanelFactory bossPanelFactory = new BossPanelFactory();
    private IPanelFactory drawPanelFactory = new DrawPanelFactory();
    private IPanelFactory dropPanelFactory = new DropPanelFactory();
    private IPanelFactory encounterPanelFactory = new EncounterPanelFactory();
    private IPanelFactory homePanelFactory = new HomePanelFactory();
    private IPanelFactory neutralPanelFactory = new NeutralPanelFactory();

    private Hashtable<Integer, IPanel> board;

    public BoardController() {
        this.board = new Hashtable<>();
    }
    /**
     * Assigns next panel
     * @param panel IPanel.
     * @param panels IPanel.
     */
    @Override
    public void assignNextPanels(IPanel panel, IPanel... panels) {
        panel.addNextPanel(panels);
    }

    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public void createHomePanel(int key) {
        this.board.put(key, homePanelFactory.createWithKey(key));
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public void createBonusPanel(int key) {
        this.board.put(key, bonusPanelFactory.createWithKey(key));
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public void createBossPanel(int key) {
        this.board.put(key, bossPanelFactory.createWithKey(key));
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public void createDrawPanel(int key) {
        this.board.put(key, drawPanelFactory.createWithKey(key));
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public void createDropPanel(int key) {
        this.board.put(key, dropPanelFactory.createWithKey(key));

    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public void createEncounterPanel(int key) {
        this.board.put(key, encounterPanelFactory.createWithKey(key));
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public void createNeutralPanel(int key) {
        this.board.put(key, neutralPanelFactory.createWithKey(key));
    }

    /**
     * Getter of all the panels.
     *
     * @return ArrayList with the panels.
     */
    @Override
    public ArrayList<IPanel> getAllPanels() {
        return new ArrayList<IPanel>(this.board.values());
    }



    /**
     * Getter of panel with key.
     *
     * @param key Int.
     * @return IPanel.
     */
    @Override
    public IPanel getPanelWithKey(int key) {
        return this.board.get(key);
    }
}
