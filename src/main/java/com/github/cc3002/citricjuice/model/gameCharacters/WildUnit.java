package com.github.cc3002.citricjuice.model.gameCharacters;

public class WildUnit extends AbstractUnit implements IEnemy, BattleInterface{
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public WildUnit(String name, int maxHp, int atk, int def, int evd) {
        super(name, maxHp, atk, def, evd);
    }

    @Override
    /*
      WildUnit defeat a character.
     */
    public void defeat(BattleInterface character) {
        character.defeatedByWild(this);
    }

    /**
     * Player defeat WildUnit: All the WildUnit's stars goes to the Player and Player's wins
     * increases by one.
     * @param player: Player winner.
     */
    @Override
    public void defeatedByPlayer(Player player) {
        player.increaseStarsBy(this.stars);
        this.reduceStarsBy(this.stars);
        player.increaseWinsBy(1);
    }

    /**
     * WildUnit defeat WildUnit: Half the stars of the loser WildUnit goes to the winner WildUnit
     * and winner's wins increases by 1
     * @param wild: WildUnit winner.
     */
    @Override
    public void defeatedByWild(WildUnit wild) {
        wild.increaseStarsBy((int) Math.floor(this.stars * 0.5));
        this.reduceStarsBy((int) Math.floor(this.stars * 0.5));
        wild.increaseWinsBy(1);
    }

    /**
     * BossUnit defeat WildUnit: Half the WildUnit's stars goes to the BossUnit and BossUnit's
     * wins increases by 1.
     * @param boss: BossUnit winner.
     */
    @Override
    public void defeatedByBoss(BossUnit boss) {
        boss.increaseStarsBy((int) Math.floor(this.stars * 0.5));
        this.reduceStarsBy((int) Math.floor(this.stars * 0.5));
        boss.increaseWinsBy(1);
    }

}
