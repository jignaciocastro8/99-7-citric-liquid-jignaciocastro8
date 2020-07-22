package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.IPlayerFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class PlayerController implements IPlayerController, IPlayerObserver {

    private ArrayList<IPlayer> players;

    private IPlayerFactory playerFactory;

    private IPlayer winner;
    private boolean winnerFlag;

    private int chapter = 1;
    private int numberOfFinishedTurns;

    private ArrayList<IPlayer> turnOrder;
    private IPlayer turnOwner;
    private long seed;



    public PlayerController() {
        players = new ArrayList<>();
        playerFactory = new PlayerFactory();
        this.turnOrder = new ArrayList<>();
    }
    /**
     * Create a player.
     * @param name Character's name.
     * @param hp Character's hp.
     * @param atk Character's atk.
     * @param def Character's def.
     * @param evd Character's evd.
     * @return ICharacter the player.
     */
    @Override
    public IPlayer createPlayer(String name, int hp, int atk, int def, int evd) {
        IPlayer player = playerFactory.create(name, hp, atk, def, evd);
        // Every player starts with STAR goal.
        player.setObjective(NormaGoal.STARS);
        // Add to the players.
        this.players.add(player);
        // Attach the controller (observer) to the created player.
        player.attach(this);
        // Checks if this player is the only one.
        if (this.players.size() == 1) {
            this.turnOwner = player;
        }
        this.turnOrder.add(player);

        return player;
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
        IPlayer player = this.createPlayer(name, hp, atk, def, evd);
        // Set the current panel of the player.
        player.setCurrentPanel(panel);
        // Add the player to the panel's players.
        panel.addPlayer(player);
        return player;
    }

    /**
     * Fast method to create suguri.
     */
    @Override
    public IPlayer createSuguri() {
        return this.createPlayer("Suguri", 4, 1, -1, 2);
    }

    /**
     * Fast method to create marc.
     */
    @Override
    public IPlayer createMarc() {
        return this.createPlayer("Marc", 4, 1, 1, -1);
    }

    /**
     * Fast method to create kai.
     *
     * @return IPlayer
     */
    @Override
    public IPlayer createKai() {
        return this.createPlayer("Kai", 5, 1, 0, 0);
    }

    /**
     * Fast method to create peat.
     *
     * @return IPlayer.
     */
    @Override
    public IPlayer createPeat() {
        return this.createPlayer("Peat", 3, 1, 1, 1);
    }

    /**
     * Getter of the player of the game.
     *
     * @return IPlayer[]
     */
    @Override
    public ArrayList<IPlayer> getPlayers() {
        return new ArrayList<>(this.players);
    }

    /**
     * Checks if some player has norma 6.
     *
     * @return boolean
     */
    @Override
    public boolean checkForWinner() {
        return this.winnerFlag;
    }

    /**
     * Setter of the objective od the player.
     *
     * @param player    IPlayer.
     * @param objective NormaGoal type.
     */
    @Override
    public void setPLayerObjective(IPlayer player, NormaGoal objective) {
        player.setObjective(objective);
    }

    /**
     * Updates the observer winner data.
     *
     * @param player IPlayer.
     */
    @Override
    public void updateWinner(IPlayer player) {
        this.winner = player;
        this.winnerFlag = true;
    }

    /**
     * Update the observer that the current turn is over.
     */
    @Override
    public void updateTurnIsOver(IPlayer player) {
        this.nextTurn();
        player.neutralState();
    }

    /**
     * Getter of the game chapter.
     *
     * @return int.
     */
    @Override
    public int getChapter() {
        return this.chapter;
    }

    /**
     * Initiate the game.
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
            this.initiatePlayerState();
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
     * Initiates the players state.
     */
    public void initiatePlayerState() {
        for (IPlayer player : this.players) {
            player.neutralState();
        }
    }

    /**
     * Getter of the current winner.
     * @return IPlayer.
     */
    public IPlayer getWinner() {
        return this.winner;
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
     * Method that throws an exception if player is not on the game.
     *
     * @param player IPlayer.
     */
    public void isOnTheGame(IPlayer player) throws NoSuchPlayerOnTheGameException {
        if (!this.players.contains(player)) {
            throw new NoSuchPlayerOnTheGameException("There's not such player in the game");
        }
    }

    /**"
     * Shuffles the players array.
     */
    private void createTurnsOrder() {
        Random random = new Random(this.seed);
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
     * Setter of the seed
     * @param seed long
     */
    public void setSeed(int seed) {
        this.seed = seed;
    }

    /**
     * Getter of the player's info.
     * @return StringBuilder.
     */
    public StringBuilder getPlayersInfo() {
        StringBuilder sb = new StringBuilder("Player's information: \n");
        for (IPlayer player : this.players) {
            sb.append(player.getName()).append(": ").append("\n").append(player.getInfo()).append(", location: ").
                    append(player.getCurrentPanel().getKey()).append("\n");
        }
        return sb;
    }

    /**
     * Getter of game info.
     * @return StringBuilder
     */
    public StringBuilder getGameInfo() {
        StringBuilder sb = new StringBuilder("Game information: \n");
        sb.append("Turn owner: ").append(turnOwner.getName()).append("\n");
        StringBuilder turnOrderSb = new StringBuilder();
        for (int i = 0; i < turnOrder.size(); i++) {
            turnOrderSb.append(i + 1).append(": ").append(turnOrder.get(i).getName()).append(", ");
        }
        sb.append("Turn order: ").append(turnOrderSb.toString()).append("\n");
        sb.append("Chapter: ").append(chapter);
        return sb;
    }


    public static class NoSuchPlayerOnTheGameException extends Exception {
        public NoSuchPlayerOnTheGameException(String message) {
            super(message);
        }
    }
}
