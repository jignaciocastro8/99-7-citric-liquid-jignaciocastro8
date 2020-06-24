package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.ArrayList;

public interface IPlayerController {
    /**
     * Creates a player. Stats of the player:
     * @param name Name.
     * @param hp Hp.
     * @param atk Atk.
     * @param def Def.
     * @param evd Evd.
     */
    void createPlayer(String name, int hp, int atk, int def, int evd);

    /**
     * Getter of the player of the game.
     * @return IPlayer[]
     */
    ArrayList<IPlayer> getPlayers();

    /**
     * Checks if some player has norma 6.
     * @return boolean
     */
    boolean checkForWinner();

    /**
     * Setter of the objective od the player.
     * @param player IPlayer.
     * @param objective NormaGoal type.
     */
    void setPLayerObjective(IPlayer player, NormaGoal objective);
}
