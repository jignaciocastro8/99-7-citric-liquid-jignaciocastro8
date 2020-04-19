package com.github.cc3002.citricjuice.model.characters;

import com.github.cc3002.citricjuice.model.board.HomePanel;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends Character {
  private int normaLevel;
  private int stars;
  private final HomePanel homePanel;


  /**
   * Creates a Player.
   * @param name: Name of the player.
   * @param hp : Hit points of the player.
   * @param atk: Base attack of the player.
   * @param def: Base defense of the player.
   * @param evd: Base evasion of the player.
   * @param homePanel: The initial panel of the player.
   */
  public Player(final String name, final int hp, final int atk, final int def,
                final int evd, HomePanel homePanel) {
    super(name, hp, atk, def, evd);
    normaLevel = 1;
    this.homePanel = homePanel;
  }

  /**
   * Returns this player's star count.
   */
  public int getStars() {
    return stars;
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
    normaLevel++;
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
    return getMaxHp() == player.getMaxHp() &&
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
    return new Player(name, maxHp, atk, def, evd, homePanel);
  }
}
