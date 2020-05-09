package com.github.cc3002.citricjuice.model.board;

public class Board {
    /*
    La idea de esta clase es representar al tablero entero. El tablero se modelará como un
    arreglo 2D donde cada casilla será un panel distinto. Puede que no todos las casillas esten
    ocupadas al momento de crear un tablero. Deberá tener más de un constructor.
     */
    private Panel[][] panels;
    public Board(Panel[][] panels) {
        this.panels = panels;
    }

    public Panel[][] getPanels() {
        return this.panels;
    }
}
