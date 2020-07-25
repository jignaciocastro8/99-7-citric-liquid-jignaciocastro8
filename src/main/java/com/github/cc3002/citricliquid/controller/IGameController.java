package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

import java.util.ArrayList;
import java.util.Hashtable;

public interface IGameController {

    /**
     * Puts player on panel.
     * @param key Int, key of the IPanel where player will be located.
     * @param player IPlayer.
     */
    void movePlayerTo(IPlayer player, int key) throws PlayerController.NoSuchPlayerOnTheGameException;

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
    void movePlayer(IPlayer player, int steps) throws PlayerController.NoSuchPlayerOnTheGameException;

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

    /**
     * Returns a roll from the turn owner.
     * @return int.
     */
    int rollTurnOwnerDice();

    /**
     * Getter of a string builder with player's info.
     * @return StringBuilder.
     */
    StringBuilder getPlayersInfo();

    /**
     * Getter of the game info.
     * @return StringBuilder.
     */
    StringBuilder getGameInfo();

    /**
     * Assigns home panels randomly.
     */
    void assignHomePanels() throws GameController.PlayersAndHomePanelsDontMatchException;

    /**
     * Puts all the players on theirs home panel
     */
    void putPlayersOnHomePanel();

    /**
     * Getter of the players current panel key. The order is the creation order of the players.
     * @return int.
     */
    ArrayList<Integer> getPlayersPosition();

    /**
     * Gets the turn owner roll and move the turn owner.
     */
    void moveTurnOwner();
}
