package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.panelFactory.*;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

import java.util.ArrayList;
import java.util.Hashtable;

public class BoardController implements IBoardController, IBoardObserver{

    private IPanelFactory bonusPanelFactory = new BonusPanelFactory();
    private IPanelFactory bossPanelFactory = new BossPanelFactory();
    private IPanelFactory drawPanelFactory = new DrawPanelFactory();
    private IPanelFactory dropPanelFactory = new DropPanelFactory();
    private IPanelFactory encounterPanelFactory = new EncounterPanelFactory();
    private IPanelFactory homePanelFactory = new HomePanelFactory();
    private IPanelFactory neutralPanelFactory = new NeutralPanelFactory();

    private Hashtable<Integer, IPanel> board;

    private int maxKey;

    public BoardController() {
        this.board = new Hashtable<>();
        this.maxKey = 0;
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
    public IPanel createHomePanel(int key) {
        IPanel panel = homePanelFactory.createWithKey(key);
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public IPanel createBonusPanel(int key) {
        IPanel panel = bonusPanelFactory.createWithKey(key);
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
    }
    /**
     * Creates the panel with a key and returns it.
     * @param key Int
     */
    @Override
    public IPanel createBossPanel(int key) {
        IPanel panel = bossPanelFactory.createWithKey(key);
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public IPanel createDrawPanel(int key) {
        IPanel panel = drawPanelFactory.createWithKey(key);
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public IPanel createDropPanel(int key) {
        IPanel panel = dropPanelFactory.createWithKey(key);
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public IPanel createEncounterPanel(int key) {
        IPanel panel = encounterPanelFactory.createWithKey(key);
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
    }
    /**
     * Creates the panel with a key.
     * @param key Int
     */
    @Override
    public IPanel createNeutralPanel(int key) {
        IPanel panel = neutralPanelFactory.createWithKey(key);
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
    }
    /**
     * Adds a panel to the game with out specifying the key.
     * @param panel IPanel to add.
     * @return IPanel.
     */
    @Override
    public IPanel addPanel(IPanel panel) {
        // Get a new key.
        int key = this.getMaxKey() + 1;
        this.board.put(key, panel);
        panel.attach(this);
        return panel;
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

    /**
     * Assigns next panel with the panels keys.
     * key --> keys[0], ..., key --> keys[n]
     *
     * @param key key of the a panel.
     * @param keys keys of the future next panels of the previous panel.
     */
    @Override
    public void assignNextPanelsWithKey(int key, int ...keys) {
        IPanel[] panels = new IPanel[keys.length];
        for (int i = 0; i < keys.length ; i++) {
            panels[i] = this.getPanelWithKey(keys[i]);
        }
        this.assignNextPanels(this.getPanelWithKey(key), panels);
    }

    /**
     * Returns the max key.
     *
     * @return Int.
     */
    public int getMaxKey() {
        int maxKey = (int) this.board.keySet().toArray()[0];
        for (int key : this.board.keySet()) {
            if (key >= maxKey) {maxKey = key;}
        }
        return maxKey;
    }

    /**
     * Puts the player on the panel board[key].
     *
     * @param player IPlayer.
     * @param key Int, key of the IPanel where player will be located.
     */
    @Override
    public void movePlayerTo(IPlayer player, int key) {
        // Delete player from previous panel.
        player.getCurrentPanel().removePlayer(player);
        // Set the new current panel of the player,
        player.setCurrentPanel(this.board.get(key));
        // Put the player on its new panel.
        this.board.get(key).addPlayer(player);
    }

    public void movePlayer(IPlayer player, int steps) {

        if (steps == 0) {
            player.getCurrentPanel().activatedBy(player);
            return;
        }

        int key = player.getNextPanelDecision().getKey();
        this.movePlayerTo(player, key);
        this.movePlayer(player, steps - 1);
    }

    /**
     * Updates the game state in order of a panel notification.
     */
    @Override
    public void updateStopPlayer(IPlayer player) {
        player.waitOnPanel();
    }
}
