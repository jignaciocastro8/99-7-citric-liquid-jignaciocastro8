package com.github.cc3002.citricjuice.model.gameCharacters;

public class BossUnit extends AbstractUnit implements IEnemy, BattleInterface{
    public BossUnit(String name, int maxHp, int atk, int def, int evd) {
        super(name, maxHp, atk, def, evd);
    }

    @Override
    public void defeat(BattleInterface character) {
        character.defeatedByBoss(this);
    }

    /**
     * Player defeats BossUnit: All the BossUnit's stars goes to the player and
     * the Player increases its wins by one.
     * @param player: Player winner.
     */
    @Override
    public void defeatedByPlayer(Player player) {
        player.increaseWinsBy(this.stars);
        this.reduceStarsBy(this.stars);
        player.increaseWinsBy(3);
    }

    /**
     * BossUnit defeated by WildUnit: half the stars of the BossUnit goes to the WildUnit and
     * WildUnit increases its wins by 3.
     * @param wild: WildUnit winner.
     */
    @Override
    public void defeatedByWild(WildUnit wild) {
        wild.increaseStarsBy((int) Math.floor(this.stars * 0.5));
        this.reduceStarsBy((int) Math.floor(this.stars* 0.5));
        wild.increaseWinsBy(3);
    }

    /**
     * BossUnit defeat BossUnit: Half the loser's stars goes to the winner and winner
     * increases its wins by 3.
     * @param boss: BossUnit winner.
     */
    @Override
    public void defeatedByBoss(BossUnit boss) {
        boss.increaseStarsBy((int) Math.floor(this.stars * 0.5));
        this.reduceStarsBy((int) Math.floor(this.stars * 0.5));
        boss.increaseWinsBy(3);
    }
}
