package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.controller.IBoardObserver;
import com.github.cc3002.citricliquid.controller.IPlayerObserver;
import com.github.cc3002.citricliquid.controller.NullObserver;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class that represents a panel in the board of the game.
 */
public abstract class Panel implements IPanel {
  private final PanelType type;
  private ArrayList<IPanel> nextPanels = new ArrayList<>();
  private ArrayList<IPlayer> players = new ArrayList<>();
  private final int key;
  // Observers.
  private IBoardObserver boardObserver = new NullObserver();
  private IPlayerObserver playerObserver = new NullObserver();


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
   * Attaches the panel to a player observer.
   *
   * @param observer IPlayerObserver.
   */
  @Override
  public void attach(IPlayerObserver observer) {
    this.playerObserver = observer;
  }

  /**
   * Returns a copy of this panel's next ones.
   */
  public ArrayList<IPanel> getNextPanels() {
    return new ArrayList<>(this.nextPanels);
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
   * @param panels
   *     the panels to be added.
   *     There is no loops on the board graph.
   *     If the panel already has a panel as next panel it doesnt get added.
   */
  public void addNextPanel(final IPanel ...panels) {
    for (IPanel panel : panels) {
      if (! panel.equals(this) && !this.nextPanels.contains(panel)) {this.nextPanels.add(panel);}
    }
  }



  /**
   * Adds a new Player to this panel's set of players.
   * Notifies the observer if the player must stops its motion because of this panel current information:
   * There are players on the panel.
   * This panel is the player's home panel.
   * This panel has more than one next panel.
   * @param player: the player to be added.
   */
  public void addPlayer(IPlayer player) {
    // Here we assume that the player to battle with is the first on the panel list of players.
    this.players.add(player);
    // Another player on the panel.
    if (this.getPlayers().size() > 1) {
      IPlayer enemy = this.players.get(0);
      this.notifyPlayersMeet(player, enemy);
    }
    // This is the player's home panel. (the easiest one)
    if (player.getHomePanel().equals(this)) {
      this.notifyPlayerOnHomePanel(player);
    }
    // This panel has more than one next panel.

    if (this.nextPanels.size() > 1) {
      this.notifyMultipleNextPanels(player);
    }



  }

  /**
   * Notifies that the player is on his/hers home panel.
   *
   * @param player IPlayer.
   */
  @Override
  public void notifyPlayerOnHomePanel(IPlayer player) {
    this.playerObserver.playerOnHomePanelUpdate(player);
  }

  /**
   * Notifies the observer that there are more than one players
   * on this panel.
   * @param player IPlayer, the player that enters the panel.
   * @param enemy IPlayer, the enemy.
   */
  @Override
  public void notifyPlayersMeet(IPlayer player, IPlayer enemy) {
    this.boardObserver.playersMeetUpdate(player, enemy);
  }
  /**
   * Notifies that this panel has more than one next panel.
   *
   * @param player IPlayer.
   */
  @Override
  public void notifyMultipleNextPanels(IPlayer player) {
    this.boardObserver.multipleNextPanelsUpdate(player);
  }
  /**
   * Attaches the panel to an observer.
   *
   * @param observer IBoardObserver.
   */
  @Override
  public void attach(IBoardObserver observer) {
    this.boardObserver = observer;
  }

  /**
   * Getter o the players in the panel.
   *
   * @return ArrayList with the players.
   */
  @Override
  public ArrayList<IPlayer> getPlayers() {
    return this.players;
  }

  /**
   * Executes the appropriate action to the player/game according to the
   * panel's type. But first it notifies the observer that is activating its effect on a player and
   * therefore the turn is over.
   * @param player: the player that activates the panel.
   */
  public void activatedBy(IPlayer player) {
    this.notifyTurnIsOver(player);
    this.activatedByParticular(player);
  }

  /**
   * Abstract method, executes the appropriate action to the player/game according to the
   * panel's type.
   * @param player: the player that activates the panel.
   */
  public abstract void activatedByParticular(IPlayer player);

  /**
   * Notifies the observer that the turn is over.
   */
  @Override
  public void notifyTurnIsOver(IPlayer player) {
    this.playerObserver.updateTurnIsOver(player);
  }

  /**
   * Tells if player is on this panel.
   *
   * @param player IPlayer.
   * @return boolean.
   */
  @Override
  public boolean containsCharacter(IPlayer player) {
    return this.players.contains(player);
  }

  /**
   * Removes the player of the panel.
   *
   * @param player IPlayer.
   */
  @Override
  public void removePlayer(IPlayer player) {
    this.players.remove(player);
  }

  /**
   * Returns the number of next panels of this panel.
   *
   * @return int.
   */
  @Override
  public int numberOfNextPanels() {
    return this.nextPanels.size();
  }

  /**
   * Getter of the number of players on the panel.
   *
   * @return Int.
   */
  @Override
  public int numberOfPLayers() {
    return this.players.size();
  }

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
