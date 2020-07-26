package com.github.cc3002.citricjuice.model.subject;

import com.github.cc3002.citricliquid.controller.IPlayerObserver;

public interface IPlayerSubject {
    /**
     * Attaches the subject to an observer,
     * @param observer IObserver
     */
    void attach(IPlayerObserver observer);
    /**
     * Detaches the subject to an observer,
     * @param observer IObserver
     */
    void detach(IPlayerObserver observer);

    /**
     * Notifies its observers.
     */
    void notifyWinner();
}
