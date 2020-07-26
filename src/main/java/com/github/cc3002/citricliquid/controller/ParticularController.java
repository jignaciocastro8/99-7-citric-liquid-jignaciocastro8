package com.github.cc3002.citricliquid.controller;

public abstract class ParticularController {
    protected GameController centralController;

    /**
     * Setter of the central controller.
     * @param centralController GameController.
     */
    public void setCentralController(GameController centralController) {
        this.centralController = centralController;
    }
}
