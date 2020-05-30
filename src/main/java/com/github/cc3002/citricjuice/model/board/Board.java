package com.github.cc3002.citricjuice.model.board;

import java.util.Arrays;

public class Board {
    /*
    La idea de esta clase es representar al tablero entero. El tablero se modelará como un
    arreglo 2D donde cada casilla será un panel distinto. Puede que no todos las casillas esten
    ocupadas al momento de crear un tablero. Deberá tener más de un constructor.
     */
    private IPanel[][] panels;

    public Board(IPanel[][] panels) {
        this.panels = panels;
    }

    public Board(int rows, int cols) {
        this.panels = new IPanel[rows][cols];
    }
    //Este método se podría quitar.
    public IPanel[][] getPanels() {
        return this.panels;
    }
    public IPanel getPanel(int row, int column) {
        return this.panels[row][column];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(panels, board.panels);
    }
}
