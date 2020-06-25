package com.github.cc3002.citricjuice.model.gameCharacters.playerState;

public interface IPlayerState {
    /**
     * Tells if it is a moving state.
     * @return boolean.
     */
    boolean isMoving();

    /**
     * Tells if it is a waiting on panel state.
     * @return boolean.
     */
    boolean isWaitingOnPanel();
}
