package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.model.NormaGoal;


import java.util.ArrayList;
import java.util.Random;

public class GameController implements IBoardController, IPlayerController, IUnitController, IGameController {

    private IUnitController unitController;
    private IPlayerController playerController;
    private IBoardController boardController;

    private int chapter;
    private int numberOfFinishedTurns;

    private ArrayList<IPlayer> turnOrder;
    private IPlayer turnOwner;

    private int seed;

    /**
     * Creates a GameController.
     */
    public GameController(){
        unitController = new UnitController();
        playerController = new PlayerController();
        boardController = new BoardController();

    }
    /**
     * Create a player.
     * @param name Character's name.
     * @param hp Character's hp.
     * @param atk Character's atk.
     * @param def Character's def.
     * @param evd Character's evd.
     */
    public void createPlayer(String name, int hp, int atk, int def, int evd) {
        this.playerController.createPlayer(name, hp, atk, def, evd);
    }

    /**
     * Create a wild unit.
     *
     * @param name Character's name.
     * @param hp   Character's hp.
     * @param atk  Character's atk.
     * @param def  Character's def.
     * @param evd  Character's evd.
     */
    @Override
    public void createWild(String name, int hp, int atk, int def, int evd) {
        this.unitController.createWild(name, hp, atk, def, evd);
    }

    /**
     * Create a boss unit.
     *
     * @param name Character's name.
     * @param hp   Character's hp.
     * @param atk  Character's atk.
     * @param def  Character's def.
     * @param evd  Character's evd.
     */
    @Override
    public void createBoss(String name, int hp, int atk, int def, int evd) {
        this.unitController.createBoss(name, hp, atk, def, evd);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public void createHomePanel(int key) {
        this.boardController.createHomePanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public void createBonusPanel(int key) {
        this.boardController.createBonusPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public void createBossPanel(int key) {
        this.boardController.createBossPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public void createDrawPanel(int key) {
        this.boardController.createDrawPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public void createDropPanel(int key) {
        this.boardController.createDropPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public void createEncounterPanel(int key) {
        this.boardController.createEncounterPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public void createNeutralPanel(int key) {
        this.boardController.createNeutralPanel(key);
    }

    /**
     * Getter of all the panels of the board.
     *
     * @return ArrayList with the panels.
     */
    @Override
    public ArrayList<IPanel> getAllPanels() {
        return this.boardController.getAllPanels();
    }

    /**
     * Getter of the player list.
     *
     * @return ArrayList with all the player of the game.
     */
    @Override
    public ArrayList<IPlayer> getPlayers() {
        return this.playerController.getPlayers();
    }

    /**
     * Checks if some player has norma 6.
     *
     * @return boolean
     */
    @Override
    public boolean checkForWinner() {
        return this.playerController.checkForWinner();
    }

    /**
     * Setter of the objective od the player.
     *
     * @param player    IPlayer.
     * @param objective NormaGoal type.
     */
    @Override
    public void setPLayerObjective(IPlayer player, NormaGoal objective) {
        this.playerController.setPLayerObjective(player, objective);
    }

    /**
     * Getter of the units list.
     *
     * @return ArrayList with all the units of the game.
     */
    @Override
    public ArrayList<ICharacter> getUnits() {
        return this.unitController.getUnits();
    }


    /**
     * Getter of the panel with key.
     *
     * @param key Int.
     * @return IPanel with key in the board.
     */
    @Override
    public IPanel getPanelWithKey(int key) {
        return this.boardController.getPanelWithKey(key);
    }



    /**
     * Assigns next panels.
     *
     * @param panel IPanel.
     * @param panelsToAssign IPanel[] to assign.
     */
    @Override
    public void assignNextPanels(IPanel panel, IPanel... panelsToAssign) {
        this.boardController.assignNextPanels(panel, panelsToAssign);
    }


    /**
     * Puts player on panel activating the panel effect.
     *
     * @param player IPlayer.
     * @param key Int, key of the IPanel where player will be located.
     */
    @Override
    public void movePlayerTo(IPlayer player, int key) {
        player.getCurrentPanel().removePlayer(player);
        player.setCurrentPanel(this.getPanelWithKey(key));
        this.getPanelWithKey(key).addPlayer(player);
        // Produces the effect of the panel.
        this.getPanelWithKey(key).activatedBy(player);
    }

    /**
     * Sets home panel of the player.
     *
     * @param player IPlayer.
     * @param panel HomePanel.
     */
    @Override
    public void setHomePanel(IPlayer player, HomePanel panel) {
        player.setHomePanel(panel);
        panel.setPlayerOwner(player);
    }

    /**
     * Getter of the chapter.
     *
     * @return Int.
     */
    @Override
    public int getChapter() {
        return this.chapter;
    }


    /**
     * Initiates the turn system. It requires a minimum of two players.
     */
    @Override
    public void initiateTurns() throws Exception {
        this.chapter = 1;
        this.numberOfFinishedTurns = 0;
        if (this.getPlayers().size() == 0 ) {
            throw new Exception("You need at least one player to initiate");
        }
        createTurnsOrder();
        this.turnOwner = turnOrder.get(0);
    }

    /**
     * Getter of the turn owner.
     *
     * @return IPlayer.
     */
    @Override
    public IPlayer getTurnOwner() {
        return this.turnOwner;
    }

    /**
     * Changes the turn owner to the next one.
     */
    @Override
    public void nextTurn() {
        numberOfFinishedTurns++;
        int len = this.getPlayers().size();
        this.turnOwner = this.turnOrder.get(numberOfFinishedTurns % len);
        this.chapter = (numberOfFinishedTurns / len) + 1;
    }

    /**
     * Shuffles the players array.
     */
    private void createTurnsOrder() {
        Random random = new Random(seed);
        ArrayList<IPlayer> arrayList = new ArrayList<>(this.getPlayers());
        ArrayList<IPlayer> newArrayList = new ArrayList<>();
        final int len = arrayList.size();
        for (int i = 0; i<len; i++) {
            int ind = random.nextInt(arrayList.size());
            newArrayList.add(arrayList.get(ind));
            arrayList.remove(ind);
        }
        this.turnOrder = newArrayList;
    }

    /**
     * Setter of the seed for random testing.
     * @param seed Int.
     */
    public void setSeed(int seed) {
        this.seed = seed;
    }
}