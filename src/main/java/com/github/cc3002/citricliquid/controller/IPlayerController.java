package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.ArrayList;
import java.util.Hashtable;

public interface IPlayerController  {
    /**
     * Creates a player. Stats of the player:
     * @param name Name.
     * @param hp Hp.
     * @param atk Atk.
     * @param def Def.
     * @param evd Evd.
     */
    IPlayer createPlayer(String name, int hp, int atk, int def, int evd);

    /**
     *
     * @param name name.
     * @param hp int.
     * @param atk int.
     * @param def int.
     * @param evd int.
     * @param panel The panel where to put the created player.
     * @return IPlayer.
     */
    IPlayer createPlayerWithPanel(String name, int hp, int atk, int def, int evd, IPanel panel);

    /**
     * Fast method to create suguri.
     */
    IPlayer createSuguri();

    /**
     * Fast method to create marc.
     */
    IPlayer createMarc();

    /**
     * Fast method to create kai.
     * @return IPlayer
     */
    IPlayer createKai();

    /**
     * Fast method to create peat.
     * @return IPlayer.
     */
    IPlayer createPeat();

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

    /**
     * Updates the observer winner data.
     */
    void updateWinner(IPlayer player);

    /**
     * Getter of the game chapter.
     * @return int.
     */
    int getChapter();

    /**
     * Initiate the game.
     */
    void initiateGame();

    /**
     * Getter of the turn owner.
     * @return IPlayer.
     */
    IPlayer getTurnOwner();

    /**
     * Changes the turn owner to the next one.
     */
    void nextTurn();



}
