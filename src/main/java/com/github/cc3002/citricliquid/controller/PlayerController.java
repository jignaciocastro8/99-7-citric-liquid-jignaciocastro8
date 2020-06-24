package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.IPlayerFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.ArrayList;

public class PlayerController implements IPlayerController {
    private ArrayList<IPlayer> players;
    private IPlayerFactory playerFactory;

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
    public void createPlayer(String name, int hp, int atk, int def, int evd) {
        this.players.add(playerFactory.create(name, hp, atk, def, evd));
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


}
