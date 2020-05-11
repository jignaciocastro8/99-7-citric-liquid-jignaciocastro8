package com.github.cc3002.citricjuice.model.gameCharacters;

import com.github.cc3002.citricjuice.model.board.HomePanel;

import java.util.Objects;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends AbstractCharacter implements BattleInterface {
    private int normaLevel;
    private HomePanel homePanel;

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
    * Performs a norma clear action; the {@code norma} counter increases in 1.
    */
    public void normaClear() {
        this.normaLevel++;
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
}
