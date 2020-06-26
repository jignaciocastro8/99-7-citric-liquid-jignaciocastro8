package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.IPlayerFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.ArrayList;

public class PlayerController implements IPlayerController {

    private ArrayList<IPlayer> players;

    private IPlayerFactory playerFactory;

    private IPlayer winner;

    public PlayerController() {
        players = new ArrayList<>();
        playerFactory = new PlayerFactory();
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
        // Set the current panel of the playe.
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
        IPlayer player = playerFactory.createSuguri();
        this.players.add(player);
        return player;
    }

    /**
     * Fast method to create marc.
     */
    @Override
    public IPlayer createMarc() {
        IPlayer player = playerFactory.createMarc();
        this.players.add(player);
        return player;
    }

    /**
     * Getter of the player of the game.
     *
     * @return IPlayer[]
     */
    @Override
    public ArrayList<IPlayer> getPlayers() {
        return this.players;
    }

    /**
     * Checks if some player has norma 6.
     *
     * @return boolean
     */
    @Override
    public boolean checkForWinner() {
        boolean boo = false;
        for (IPlayer player : players) {
            if (player.getNormaLevel()==6) {
                this.winner = player;
                boo = true;
                break;
            }
        }
        return boo;
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
}
