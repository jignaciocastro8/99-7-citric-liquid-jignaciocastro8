package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a panel in the board of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *     Muñoz</a>.
 * @version 1.0.6-rc.2
 * @since 1.0
 */
public abstract class Panel {
  private Set<Player> players = new HashSet<>();
  private final PanelType type;
  private final Set<Panel> nextPanels = new HashSet<>();

  /**
   * Create a Panel of type type.
   * @param type: a type from PanelType.
   */
  public Panel(final PanelType type) {
    this.type = type;
  }

  /**
   * Restores a player's HP in 1.
   */
  private static void applyHealTo(final @NotNull Player player) {
    player.setCurrentHP(player.getCurrentHP() + 1);
  }

  /**
   * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
   */
  private static void applyDropTo(final @NotNull Player player) {
    player.reduceStarsBy(player.roll() * player.getNormaLevel());
  }

  /**
   * Reduces the player's star count by the D6 roll multiplied by the maximum between the player's
   * norma level and three.
   */
  private static void applyBonusTo(final @NotNull Player player) {
    player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
  }

  /**
   * Returns the type of this panel
   */
  public PanelType getType() {
    return type;
  }

  /**
   * Returns a copy of this panel's next ones.
   */
  public Set<Panel> getNextPanels() {
    return Set.copyOf(nextPanels);
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel
   *     the panel to be added.
   */
  public void addNextPanel(final Panel panel) {
    nextPanels.add(panel);
  }

  /**
   * Adds a new Player to de panel's set of players.
   * @param player: the player to be added.
   */
  public void addPlayer(Player player) {
    this.players.add(player);
  }

  /**
   * Abstract method, executes the appropriate action to the player according to the
   * panel's type.
   * @param player: the player that activates the panel.
   */
  public abstract void activatedBy(final Player player);
}
