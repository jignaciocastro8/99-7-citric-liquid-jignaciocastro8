package com.github.cc3002.citricjuice.model.gameCharacters.playerState;

public class MovingState implements IPlayerState {

    /**
     * Tells if it is a moving state.
     *
     * @return boolean.
     */
    @Override
    public boolean isMoving() {
        return true;
    }

    /**
     * Tells if it is a waiting on panel state.
     *
     * @return boolean.
     */
    @Override
    public boolean isWaitingOnPanel() {
        return false;
    }
}
