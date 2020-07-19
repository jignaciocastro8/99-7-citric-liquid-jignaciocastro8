package com.github.cc3002.citricjuice.model.gameCharacters;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.playerState.IPlayerState;
import com.github.cc3002.citricjuice.model.subject.IPlayerSubject;
import com.github.cc3002.citricliquid.model.NormaGoal;

public interface IPlayer extends ICharacter, IPlayerSubject {
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

    /**
     * Getter of the player state.
     * @return IPlayerState.
     */
    IPlayerState getState();

    /**
     * Tells if the player is moving through the panels.
     * @return boolean.
     */
    boolean isMoving();

    /**
     * Tells if the player is waiting on a panel.
     * @return boolean.
     */
    boolean isWaitingOnPanel();

    /**
     * Sets the player state to wait on panel.
     */
    void waitOnPanel();

    /**
     * Sets the player state to moving.
     */
    void moving();

    /**
     * Sets the player to neutral state.
     */
    void neutralState();

    /**
     * Sets the player state to recovery.
     */
    void recoveryState();

    /**
     * Tells if the player is recovering.
     * @return boolean.
     */
    boolean isRecovering();

    /**
     * Sets the answer of the player for the question: Do you want to play a card?
     * @param answer boolean.
     */
    void setAnswerForPlayCard(boolean answer);

    /**
     * Ask the player if she/he wants to play a card.
     */
    boolean askForPlayCard();

    /**
     * Sets the battle answer.
     * true: the player will battle.
     * false: the player wont battle.
     * @param answer boolean.
     */
    void setAnswerForBattle(boolean answer);

    /**
     * Getter of the battle answer.
     * @return boolean.
     */
    boolean getBattleAnswer();

    /**
     * Getter of the evd or def answer.
     * @return boolean. True: Evd, false: Def.
     */
    boolean getDefOrEvdAnswer();

    /**
     * Setter of the evd or def decision.
     * True: Evd.
     * False: Def.
     * @param answer decision.
     */
    void setEvdOrDefAnswer(boolean answer);

    /**
     * Getter of the player next panel decision.
     * @return IPanel, the next panel.
     */
    IPanel getNextPanelDecision();

    /**
     * Setter of the next panel decision.
     * @param panel IPanel.
     */
    void setNextPanelDecision(IPanel panel);

}
