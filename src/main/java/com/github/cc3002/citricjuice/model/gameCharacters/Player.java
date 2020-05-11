package com.github.cc3002.citricjuice.model.gameCharacters;

import com.github.cc3002.citricjuice.model.board.HomePanel;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends AbstractCharacter implements BattleInterface {
    private int normaLevel;
    private HomePanel homePanel;

    /**
    * Creates a Player.
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
     * Sets the home panel of the player.
     * @param panel: a HomePanel panel.
     */
    public void setHomePanel(HomePanel panel) {
        this.homePanel = panel;
    }

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

    /**
    * Performs a norma clear action; the {@code norma} counter increases in 1.
    */
    public void normaClear() {
        this.normaLevel++;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        final Player player = (Player) o;
        return getMaxHP() == player.getMaxHP() &&
                getAtk() == player.getAtk() &&
                getDef() == player.getDef() &&
                getEvd() == player.getEvd() &&
                getNormaLevel() == player.getNormaLevel() &&
                getStars() == player.getStars() &&
                getCurrentHP() == player.getCurrentHP() &&
                getName().equals(player.getName());
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
