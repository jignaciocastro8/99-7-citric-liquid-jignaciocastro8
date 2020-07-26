package com.github.cc3002.citricliquid.controller;
import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.gameFlux.ITurnState;
import com.github.cc3002.citricliquid.gameFlux.NeutralState;
import com.github.cc3002.citricliquid.gameFlux.NextPanelState;
import com.github.cc3002.citricliquid.model.NormaGoal;
import java.util.ArrayList;
import java.util.Random;

public class GameController implements IBoardController, IPlayerController, IUnitController, IGameController {

    private UnitController unitController;
    private PlayerController playerController;
    private BoardController boardController;

    // The state.
    ITurnState state = new NeutralState();

    /**
     * Creates a GameController.
     */
    public GameController(){
        unitController = new UnitController();
        playerController = new PlayerController();
        boardController = new BoardController();
        attach();

    }

    /**
     * Attach the central controller (this) to the particular controllers.
     * This allows the particular controllers to update the central controller state.
     */
    private void attach() {
        playerController.setCentralController(this);
        boardController.setCentralController(this);
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
        return this.playerController.createPlayer(name, hp, atk, def, evd);
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
        return this.playerController.createPlayerWithPanel(name, hp, atk, def, evd, panel);
    }

    /**
     * Fast method to create suguri.
     */
    @Override
    public IPlayer createSuguri() {
        return this.playerController.createSuguri();
    }

    /**
     * Fast method to create marc.
     */
    @Override
    public IPlayer createMarc() {
        return this.playerController.createMarc();
    }

    /**
     * Fast method to create kai.
     */
    @Override
    public IPlayer createKai() {
        return this.playerController.createKai();
    }

    /**
     * Fast method to create peat.
     */
    @Override
    public IPlayer createPeat() {
        return this.playerController.createPeat();
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
        IPanel panel = this.boardController.createHomePanel(key);
        panel.attach(this.playerController);
        return panel;
    }

