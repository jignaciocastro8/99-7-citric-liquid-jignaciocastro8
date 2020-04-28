package com.github.cc3002.citricjuice.model.board;

public class Board {
    private Panel[][] panels;
    public Board(Panel[][] panels) {
        this.panels = panels;
    }

    public Panel[][] getPanels() {
        return this.panels;
    }
}
