package com.github.cc3002.citricjuice.model.board;

public interface IBoard {
    IPanel getPanel(int row, int col);
    void addPanel(int row, int col);
}