    /**
     * Creates the panel with a key and returns it.
     *
     * @param key Int
     */
    @Override
    public IPanel createBonusPanel(int key) {
        IPanel panel = this.boardController.createBonusPanel(key);
        panel.attach(this.playerController);
        return panel;
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createBossPanel(int key) {
        IPanel panel = this.boardController.createBossPanel(key);
        panel.attach(this.playerController);
        return panel;
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createDrawPanel(int key) {
        IPanel panel = this.boardController.createDrawPanel(key);
        panel.attach(this.playerController);
        return panel;
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createDropPanel(int key) {
        IPanel panel = this.boardController.createDropPanel(key);
        panel.attach(this.playerController);
        return panel;
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createEncounterPanel(int key) {
        IPanel panel = this.boardController.createEncounterPanel(key);
        panel.attach(this.playerController);
        return panel;
    }

    /**
     * Creates the panel with a key.
     *
     * @param key Int
     */
    @Override
    public IPanel createNeutralPanel(int key) {
        IPanel panel = this.boardController.createNeutralPanel(key);
        panel.attach(this.playerController);
        return panel;
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
     * Updates the observer winner data.
     *
     * @param player IPlayer
     */
    @Override
    public void updateWinner(IPlayer player) {
        this.playerController.updateWinner(player);
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
        try {
            this.playerController.isOnTheGame(player);
            this.boardController.movePlayerTo(player, key);
        } catch (PlayerController.NoSuchPlayerOnTheGameException e) {
            e.printStackTrace();
        }
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
        return this.playerController.getChapter();
    }


    /**
     * Initiates the turn system. It requires a minimum of two players.
     */
    @Override
    public void initiateGame() throws PlayerController.NoPlayersException {
        this.playerController.initiateGame();
    }

    /**
     * Getter of the turn owner.
     *
     * @return IPlayer.
     */
    @Override
    public IPlayer getTurnOwner() {
        return this.playerController.getTurnOwner();
    }

    /**
     * Changes the turn owner to the next one.
     * The mediator class needs this.
     */
    @Override
    public void nextTurn() {
        playerController.nextTurn();
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

            // This line makes some test fail but it allows to "play".
            player.moving();
            return;
        }

        // Ends the walk case.
        if (steps == 0) {
            // Produce the effect of the panel on the player ending the turn. the panel ends the player motion.
            player.getCurrentPanel().activatedBy(player);
        }


        // Recursion.
        else {
            player.moving();
            IPanel currentPanel = player.getCurrentPanel();
            // One next panel case.
            if (currentPanel.numberOfNextPanels() == 1) {
                // Move player to the unique next panel.
                int nextPanelKey = currentPanel.getNextPanels().get(0).getKey();
                this.movePlayerTo(player, nextPanelKey);
                // Continuing the moving process.
                movePlayer(player, steps - 1);
            }
            // More than one next panel case.
            else {
                // Here the player must decide which next panel to move to.
                //this.state = new NextPanelState(player);
                // IPanel decision = player.askForPanel(player.currentPanel().nexPanels());
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
     * Returns the names of the players on the game.
     *
     * @return String[] list with names.
     */
    @Override
    public ArrayList<String> getPlayersName() {
        ArrayList<String> arr = new ArrayList<>();
        for (IPlayer player : this.getPlayers()) {
            arr.add(player.getName());
        }
        return arr;
    }

    /**
     * Returns a roll from the turn owner.
     *
     * @return int.
     */
    @Override
    public int rollTurnOwnerDice() {
        return this.playerController.getTurnOwner().roll();
    }

    /**
     * Getter of a string builder with player's info.
     *
     * @return StringBuilder.
     */
    @Override
    public StringBuilder getPlayersInfo() {
        return this.playerController.getPlayersInfo();
    }

    /**
     * Getter of the game info.
     *
     * @return StringBuilder.
     */
    @Override
    public StringBuilder getGameInfo() {
        return this.playerController.getGameInfo();
    }

    /**
     * Assigns home panels randomly. Throws and exception if the amount of players and home panels dont match.
     */
    @Override
    public void assignHomePanels() throws PlayersAndHomePanelsDontMatchException {
        ArrayList<IPanel> panels = boardController.getHomePanels();
        ArrayList<IPlayer> players = playerController.getPlayers();
        if (panels.size() != players.size()) {
            throw new PlayersAndHomePanelsDontMatchException();
        }
        for (IPanel panel : panels) {
                // Random player from the players array.
                int ind = new Random().nextInt(players.size());
                // Remove this player.
                IPlayer player = players.remove(ind);
                // Assign.
                this.setHomePanel(player, (HomePanel) panel);
        }
    }

    /**
     * Puts all the players on theirs home panel
     */
    @Override
    public void putPlayersOnHomePanel() {
        ArrayList<IPlayer> players = playerController.getPlayers();
        for (IPlayer player : players) {
            int key = player.getHomePanel().getKey();
            this.movePlayerTo(player, key);
        }
    }

    /**
     * Getter of the players current panel key.
     *
     * @return Array.
     */
    @Override
    public ArrayList<Integer> getPlayersPosition() {
        return this.playerController.getPlayersPosition();
    }

    /**
     * Gets the turn owner roll and move the turn owner.
     */
    @Override
    public void moveTurnOwner() {
        int steps = getTurnOwner().getRoll();
        movePlayer(getTurnOwner(), steps);
    }

    /**
     * Setter of the controller state.
     * Also sets the state controller to this.
     * Triggers the state effect.
     * @param state state.
     */
    @Override
    public void setState(ITurnState state) {
        this.state = state;
        state.setController(this);
        state.handle();
    }

    /**
     * Getter of the name of the state.
     *
     * @return String.
     */
    @Override
    public String getStateName() {
        return state.getName();
    }

    /**
     * Setter of the try to continue answer of the controller state.
     *
     * @param flag boolean.
     */
    @Override
    public void setTryToContinue(boolean flag) {
        state.setTryToContinue(flag);
    }


    /**
     * Setter of the seed for random testing.
     * @param seed Int.
     */
    public void setSeed(int seed) {
        this.playerController.setSeed(seed);
    }

    public static class PlayersAndHomePanelsDontMatchException extends Exception {
    }


    //static class NoSuchPlayerOnTheGameException extends Exception {}
}