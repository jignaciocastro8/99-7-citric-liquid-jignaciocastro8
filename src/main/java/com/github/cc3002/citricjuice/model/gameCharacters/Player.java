package com.github.cc3002.citricjuice.model.gameCharacters;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.NullHomePanel;
import com.github.cc3002.citricjuice.model.board.NullPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.playerState.*;
import com.github.cc3002.citricliquid.controller.IPlayerObserver;
import com.github.cc3002.citricliquid.controller.NullObserver;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.Objects;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends AbstractCharacter implements IPlayer, BattleInterface {
    private int normaLevel;
    private HomePanel homePanel = new NullHomePanel(-1);
    private IPanel currentPanel;
    private NormaGoal objective;
    private IPlayerState state;
    private boolean playCardAnswer = false;
    private boolean battleAnswer = false;
    private boolean defOrEvdAnswer = false;
    private IPanel nextPanelDecision = new NullPanel();
    private IPlayerObserver observer = new NullObserver();

    /**
    * Creates a Player with null HomePanel.
    * @param name: Name of the player.
    * @param hp : Hit points of the player.
    * @param atk: Base attack of the player.
    * @param def: Base defense of the player.
    * @param evd: Base evasion of the player.
    */
    public Player(final String name, final int hp, final int atk, final int def,
                  final int evd) {
        super(name, hp, atk, def, evd);
        // Every Player starts with norma 1.
        normaLevel = 1;
        // Starts with a null panel.
        this.currentPanel = new NullPanel();
        // Starts with neutral state.
        this.state = new NeutralState();
    }
    /**
     * Creates a Player with a HomePanel
     * @param name: Name of the player.
     * @param hp : Hit points of the player.
     * @param atk: Base attack of the player.
     * @param def: Base defense of the player.
     * @param evd: Base evasion of the player.
     * @param panel: HomePanel of the player.
     */
    public Player(final String name, final int hp, final int atk, final int def,
                  final int evd, HomePanel panel) {
        super(name, hp, atk, def, evd);
        // Every Player starts with norma 1.
        this.normaLevel = 1;
        // Assign the HomePanel.
        this.homePanel = panel;
        // Starts with neutral state.
        this.state = new NeutralState();
    }

    /**
     * Sets the home panel of the player.
     * @param panel: a HomePanel panel.
     */
    public void setHomePanel(HomePanel panel) {
        this.homePanel = panel;
    }

    /**
     * Increases attack stat by an amount.
     * @param amount Int.
     */
    public void increaseAtk(int amount) {
        this.atk += amount;
    }
    /**
     * Reduces attack stat by an amount.
     * @param amount Int.
     */
    public void reduceAtk(int amount) {
        this.atk -= amount;
    }
    /**
     * Increases defend stat by an amount.
     * @param amount Int.
     */
    public void increaseDef(int amount) {
        this.def += amount;
    }
    /**
     * Reduces def stat by an amount.
     * @param amount Int.
     */
    public void reduceDef(int amount) {
        this.def -= amount;
    }
    /**
     * Increases evade stat by an amount.
     * @param amount Int.
     */
    public void increaseEvd(int amount) {
        this.evd += amount;
    }
    /**
     * Reduces evade stat by an amount.
     * @param amount Int.
     */
    public void reduceEvd(int amount) {
        this.evd -= amount;
    }

    /**
     * Returns the HomePanel panel of this Player.
     * @return HomePanel.
     */
    public HomePanel getHomePanel() {
        return this.homePanel;
    }

    /**
     * Returns the panel where the player is located.
     *
     * @return IPanel.
     */
    @Override
    public IPanel getCurrentPanel() {
        return this.currentPanel;
    }

    /**
     * Setter of the current panel.
     *
     * @param panel IPanel.
     */
    @Override
    public void setCurrentPanel(IPanel panel) {
        this.currentPanel = panel;
    }

    /**
     * Setter of the objective of the player.
     *
     * @param objective NormaGoal.
     */
    @Override
    public void setObjective(NormaGoal objective) {
        this.objective = objective;
    }

    /**
     * Getter of the objective of the player.
     *
     * @return NormaGoal.
     */
    @Override
    public NormaGoal getObjective() {
        return this.objective;
    }

    /**
     * Getter of the player state.
     *
     * @return IPlayerState.
     */
    @Override
    public IPlayerState getState() {
        return this.state;
    }

    /**
     * Tells if the player is moving through the panels.
     *
     * @return boolean.
     */
    @Override
    public boolean isMoving() {
        return this.state.isMoving();
    }

    /**
     * Tells if the player is waiting on a panel.
     *
     * @return boolean.
     */
    @Override
    public boolean isWaitingOnPanel() {
        return this.state.isWaitingOnPanel();
    }

    /**
     * Sets the player state to wait on panel.
     */
    @Override
    public void waitOnPanel() {
        this.state = new WaitingOnPanelState();
    }

    /**
     * Sets the player state to moving.
     */
    @Override
    public void moving() {
        this.state = new MovingState();
    }

    /**
     * Sets the player to neutral state.
     */
    @Override
    public void neutralState() {
        this.state = new NeutralState();
    }

    /**
     * Sets the player state to recovery.
     */
    @Override
    public void recoveryState() {
        this.state = new RecoveryState();
    }

    /**
     * Tells if the player is recovering.
     *
     * @return boolean.
     */
    @Override
    public boolean isRecovering() {
        return this.state.isRecovery();
    }

    /**
     * Sets the answer of the player for the question: Do you want to play a card?
     *
     * @param answer boolean.
     */
    @Override
    public void setAnswerForPlayCard(boolean answer) {
        this.playCardAnswer = answer;
    }

    /**
     * Ask the player if she/he wants to play a card.
     */
    @Override
    public boolean askForPlayCard() {
        return this.playCardAnswer;
    }

    /**
     * Sets the battle answer.
     * true: the player will battle.
     * false: the player wont battle.
     *
     * @param answer boolean.
     */
    @Override
    public void setAnswerForBattle(boolean answer) {
        this.battleAnswer = answer;
    }

    /**
     * Getter of the battle answer.
     *
     * @return boolean.
     */
    @Override
    public boolean getBattleAnswer() {
        return this.battleAnswer;
    }

    /**
     * Getter of the evd or def answer.
     *
     * @return boolean. True: Evd, false: Def.
     */
    @Override
    public boolean getDefOrEvdAnswer() {
        return this.defOrEvdAnswer;
    }

    /**
     * Setter of the evd or def decision.
     * True: Evd.
     * False: Def.
     *
     * @param answer decision.
     */
    @Override
    public void setEvdOrDefAnswer(boolean answer) {
        this.defOrEvdAnswer = answer;
    }

    /**
     * Getter of the player next panel decision.
     *
     * @return IPanel, the next panel.
     */
    @Override
    public IPanel getNextPanelDecision() {
        return this.nextPanelDecision;
    }

    /**
     * Setter of the next panel decision.
     *
     * @param panel IPanel.
     */
    @Override
    public void setNextPanelDecision(IPanel panel) {
        this.nextPanelDecision = panel;
    }




    /**
     * Receive the attack and execute the player decision.
     * @param netAtk net attack over the player.
     */
    @Override
    public void receiveAtk(int netAtk) {
        // Here the player must decide if evade or defend.
    }
    /**
    * Returns the current norma level
    */
    public int getNormaLevel() {
        return normaLevel;
      }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return normaLevel == player.normaLevel &&
                Objects.equals(homePanel, player.homePanel);
    }


    /**
    * Performs a norma clear action; the norma counter increases in 1.
     * Notifies the observer if reaches norma 6.
    */
    public void normaClear() {
        this.normaLevel++;
        if (this.normaLevel == 6) {
            this.notifyWinner();
        }
    }



    /**
    * Returns a copy of this character.
    */
    public Player copy() {
        return new Player(name, maxHp, atk, def, evd);
    }

    /**
     * Player defeats character.
     * @param character: Another game character.
     */
    @Override
    public void defeat(BattleInterface character) {
       character.defeatedByPlayer(this);
    }

    /**
     * Player defeats Player: Half the stars of the loser goes to the winner and
     * winner's wins increase by two.
     * @param player: Player winner.
     */
    @Override
    public void defeatedByPlayer(Player player) {
        player.increaseStarsBy((int) Math.floor(this.stars * 0.5));
        this.reduceStarsBy((int) Math.floor(this.stars * 0.5));
        player.increaseWinsBy(2);
    }

    /**
     * WildUnit defeats Player: Half the Player's stars goes to the WildUnit and the
     * WildUnit's wins increases by two.
     * @param wild: WildUnit winner.
     */
    @Override
    public void defeatedByWild(WildUnit wild) {
        wild.increaseStarsBy((int)Math.floor(this.stars * 0.5));
        this.reduceStarsBy((int)Math.floor(this.stars * 0.5));
        wild.increaseWinsBy(2);
    }

    /**
     * BossUnit defeat Player: Half the Player's stars goes to the BossUnit and the BossUnit'wins
     * increases by two.
     * @param boss: BossUnit winner.
     */
    @Override
    public void defeatedByBoss(BossUnit boss) {
        boss.increaseStarsBy((int) Math.floor(this.stars * 0.5));
        this.reduceStarsBy((int) Math.floor(this.stars * 0.5));
        boss.increaseWinsBy(2);
    }

    /**
     * Attaches the subject to an observer,
     *
     * @param observer IObserver
     */
    @Override
    public void attach(IPlayerObserver observer) {
        this.observer = observer;
    }

    /**
     * Detaches the subject to an observer,
     *
     * @param observer IObserver
     */
    @Override
    public void detach(IPlayerObserver observer) {
        this.observer = null;

    }

    /**
     * Notifies its observers.
     */
    @Override
    public void notifyWinner() {
        this.observer.updateWinner(this);
    }
}
