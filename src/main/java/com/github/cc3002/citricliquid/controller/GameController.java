package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.model.NormaGoal;


import java.util.ArrayList;
import java.util.Random;

public class GameController implements IBoardController, IPlayerController, IUnitController, IGameController {

    private UnitController unitController;
    private PlayerController playerController;
    private BoardController boardController;

    private int chapter = 1;
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
        // Initiate order array.
        this.turnOrder = new ArrayList<>();
    }
    /**
     * Create a player.
     * @param name Character's name.
     * @param hp Character's hp.
     * @param atk Character's atk.
     * @param def Character's def.
     * @param evd Character's evd.
     */
    public IPlayer createPlayer(String name, int hp, int atk, int def, int evd) {
        IPlayer newPlayer =  this.playerController.createPlayer(name, hp, atk, def, evd);
        if (this.getPlayers().size() == 1) {
            this.turnOwner = newPlayer;
        }
        this.turnOrder.add(newPlayer);
        return newPlayer;
    }

    /**
     * @param name  name.
     * @param hp    int.
     * @param atk   int.
     * @param def   int.
     * @param evd   int.
     * @param panel The panel where to put the created player.
     * @return IPlayer.
     */
    @Override
    public IPlayer createPlayerWithPanel(String name, int hp, int atk, int def, int evd, IPanel panel) {
        IPlayer player = this.playerController.createPlayerWithPanel(name, hp, atk, def, evd, panel);
        if (this.getPlayers().size() == 1) {
            this.turnOwner = player;
        }
        this.addPanel(panel);
        this.turnOrder.add(player);
        return player;
    }

    /**
     * Fast method to create suguri.
     */
    @Override
    public IPlayer createSuguri() {
        IPlayer player = this.playerController.createSuguri();
        if (this.getPlayers().size() == 1) {
            this.turnOwner = player;
        }
        this.turnOrder.add(player);
        return player;
    }

    /**
     * Fast method to create marc.
     */
    @Override
    public IPlayer createMarc() {
        IPlayer player = this.playerController.createMarc();
        if (this.getPlayers().size() == 1) {
            this.turnOwner = player;
        }
        this.turnOrder.add(player);
        return player;
    }

    /**
     * Create a wild unit.
     *  @param name Character's name.
     * @param hp   Character's hp.
     * @param atk  Character's atk.
     * @param def  Character's def.
     * @param evd  Character's evd.
     * @return ICharacter.
     */
    @Override
    public ICharacter createWild(String name, int hp, int atk, int def, int evd) {
        return this.unitController.createWild(name, hp, atk, def, evd);
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
    public ICharacter createBoss(String name, int hp, int atk, int def, int evd) {
        return this.unitController.createBoss(name, hp, atk, def, evd);
    }

    /**
     * Creates the panel with a key and returns it.
     *
     * @param key Int
     */
    @Override
    public IPanel createHomePanel(int key) {
        return this.boardController.createHomePanel(key);
    }

    /**
     * Creates the panel with a key and returns it.
     *
     * @param key Int
     */
    @Override
    public IPanel createBonusPanel(int key) {
        return this.boardController.createBonusPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createBossPanel(int key) {
        return this.boardController.createBossPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createDrawPanel(int key) {
        return this.boardController.createDrawPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createDropPanel(int key) {
        return this.boardController.createDropPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createEncounterPanel(int key) {
        return this.boardController.createEncounterPanel(key);
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createNeutralPanel(int key) {
        return this.boardController.createNeutralPanel(key);
    }

    /**
     * Adds a panel to the game with out specifying the key.
     *
     * @param panel IPanel to add.
     * @return IPanel.
     */
    @Override
    public IPanel addPanel(IPanel panel) {
        return this.boardController.addPanel(panel);
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
     * Assigns next panel with the panels keys.
     * key --> keys[0], ..., key --> keys[n]
     *
     * @param key  key of the a panel.
     * @param keys keys of the future next panels of the previous panel.
     */
    @Override
    public void assignNextPanelsWithKey(int key, int... keys) {
        this.boardController.assignNextPanelsWithKey(key, keys);
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
     * Puts the player on panel.
     *
     * @param player IPlayer.
     * @param key Int, key of the IPanel where player will be located.
     */
    @Override
    public void movePlayerTo(IPlayer player, int key) {
        // Delete player from previous panel.
        player.getCurrentPanel().removePlayer(player);
        player.setCurrentPanel(this.getPanelWithKey(key));
        this.getPanelWithKey(key).addPlayer(player);

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
    public void initiateGame() {
        // Start chapters.
        this.chapter = 1;
        // Start number of turns.
        this.numberOfFinishedTurns = 0;
        if (this.getPlayers().size() > 0 ) {
            // Create a random order for the turns.
            createTurnsOrder();
            // Initiate the states of the players.
            this.playerController.initiatePlayerState();
            // The first turn initiate.
            this.turnOwner = turnOrder.get(0);
        }

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
     * Makes the player move steps forward.
     *
     * @param player IPlayer, the player to move.
     * @param steps  Int, the amount of steps.
     */
    @Override
    public void movePlayer(IPlayer player, int steps) {
        // Waiting case.
        if (player.isWaitingOnPanel()) {
            // If the player is waiting, stops moving.
            return;
        }
        // Ends the walk case.
        if (steps == 0) {
            // Produce the effect of the panel on the player.
            player.getCurrentPanel().activatedBy(player);
            // The player ends the moving process.
            player.neutralState();
        }
        // Recursion.
        else{
            // The player starts moving process.
            player.moving();
            IPanel currentPanel = player.getCurrentPanel();
            // One next panel case.
            if (player.getCurrentPanel().numberOfNextPanels() == 1) {
                // Move player to the unique next panel.
                int nextPanelKey = currentPanel.getNextPanels().get(0).getKey();
                this.movePlayerTo(player, nextPanelKey);

                // If the next panel is its own home panel or has more than one player on it, the player must stay there waiting.
                if (player.getHomePanel() == currentPanel.getNextPanels().get(0) || player.getCurrentPanel().numberOfPLayers() > 1) {
                    player.waitOnPanel();
                }
                // Continuing the moving process.
                movePlayer(player, steps - 1);
            }
            // More than one next panel case.
            else {
                player.waitOnPanel();
                // Here the player must decide for one next panel to move to.
            }

        }
    }

    /**
     * Getter of the winner.
     *
     * @return IPlayer.
     */
    @Override
    public IPlayer getWinner() {
        return this.playerController.getWinner();
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