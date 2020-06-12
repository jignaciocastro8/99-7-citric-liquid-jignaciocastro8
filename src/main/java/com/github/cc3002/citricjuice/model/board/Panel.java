package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class that represents a panel in the board of the game.
 */
public abstract class Panel implements IPanel {
  private final PanelType type;
  private Set<IPanel> nextPanels = new HashSet<>();
  private Set<Player> players = new HashSet<>();
  private final int key;

  /**
   * Create a Panel of type type.
   * @param type: a type from PanelType.
   */
  public Panel(final PanelType type, final int key) {
    this.type = type;
    this.key = key;
  }

  /**
   * Returns the type of this panel
   */
  @Override
  public PanelType getType() {
    return type;
  }

  /**
   * Returns a copy of this panel's next ones.
   */
  public Set<IPanel> getNextPanels() {
    return Set.copyOf(nextPanels);
  }

  /**
   * Returns the key that this panel will use in the board.
   * @return int key.
   */

  public int getKey() {
    return key;
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel
   *     the panel to be added.
   */
  public void addNextPanel(final IPanel panel) {
    nextPanels.add(panel);
  }

  /**
   * Adds a new Player to de panel's set of players.
   * @param player: the player to be added.
   */
  public void addPlayer(Player player) {
    this.players.add(player);
  }

  public Set<Player> getPlayers() {
    return this.players;
  }


  /**
   * Abstract method, executes the appropriate action to the player/game according to the
   * panel's type.
   * @param player: the player that activates the panel.
   */
  public abstract void activatedBy(final Player player);
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Panel panel = (Panel) o;
    return Objects.equals(players, panel.players) &&
            type == panel.type &&
            Objects.equals(nextPanels, panel.nextPanels) &&
            Objects.equals(key, panel.key);
  }
}
