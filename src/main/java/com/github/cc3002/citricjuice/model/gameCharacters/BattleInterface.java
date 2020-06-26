package com.github.cc3002.citricjuice.model.gameCharacters;

public interface BattleInterface {
    /**
     * Produces the event of defeating.
     * @param character BattleInterface.
     */
    public void defeat(BattleInterface character);

    /**
     * Produces the effect of been defeated by a player.
     * @param player Player.
     */
    public void defeatedByPlayer(Player player);

    /**
     * Produces the effect of been defeated by a wild.
     * @param wild wild.
     */
    public void defeatedByWild(WildUnit wild);
    /**
     * Produces the effect of been defeated by a boss.
     * @param boss boss.
     */
    public void defeatedByBoss(BossUnit boss);

    /**
     * Defend an attack.
     * @param attack Int.
     */
    public void defend(int attack);

    /**
     * Evade an attack.
     * @param attack Int.
     */
    public void evade(int attack);

    /**
     * Attack an enemy.
     * @param character The enemy.
     */
    public void attack(AbstractCharacter character);


    //public void receiveAtk(int netAtk);
}
