package com.github.cc3002.citricjuice.model.gameCharacters;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricliquid.model.NormaGoal;

public interface IPlayer extends ICharacter {
    /**
     * Sets the home panel of the player.
     * @param panel: a HomePanel panel.
     */
    public void setHomePanel(HomePanel panel);

    /**
     * Increases attack stat by an amount.
     * @param amount Int.
     */
    public void increaseAtk(int amount);
    /**
     * Reduces attack stat by an amount.
     * @param amount Int.
     */
    public void reduceAtk(int amount);
    /**
     * Increases defend stat by an amount.
     * @param amount Int.
     */
    public void increaseDef(int amount);
    /**
     * Reduces def stat by an amount.
     * @param amount Int.
     */
    public void reduceDef(int amount);
    /**
     * Increases evade stat by an amount.
     * @param amount Int.
     */
    public void increaseEvd(int amount);
    /**
     * Reduces evade stat by an amount.
     * @param amount Int.
     */
    public void reduceEvd(int amount);

    /**
     * Returns the current norma level
     */
    public int getNormaLevel();

    /**
     * Performs a norma clear action; the norma counter increases in 1.
     */
    public void normaClear();
    /**
     * Returns the HomePanel panel of this Player.
     * @return HomePanel.
     */
    HomePanel getHomePanel();

    /**
     * Returns the panel where the player is located.
     * @return IPanel.
     */
    IPanel getCurrentPanel();

    /**
     * Setter of the current panel.
     * @param panel IPanel.
     */
    void setCurrentPanel(IPanel panel);

    /**
     * Setter of the objective of the player.
     * @param objective NormaGoal.
     */
    void setObjective(NormaGoal objective);

    /**
     * Getter of the objective of the player.
     * @return NormaGoal.
     */
    NormaGoal getObjective();
}
