package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

import java.util.ArrayList;

public interface IGameController {

    /**
     * Puts player on panel.
     * @param key Int, key of the IPanel where player will be located.
     * @param player IPlayer.
     */
    void movePlayerTo(IPlayer player, int key);

    /**
     * Sets home panel of the player.
     * @param player IPlayer.
     * @param panel HomePanel.
     */
    void setHomePanel(IPlayer player, HomePanel panel);

    /**
     * Getter of the chapter.
     * @return Int.
     */
    int getChapter();


    /**
     * Getter of the turn owner.
     * @return IPlayer.
     */
    IPlayer getTurnOwner();

    /**
     * Changes the turn owner to the next one.
     */
    void nextTurn();

    /**
     * Makes the player move steps forward.
     * @param player IPlayer, the player to move.
     * @param steps Int, the amount of steps.
     */
    void movePlayer(IPlayer player, int steps);

    /**
     * Getter of the winner.
     * @return IPlayer.
     */
    IPlayer getWinner();

    /**
     * Returns the names of the players on the game.
     * @return Array with with names as strings.
     */
    ArrayList<String> getPlayersName();
}
