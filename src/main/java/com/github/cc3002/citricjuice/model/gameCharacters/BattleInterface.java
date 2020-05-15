package com.github.cc3002.citricjuice.model.gameCharacters;

public interface BattleInterface {
    public void defeat(BattleInterface character);
    public void defeatedByPlayer(Player player);
    public void defeatedByWild(WildUnit wild);
    public void defeatedByBoss(BossUnit boss);
    public void defend(int attack);
    public void evade(int attack);
    public void attack(AbstractCharacter character);
    //public void receiveAtk(int netAtk);
}
