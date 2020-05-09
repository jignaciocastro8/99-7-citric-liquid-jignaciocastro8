package com.github.cc3002.citricjuice.model.gameCharacters;

import com.github.cc3002.citricjuice.model.board.HomePanel;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends GameCharacter {

    private int normaLevel;
    private int stars;
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
    public void defeatedBy(GameCharacter character) {
        /* NO HACER ESTO, ARREGLARLO.
        POSIBLE SOLUCION: character.defeat(this);
        DONDE EL METODO defeat SERA ABSTRACTO Y CADA CHARACTER LO IMPLEMENTA A SU MANERA.
         */
        if (character instanceof Player) {
            character.increaseWinsBy(2);
            int stars = (int) Math.floor((float) this.getStars() / 2);
            character.increaseStarsBy(stars);
            this.reduceStarsBy(stars);
        }
        if (character instanceof WildUnit || character instanceof BossUnit) {
            int stars = (int) Math.floor((float) this.getStars() / 2);
            character.increaseStarsBy(stars);
            this.reduceStarsBy(stars);
        }
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
    /**
    * Decides if the object o is equal to this player.
    * @param o: Another object.
    */
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

    // Implementación de batallas.

    public void attack(GameCharacter character, int attack) {
        character.increaseStarsBy(attack);
    }
}
